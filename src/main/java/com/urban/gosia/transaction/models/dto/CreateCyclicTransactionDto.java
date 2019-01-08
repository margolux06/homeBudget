package com.urban.gosia.transaction.models.dto;

import com.urban.gosia.bankAccount.BankAccount;
import com.urban.gosia.transaction.models.CyclicTransaction;
import com.urban.gosia.transaction.models.CyclicTransactionPeriod;
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
public class CreateCyclicTransactionDto {
    private String name;
    private BigDecimal value;
    private Transaction.CostDirection costDirection;
    private Integer bankAccountId;
    private int trancastionPeriodId;
    private Date firstPayDate;
    private Date lastPayDate;

    public static CyclicTransaction convert(CreateCyclicTransactionDto dto, BankAccount bankAccount, CyclicTransactionPeriod costPeriod) {
        CyclicTransaction transaction = new CyclicTransaction();
        transaction.setFirstPayDate(dto.firstPayDate);
        transaction.setLastPayDate(dto.lastPayDate);
        transaction.setPeriod(costPeriod);
        transaction.setBankAccount(bankAccount);
        transaction.setCostDirection(dto.costDirection);
        transaction.setName(dto.name);
        transaction.setValue(dto.value);
        return transaction;
    }
}
