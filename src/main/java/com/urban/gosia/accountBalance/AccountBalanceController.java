package com.urban.gosia.accountBalance;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class AccountBalanceController {
    private final AccountBalanceService balanceService;

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
