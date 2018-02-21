package com.urban.gosia;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BankAccountController {

    @GetMapping("/accountList")
    public List<BankAccount> listBankAccounts() {
        List<BankAccount> accountList = new ArrayList<>();
        accountList.add(new BankAccount("Test first account name"));
        accountList.add(new BankAccount("Test second account name"));
        return accountList;
    }
}
