package com.urban.gosia.controllers;

import com.urban.gosia.models.dto.CostsDto;
import com.urban.gosia.service.CostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CostsController {
    private final CostsService costsService;

    @Autowired
    public CostsController(CostsService costsService) {
        this.costsService = costsService;
    }

    @GetMapping("/costs")
    public List<CostsDto> fingAll(){
        return costsService.findAll();
    }

}
