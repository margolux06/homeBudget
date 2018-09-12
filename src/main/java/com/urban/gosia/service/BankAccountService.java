package com.urban.gosia.service;

import com.urban.gosia.models.BankAccount;
import com.urban.gosia.repositories.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BankAccountService {
    private final BankAccountRepository accountRepository;

    @Autowired
    public BankAccountService(BankAccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public List<BankAccount> getAccounts() {
        return accountRepository.findAll();
    }

    public Optional<BankAccount> findById(int accountId) {
        return Optional.ofNullable(accountRepository.findOne(accountId));
    }

    public void save(BankAccount account) {
        accountRepository.save(account);
    }

    public void delete(int id) {
        accountRepository.delete(id);
    }
}