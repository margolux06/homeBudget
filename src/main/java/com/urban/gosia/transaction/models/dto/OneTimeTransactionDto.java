package com.urban.gosia.transaction.models.dto;

import com.urban.gosia.bankAccount.BankAccount;
import com.urban.gosia.bankAccount.BankAccountDto;
import com.urban.gosia.transaction.models.OneTimeTransaction;
import com.urban.gosia.transaction.models.Transaction;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class OneTimeTransactionDto {
    private UUID id;
    private String name;
    private BigDecimal value;
    private Transaction.CostDirection costDirection;
    private Date payDate;
    private BankAccountDto bankAccountDto;

    public static OneTimeTransactionDto convert(OneTimeTransaction t) {
        return OneTimeTransactionDto.builder()
                .id(t.getId())
                .name(t.getName())
                .value(t.getValue())
                .costDirection(t.getCostDirection())
                .payDate(t.getPayDate())
                .bankAccountDto(BankAccountDto.convertoToDto(t.getBankAccount()))
                .build();
    }

    public static OneTimeTransaction convert(OneTimeTransactionDto dto, BankAccount bankAccount) {
        OneTimeTransaction transaction = new OneTimeTransaction();
        transaction.setPayDate(dto.payDate);
        transaction.setBankAccount(bankAccount);
        transaction.setCostDirection(dto.costDirection);
        transaction.setName(dto.name);
        transaction.setValue(dto.value);
        if (dto.getId() != null) {
            transaction.setId(dto.id);
        }
        return transaction;
    }
}
