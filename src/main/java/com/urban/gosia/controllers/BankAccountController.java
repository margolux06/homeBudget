package com.urban.gosia.controllers;

import com.urban.gosia.BankAccountDto;
import com.urban.gosia.exceptions.BankAccountNotFoundException;
import com.urban.gosia.models.BankAccount;
import com.urban.gosia.service.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BankAccountController {
    private final BankAccountService bankAccountService;

    @Autowired
    public BankAccountController(BankAccountService bankAccountService) {
        this.bankAccountService = bankAccountService;
    }

    @GetMapping("/account")
    public List<BankAccount> listBankAccounts() {
        return bankAccountService.getAccounts();
    }

    @GetMapping("/account/{id}")
    public BankAccount findBankAccountById(@PathVariable("id") int id){
        return bankAccountService.findById(id).orElseThrow(() -> new BankAccountNotFoundException(id));
    }

    @PostMapping("/account")
    @ResponseStatus(HttpStatus.OK)
    public void createAccount(@RequestBody BankAccountDto accountDto){
        bankAccountService.save(accountDto.convert());
    }

    @DeleteMapping("/account/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteAccount(@PathVariable("id") int id){
        bankAccountService.delete(id);
    }
}
