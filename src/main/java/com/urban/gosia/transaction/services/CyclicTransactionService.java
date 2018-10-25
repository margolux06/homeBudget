package com.urban.gosia.transaction.services;

import com.urban.gosia.transaction.TransactionNotFoundException;
import com.urban.gosia.transaction.models.dto.CyclicTransactionDto;
import com.urban.gosia.transaction.repository.CyclicTransactinRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CyclicTransactionService {
    private final CyclicTransactinRepository cyclicTransactinRepository;

    public List<CyclicTransactionDto> findAll() {
        return cyclicTransactinRepository.findAll().stream()
                .map(CyclicTransactionDto::convertToDto)
                .collect(Collectors.toList());
    }

    public CyclicTransactionDto findById(UUID id) {
        return Optional.ofNullable(cyclicTransactinRepository.findOne(id))
                .map(CyclicTransactionDto::convertToDto)
                .orElseThrow(() -> new TransactionNotFoundException(id));
    }
}
