package com.urban.gosia.controllers;

import com.urban.gosia.models.dto.CyclicTransactionDto;
import com.urban.gosia.service.CyclicTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
public class CyclicTransactionController {
    private final CyclicTransactionService cyclicTransactionService;

    @Autowired
    public CyclicTransactionController(CyclicTransactionService cyclicTransactionService) {
        this.cyclicTransactionService = cyclicTransactionService;
    }

    @GetMapping("/cyclicTransaction")
    public List<CyclicTransactionDto> findAll(){
        return cyclicTransactionService.findAll();
    }

    @GetMapping("/cyclicTransaction/{id}")
    public CyclicTransactionDto findById(@PathVariable("id") UUID id){
        return cyclicTransactionService.findById(id);
    }
}
