package com.urban.gosia.service;

import com.urban.gosia.models.dto.CyclicTransactionDto;
import com.urban.gosia.repositories.CyclicTransactinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CyclicTransactionService {
    private final CyclicTransactinRepository cyclicTransactinRepository;

    @Autowired
    public CyclicTransactionService(CyclicTransactinRepository cyclicTransactinRepository) {
        this.cyclicTransactinRepository = cyclicTransactinRepository;
    }

    public List<CyclicTransactionDto> findAll() {
        return cyclicTransactinRepository.findAll().stream()
                .map(CyclicTransactionDto::convertToDto)
                .collect(Collectors.toList());
    }
}
