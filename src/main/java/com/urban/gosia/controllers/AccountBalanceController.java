package com.urban.gosia.controllers;

import com.urban.gosia.models.AccountBalance;
import com.urban.gosia.models.dto.AccountBalanceCreateDto;
import com.urban.gosia.service.AccountBalanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
public class AccountBalanceController {
    private final AccountBalanceService balanceService;

    @Autowired
    public AccountBalanceController(AccountBalanceService balanceService) {
        this.balanceService = balanceService;
    }

    @GetMapping("/accountBalance/{id}")
    public AccountBalance getTopAccountBalance(@PathVariable("id") int bankAccountID) {
        return balanceService.getAccountBalance(bankAccountID);
    }

    @GetMapping("/accountBalance")
    public List<AccountBalance> listAccountBalances() {
        return balanceService.getAccountBalances();
    }

    @PostMapping("/accountBalance")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Transactional
    public void createAccountBalance(@RequestBody List<AccountBalanceCreateDto> createDTO) {
        balanceService.createAccountBalance(createDTO);
    }
}
