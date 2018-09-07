package com.urban.gosia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
