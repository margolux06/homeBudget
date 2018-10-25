package com.urban.gosia.transaction.services;

import com.urban.gosia.transaction.TransactionNotFoundException;
import com.urban.gosia.transaction.models.dto.OneTimeTransactionDto;
import com.urban.gosia.transaction.repository.OneTimeTransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class OneTimeTransactionService {
    private final OneTimeTransactionRepository oneTimeTransactionRepository;

    public List<OneTimeTransactionDto> findAll() {
        return oneTimeTransactionRepository.findAll().stream()
                .map(OneTimeTransactionDto::convertToDto)
                .collect(Collectors.toList());
    }

    public OneTimeTransactionDto findById(UUID id) {
        return Optional.ofNullable(oneTimeTransactionRepository.findOne(id))
                .map(OneTimeTransactionDto::convertToDto)
                .orElseThrow(() -> new TransactionNotFoundException(id));
    }
}
