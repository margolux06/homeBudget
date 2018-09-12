package com.urban.gosia.service;

import com.urban.gosia.exceptions.BankAccountNotFoundException;
import com.urban.gosia.models.AccountBalance;
import com.urban.gosia.models.BankAccount;
import com.urban.gosia.models.dto.AccountBalanceCreateDto;
import com.urban.gosia.repositories.AccountBalanceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountBalanceService {
    private final AccountBalanceRepository balanceRepository;
    private final BankAccountService bankAccountService;

    public AccountBalanceService(AccountBalanceRepository balanceRepository, BankAccountService bankAccountService) {
        this.balanceRepository = balanceRepository;
        this.bankAccountService = bankAccountService;
    }


    public AccountBalance getAccountBalance(int bankAccountID) {
        BankAccount bankAccount = bankAccountService.findById(bankAccountID)
                .orElseThrow(() -> new BankAccountNotFoundException(bankAccountID));
        return balanceRepository.findCurrentAccountBalance(bankAccount.getId())
                .orElse(AccountBalance.empty(bankAccount));
    }

    public void createAccountBalance(List<AccountBalanceCreateDto> createDTO) {
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

    public List<AccountBalance> getAccountBalances() {
        return bankAccountService.getAccounts().stream()
                .map(bankAccount -> getAccountBalance(bankAccount.getId()))
                .collect(Collectors.toList());
    }
}
