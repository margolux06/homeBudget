package com.urban.gosia.accountBalance;

import com.urban.gosia.bankAccount.BankAccount;
import com.urban.gosia.bankAccount.BankAccountNotFoundException;
import com.urban.gosia.bankAccount.BankAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class AccountBalanceService {
    private final AccountBalanceRepository balanceRepository;
    private final BankAccountService bankAccountService;

    AccountBalance getAccountBalance(int bankAccountID) throws BankAccountNotFoundException {
        BankAccount bankAccount = bankAccountService.findById(bankAccountID)
                .orElseThrow(() -> new BankAccountNotFoundException(bankAccountID));
        return balanceRepository.findCurrentAccountBalance(bankAccount.getId())
                .orElse(AccountBalance.empty(bankAccount));
    }

    void createAccountBalance(List<AccountBalanceCreateDto> createDTO) {
        createDTO.forEach(accountBalanceCreateDto -> {
            int bankAccountId = accountBalanceCreateDto.getBankAccountId();

            BankAccount bankAccount = null;
            try {
                bankAccount = bankAccountService.findById(bankAccountId)
                        .orElseThrow(() -> new BankAccountNotFoundException(bankAccountId));

                AccountBalance accountBalance = AccountBalance.builder()
                        .value(accountBalanceCreateDto.getBalanceValue())
                        .bankAccount(bankAccount)
                        .build();
                balanceRepository.save(accountBalance);

                bankAccount.setCurrentBalance(accountBalanceCreateDto.getBalanceValue());
                bankAccount.setBalanceUpdate(accountBalance.getUpdateDate());

                bankAccountService.save(bankAccount);
            } catch (BankAccountNotFoundException e) {
                e.printStackTrace();
            }
        });
    }

    List<AccountBalance> getAccountBalances() {
        return bankAccountService.getAccounts().stream()
                .map(bankAccount -> balanceRepository.findCurrentAccountBalance(bankAccount.getId())
                        .orElse(AccountBalance.empty(bankAccount)))
                .collect(Collectors.toList());
    }
}
