package com.urban.gosia.transaction.services;

import com.urban.gosia.bankAccount.BankAccount;
import com.urban.gosia.bankAccount.BankAccountNotFoundException;
import com.urban.gosia.bankAccount.BankAccountService;
import com.urban.gosia.exceptions.TransactionNotFoundException;
import com.urban.gosia.transaction.models.OneTimeTransaction;
import com.urban.gosia.transaction.models.dto.CreateOneTimeTransactionDto;
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
        return OneTimeTransactionDto.convert(getTransaction(id));
    }

    public OneTimeTransactionDto save(CreateOneTimeTransactionDto dto) throws BankAccountNotFoundException {
        BankAccount bankAccount = null;
        if (dto.getBankAccountId() != null) {
            bankAccount = getBankAccount(dto.getBankAccountId());
        }
        OneTimeTransaction oneTimeTransaction = oneTimeTransactionRepository.save(
                CreateOneTimeTransactionDto.convert(dto, bankAccount));
        return OneTimeTransactionDto.convert(oneTimeTransaction);
    }

    public OneTimeTransactionDto update(OneTimeTransactionDto dto) throws BankAccountNotFoundException {
        OneTimeTransaction oneTimeTransaction = getTransaction(dto.getId());

        if (dto.getBankAccountId() != null) {
            BankAccount bankAccount = getBankAccount(dto.getBankAccountId());
            oneTimeTransaction.setBankAccount(bankAccount);
        }

        oneTimeTransaction.setValue(dto.getValue());
        oneTimeTransaction.setName(dto.getName());
        oneTimeTransaction.setCostDirection(dto.getCostDirection());
        oneTimeTransaction.setPayDate(dto.getPayDate());

        OneTimeTransaction transaction = oneTimeTransactionRepository.save(oneTimeTransaction);
        return OneTimeTransactionDto.convert(transaction);
    }

    private BankAccount getBankAccount(int id) throws BankAccountNotFoundException {
        return bankAccountService.findById(id)
                .orElseThrow(() -> new BankAccountNotFoundException(id));
    }

    private OneTimeTransaction getTransaction(UUID id) {
        return Optional.ofNullable(oneTimeTransactionRepository.findOne(id))
                .orElseThrow(() -> new TransactionNotFoundException(id));
    }

    public void delete(UUID id) {
        oneTimeTransactionRepository.delete(id);
    }
}
