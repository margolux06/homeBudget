package com.urban.gosia.controllers;

import com.urban.gosia.BankAccountDto;
import com.urban.gosia.repositories.BankAccountRepository;
import com.urban.gosia.models.BankAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BankAccountController {

    private final BankAccountRepository bankAccountRepository;

    @Autowired
    public BankAccountController(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }

    @GetMapping("/account")
    public List<BankAccount> listBankAccounts() {
        return bankAccountRepository.findAll();
    }

    @GetMapping("/account/{id}")
    public BankAccount findBankAccountById(@PathVariable("id") Integer id){
        return bankAccountRepository.findOne(id);
    }

    @PostMapping("/account")
    @ResponseStatus(HttpStatus.OK)
    public void createAccount(@RequestBody BankAccountDto accountDto){
        BankAccount bankAccount = accountDto.convert();
        bankAccountRepository.save(bankAccount);
    }

    @DeleteMapping("/account/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteAccount(@PathVariable("id") Integer id){
        bankAccountRepository.delete(id);
    }
}
