package com.urban.gosia.transaction.controllers;

import com.urban.gosia.bankAccount.BankAccountNotFoundException;
import com.urban.gosia.transaction.models.dto.CreateCyclicTransactionDto;
import com.urban.gosia.transaction.models.dto.CyclicTransactionDto;
import com.urban.gosia.transaction.services.CyclicTransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
public class CyclicTransactionController {
    private final CyclicTransactionService cyclicTransactionService;

    @GetMapping("/cyclicTransaction")
    public List<CyclicTransactionDto> findAll() {
        return cyclicTransactionService.findAll();
    }

    @GetMapping("/cyclicTransaction/{id}")
    public CyclicTransactionDto findById(@PathVariable("id") UUID id) {
        return cyclicTransactionService.findById(id);
    }

    @PostMapping
    public CyclicTransactionDto save(@RequestBody CreateCyclicTransactionDto dto) throws BankAccountNotFoundException {
        return cyclicTransactionService.save(dto);
    }

    @PutMapping
    public CyclicTransactionDto update(@RequestBody CyclicTransactionDto dto) throws BankAccountNotFoundException {
        return cyclicTransactionService.update(dto);
    }

    @DeleteMapping("/cyclicTransaction/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") UUID id) {
        cyclicTransactionService.delete(id);
    }
}
