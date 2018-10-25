package com.urban.gosia.transaction.controllers;

import com.urban.gosia.transaction.models.dto.OneTimeTransactionDto;
import com.urban.gosia.transaction.services.OneTimeTransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
public class OneTimeTransactionController {
    private final OneTimeTransactionService oneTimeTransactionService;

    @GetMapping("/oneTimeTransactions")
    public List<OneTimeTransactionDto> fingAll() {
        return oneTimeTransactionService.findAll();
    }

    @GetMapping("/oneTimeTransactions/{id}")
    public OneTimeTransactionDto findById(@PathVariable("id") UUID id) {
        return oneTimeTransactionService.findById(id);
    }
}
