package com.urban.gosia.service;

import com.urban.gosia.models.dto.CostsDto;
import com.urban.gosia.repositories.CostsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CostsService {
    private final CostsRepository costsRepository;

    @Autowired
    public CostsService(CostsRepository costsRepository) {
        this.costsRepository = costsRepository;
    }

    public List<CostsDto> findAll() {
        new CostsDto();
        return costsRepository.findAll().stream()
                .map(CostsDto::convertToDto)
                .collect(Collectors.toList());
    }
}
