package com.urban.gosia.transaction.models;

import com.urban.gosia.bankAccount.BankAccount;
import com.urban.gosia.transaction.models.dto.CyclicTransactionDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "CyclicTransaction")
@Table(name = "CyclicTransaction")
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CyclicTransaction extends Transaction {


    public enum CyclicCostPeriod {
        PER_WEEK,
        PER_MONTH,
        PER_THREE_MONTHS,
        PER_YEAR;
    }

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date firstPayDate;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastPayDate;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private CyclicCostPeriod period;

    public CyclicTransaction update(CyclicTransactionDto dto, BankAccount bankAccount) {
        setName(dto.getName());
        setValue(dto.getValue());
        setFirstPayDate(dto.getFirstPayDate());
        setLastPayDate(dto.getLastPayDate());
        setCostDirection(dto.getCostDirection());
        setPeriod(dto.getPeriod());
        setBankAccount(bankAccount);
        return this;
    }
}
