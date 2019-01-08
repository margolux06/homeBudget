package com.urban.gosia.transaction.controllers;

import com.urban.gosia.transaction.models.CyclicTransactionPeriod;
import com.urban.gosia.transaction.services.CyclicTransactionPeriodService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/cyclicPeriod")
public class CyclicTransactionPeriodController {
    private final CyclicTransactionPeriodService service;

    @GetMapping
    public List<CyclicTransactionPeriod> findAll(){
        return service.findAll();
    }
}
