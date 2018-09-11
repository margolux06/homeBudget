package com.urban.gosia.controllers;

import com.urban.gosia.exceptions.BankAccountNotFoundException;
import com.urban.gosia.models.AccountBalance;
import com.urban.gosia.models.BankAccount;
import com.urban.gosia.models.dto.AccountBalanceCreateDto;
import com.urban.gosia.repositories.AccountBalanceRepository;
import com.urban.gosia.service.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class AccountBalanceController {
    private final AccountBalanceRepository balanceRepository;
    private final BankAccountService bankAccountService;

    @Autowired
    public AccountBalanceController(AccountBalanceRepository balanceRepository, BankAccountService bankAccountService) {
        this.balanceRepository = balanceRepository;
        this.bankAccountService = bankAccountService;
    }

    @GetMapping("/accountBalance/{id}")
    public AccountBalance getTopAccountBalance(@PathVariable("id") Integer bankAccountID) {
        Optional<AccountBalance> currentAccountBalance = balanceRepository.findCurrentAccountBalance(bankAccountID);
        return currentAccountBalance.orElse(null);
    }

    @GetMapping("/accountBalance")
    public List<AccountBalance> listAccountBalances() {
        return bankAccountService.getAccounts().stream()
                .map(bankAccount -> getTopAccountBalance(bankAccount.getId()))
                .collect(Collectors.toList());
    }

    @PostMapping("/accountBalance")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Transactional
    public void createAccountBalance(@RequestBody List<AccountBalanceCreateDto> createDTO) {
        createDTO.forEach(accountBalanceCreateDto -> {
            int bankAccountId = accountBalanceCreateDto.getBankAccountId();
            BankAccount bankAccount = bankAccountService.findById(bankAccountId)
                    .orElseThrow(() -> new BankAccountNotFoundException(bankAccountId));
            AccountBalance accountBalance = new AccountBalance(accountBalanceCreateDto.getBalanceValue(), bankAccount);
            balanceRepository.save(accountBalance);

            bankAccount.setCurrentBalance(accountBalanceCreateDto.getBalanceValue());
            bankAccount.setBalanceUpdate(accountBalance.getUpdateDate());

            bankAccountService.save(bankAccount);
        });
    }
}
