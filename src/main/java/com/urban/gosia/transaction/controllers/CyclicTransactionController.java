package com.urban.gosia.transaction.controllers;

import com.urban.gosia.transaction.models.dto.CyclicTransactionDto;
import com.urban.gosia.transaction.services.CyclicTransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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
}
