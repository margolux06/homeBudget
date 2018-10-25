package com.urban.gosia.bankAccount;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class BankAccountService {
    private final BankAccountRepository accountRepository;

    public List<BankAccount> getAccounts() {
        return accountRepository.findAll();
    }

    public Optional<BankAccount> findById(int accountId) {
        return Optional.ofNullable(accountRepository.findOne(accountId));
    }

    public void save(BankAccount account) {
        accountRepository.save(account);
    }

    void delete(int id) {
        accountRepository.delete(id);
    }
}
