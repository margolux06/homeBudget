package com.urban.gosia.transaction.controllers;

import com.urban.gosia.transaction.models.dto.CreateOneTimeTransactionDto;
import com.urban.gosia.transaction.models.dto.OneTimeTransactionDto;
import com.urban.gosia.transaction.services.OneTimeTransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/oneTimeTransactions")
public class OneTimeTransactionController {
    private final OneTimeTransactionService oneTimeTransactionService;

    @GetMapping
    public List<OneTimeTransactionDto> fingAll() {
        return oneTimeTransactionService.findAll();
    }

    @GetMapping("/{id}")
    public OneTimeTransactionDto findById(@PathVariable("id") UUID id) {
        return oneTimeTransactionService.findById(id);
    }

    @PostMapping
    public OneTimeTransactionDto save(@RequestBody CreateOneTimeTransactionDto dto){
        return oneTimeTransactionService.save(dto);
    }

    @PutMapping
    public OneTimeTransactionDto update(@RequestBody OneTimeTransactionDto dto){
        return oneTimeTransactionService.update(dto);
    }
}
