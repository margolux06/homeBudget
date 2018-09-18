package com.urban.gosia.controllers;

import com.urban.gosia.models.dto.OneTimeTransactionDto;
import com.urban.gosia.service.OneTimeTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OneTimeTransactionController {
    private final OneTimeTransactionService oneTimeTransactionService;

    @Autowired
    public OneTimeTransactionController(OneTimeTransactionService oneTimeTransactionService) {
        this.oneTimeTransactionService = oneTimeTransactionService;
    }

    @GetMapping("/costs")
    public List<OneTimeTransactionDto> fingAll(){
        return oneTimeTransactionService.findAll();
    }

}
