package com.urban.gosia.transaction.services;

import com.urban.gosia.bankAccount.BankAccount;
import com.urban.gosia.bankAccount.BankAccountNotFoundException;
import com.urban.gosia.bankAccount.BankAccountService;
import com.urban.gosia.transaction.TransactionNotFoundException;
import com.urban.gosia.transaction.models.OneTimeTransaction;
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
    private final BankAccountService bankAccountService;

    public List<OneTimeTransactionDto> findAll() {
        return oneTimeTransactionRepository.findAll().stream()
                .map(OneTimeTransactionDto::convert)
                .collect(Collectors.toList());
    }

    public OneTimeTransactionDto findById(UUID id) {
        return Optional.ofNullable(oneTimeTransactionRepository.findOne(id))
                .map(OneTimeTransactionDto::convert)
                .orElseThrow(() -> new TransactionNotFoundException(id));
    }

    public OneTimeTransactionDto save(OneTimeTransactionDto oneTimeTransactionDto) {
        BankAccount bankAccount = bankAccountService.findById(oneTimeTransactionDto.getBankAccountDto().getId())
                .orElseThrow(() -> new BankAccountNotFoundException(oneTimeTransactionDto.getBankAccountDto().getId()));
        OneTimeTransaction oneTimeTransaction = oneTimeTransactionRepository.save(
                OneTimeTransactionDto.convert(oneTimeTransactionDto, bankAccount));
        return OneTimeTransactionDto.convert(oneTimeTransaction);
    }
}
