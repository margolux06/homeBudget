package com.urban.gosia.controllers;

import com.urban.gosia.AccountBalanceCreateDTO;
import com.urban.gosia.models.AccountBalance;
import com.urban.gosia.models.BankAccount;
import com.urban.gosia.repositories.AccountBalanceRepository;
import com.urban.gosia.repositories.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class AccountBalanceController {
    private final BankAccountRepository accountRepository;
    private final AccountBalanceRepository balanceRepository;
    private final BankAccountController bankAccountController;

    @Autowired
    public AccountBalanceController(BankAccountRepository accountRepository, AccountBalanceRepository balanceRepository, BankAccountController bankAccountController) {
        this.accountRepository = accountRepository;
        this.balanceRepository = balanceRepository;
        this.bankAccountController = bankAccountController;
    }

    @GetMapping("/accountBalance/{id}")
    public AccountBalance getTopAccountBalance(@PathVariable("id") Integer bankAccountID) {
        Optional<AccountBalance> currentAccountBalance = balanceRepository.findCurrentAccountBalance(bankAccountID);
        return currentAccountBalance.orElse(null);
    }

    @GetMapping("/accountBalance")
    public List<AccountBalance> listAccountBalances() {
        return bankAccountController.listBankAccounts().stream()
                .map(bankAccount -> getTopAccountBalance(bankAccount.getId()))
                .collect(Collectors.toList());
    }

    @PostMapping("/accountBalance")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Transactional
    public void createAccountBalance(@RequestBody List<AccountBalanceCreateDTO> createDTO) {
        createDTO.forEach(accountBalanceCreateDTO -> {
            BankAccount bankAccount = bankAccountController.findBankAccountById(accountBalanceCreateDTO.getBankAccountId());
            AccountBalance accountBalance = new AccountBalance(accountBalanceCreateDTO.getBalanceValue(), bankAccount);
            balanceRepository.save(accountBalance);

            bankAccount.setCurrentBalance(accountBalanceCreateDTO.getBalanceValue());
            bankAccount.setBalanceUpdate(accountBalance.getUpdateDate());

            accountRepository.save(bankAccount);
        });
    }
}
