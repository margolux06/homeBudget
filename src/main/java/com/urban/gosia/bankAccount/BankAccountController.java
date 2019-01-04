package com.urban.gosia.bankAccount;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class BankAccountController {
    private final BankAccountService bankAccountService;

    @GetMapping("/account")
    public List<BankAccount> listBankAccounts() {
        return bankAccountService.getAccounts();
    }

    @GetMapping("/account/{id}")
    public BankAccount findBankAccountById(@PathVariable("id") int id) throws BankAccountNotFoundException {
        return bankAccountService.findById(id)
                .orElseThrow(() -> new BankAccountNotFoundException(id));
    }

    @PostMapping("/account")
    @ResponseStatus(HttpStatus.OK)
    public void createAccount(@RequestBody BankAccountDto accountDto) {
        bankAccountService.save(accountDto.convert());
    }

    @DeleteMapping("/account/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteAccount(@PathVariable("id") int id) {
        bankAccountService.delete(id);
    }
}
