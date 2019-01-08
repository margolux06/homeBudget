package com.urban.gosia.transaction.models.dto;

import com.urban.gosia.transaction.models.CyclicTransaction;
import com.urban.gosia.transaction.models.CyclicTransactionPeriod;
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
public class CyclicTransactionDto {
    private UUID id;
    private String name;
    private BigDecimal value;
    private Date firstPayDate;
    private Date lastPayDate;
    private Transaction.CostDirection costDirection;
    private CyclicTransactionPeriod period;
    private Integer bankAccountId;

    public static CyclicTransactionDto convertToDto(CyclicTransaction transaction) {
        return CyclicTransactionDto.builder()
                .id(transaction.getId())
                .name(transaction.getName())
                .value(transaction.getValue())
                .firstPayDate(transaction.getFirstPayDate())
                .lastPayDate(transaction.getLastPayDate())
                .costDirection(transaction.getCostDirection())
                .period(transaction.getPeriod())
                .bankAccountId(transaction.getBankAccount() != null ?
                        transaction.getBankAccount().getId() : null)
                .build();
    }
}
