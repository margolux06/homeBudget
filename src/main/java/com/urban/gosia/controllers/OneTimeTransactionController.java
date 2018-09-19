package com.urban.gosia.controllers;

import com.urban.gosia.models.dto.OneTimeTransactionDto;
import com.urban.gosia.service.OneTimeTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
public class OneTimeTransactionController {
    private final OneTimeTransactionService oneTimeTransactionService;

    @Autowired
    public OneTimeTransactionController(OneTimeTransactionService oneTimeTransactionService) {
        this.oneTimeTransactionService = oneTimeTransactionService;
    }

    @GetMapping("/oneTimeTransactions")
    public List<OneTimeTransactionDto> fingAll(){
        return oneTimeTransactionService.findAll();
    }

    @GetMapping("/oneTimeTransactions/{id}")
    public OneTimeTransactionDto findById(@PathVariable("id") UUID id){
        return oneTimeTransactionService.findById(id);
    }
}
