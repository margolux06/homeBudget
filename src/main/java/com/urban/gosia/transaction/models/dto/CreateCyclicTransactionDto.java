package com.urban.gosia.transaction.models.dto;

import com.urban.gosia.bankAccount.BankAccount;
import com.urban.gosia.transaction.models.CyclicTransaction;
import com.urban.gosia.transaction.models.Transaction;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateCyclicTransactionDto {
    private String name;
    private BigDecimal value;
    private Transaction.CostDirection costDirection;
    private int bankAccountId;
    private CyclicTransaction.CyclicCostPeriod period;
    private Date firstPayDate;
    private Date lastPayDate;

    public static CyclicTransaction convert(CreateCyclicTransactionDto dto, BankAccount bankAccount) {
        CyclicTransaction transaction = new CyclicTransaction();
        transaction.setFirstPayDate(dto.firstPayDate);
        transaction.setLastPayDate(dto.lastPayDate);
        transaction.setPeriod(dto.period);
        transaction.setBankAccount(bankAccount);
        transaction.setCostDirection(dto.costDirection);
        transaction.setName(dto.name);
        transaction.setValue(dto.value);
        return transaction;
    }
}
