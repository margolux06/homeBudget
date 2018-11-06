package com.urban.gosia.transaction.models.dto;

import com.urban.gosia.bankAccount.BankAccount;
import com.urban.gosia.transaction.models.OneTimeTransaction;
import com.urban.gosia.transaction.models.Transaction;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CreateOneTimeTransactionDto {
    private String name;
    private BigDecimal value;
    private Transaction.CostDirection costDirection;
    private Date payDate;
    private int bankAccountId;

    public static OneTimeTransaction convert(CreateOneTimeTransactionDto dto, BankAccount bankAccount) {
        OneTimeTransaction transaction = new OneTimeTransaction();
        transaction.setPayDate(dto.payDate);
        transaction.setBankAccount(bankAccount);
        transaction.setCostDirection(dto.costDirection);
        transaction.setName(dto.name);
        transaction.setValue(dto.value);
        return transaction;
    }
}
