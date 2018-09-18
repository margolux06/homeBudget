package com.urban.gosia.service;

import com.urban.gosia.models.dto.OneTimeTransactionDto;
import com.urban.gosia.repositories.OneTimeTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OneTimeTransactionService {
    private final OneTimeTransactionRepository oneTimeTransactionRepository;

    @Autowired
    public OneTimeTransactionService(OneTimeTransactionRepository oneTimeTransactionRepository) {
        this.oneTimeTransactionRepository = oneTimeTransactionRepository;
    }

    public List<OneTimeTransactionDto> findAll() {
        new OneTimeTransactionDto();
        return oneTimeTransactionRepository.findAll().stream()
                .map(OneTimeTransactionDto::convertToDto)
                .collect(Collectors.toList());
    }
}
