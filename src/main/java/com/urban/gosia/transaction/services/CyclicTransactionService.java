package com.urban.gosia.transaction.services;

import com.urban.gosia.bankAccount.BankAccount;
import com.urban.gosia.bankAccount.BankAccountNotFoundException;
import com.urban.gosia.bankAccount.BankAccountService;
import com.urban.gosia.exceptions.TransactionNotFoundException;
import com.urban.gosia.transaction.models.CyclicTransaction;
import com.urban.gosia.transaction.models.dto.CreateCyclicTransactionDto;
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
    private final BankAccountService bankAccountService;

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

    public CyclicTransactionDto save(CreateCyclicTransactionDto dto) throws BankAccountNotFoundException {
        BankAccount bankAccount = null;
        if (dto.getBankAccountId() != null) {
            bankAccount = getBankAccount(dto.getBankAccountId());
        }
        CyclicTransaction transaction = CreateCyclicTransactionDto.convert(dto, bankAccount);

        CyclicTransaction cyclicTransaction = cyclicTransactinRepository.save(transaction);
        return CyclicTransactionDto.convertToDto(cyclicTransaction);
    }

    public CyclicTransactionDto update(CyclicTransactionDto dto) throws BankAccountNotFoundException {
        CyclicTransaction transaction = Optional.ofNullable(cyclicTransactinRepository.findOne(dto.getId()))
                .orElseThrow(() -> new TransactionNotFoundException(dto.getId()));

        BankAccount bankAccount = null;
        if (dto.getBankAccountId() != null) {
            bankAccount = getBankAccount(dto.getBankAccountId());
        }

        transaction.update(dto, bankAccount);
        transaction = cyclicTransactinRepository.save(transaction);

        return CyclicTransactionDto.convertToDto(transaction);
    }

    private BankAccount getBankAccount(int bankAccuntID) throws BankAccountNotFoundException {
        return bankAccountService.findById(bankAccuntID)
                .orElseThrow(() -> new BankAccountNotFoundException(bankAccuntID));
    }

    public void delete(UUID id) {
        cyclicTransactinRepository.delete(id);
    }
}
