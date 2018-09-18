package com.urban.gosia.controllers;

import com.urban.gosia.models.dto.CyclicTransactionDto;
import com.urban.gosia.service.CyclicTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
}
