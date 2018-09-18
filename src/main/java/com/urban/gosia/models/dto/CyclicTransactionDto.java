package com.urban.gosia.models.dto;

import com.urban.gosia.models.CyclicTransaction;
import com.urban.gosia.models.OneTimeTransaction;
import com.urban.gosia.models.Transaction;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

public class CyclicTransactionDto {
    private UUID id;
    private String name;
    private BigDecimal value;
    private Date firstPayDate;
    private Date lastPayDate;
    private OneTimeTransaction.CostDirection costDirection;
    private CyclicTransaction.CyclicCostPeriod period;
    private BankAccountDto bankAccount;

    public CyclicTransactionDto(String name, BigDecimal value, Date firstPayDate, Date lastPayDate, Transaction.CostDirection costDirection, CyclicTransaction.CyclicCostPeriod period, BankAccountDto bankAccount) {
        this.name = name;
        this.value = value;
        this.firstPayDate = firstPayDate;
        this.lastPayDate = lastPayDate;
        this.costDirection = costDirection;
        this.period = period;
        this.bankAccount = bankAccount;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public Date getFirstPayDate() {
        return firstPayDate;
    }

    public void setFirstPayDate(Date firstPayDate) {
        this.firstPayDate = firstPayDate;
    }

    public Date getLastPayDate() {
        return lastPayDate;
    }

    public void setLastPayDate(Date lastPayDate) {
        this.lastPayDate = lastPayDate;
    }

    public OneTimeTransaction.CostDirection getCostDirection() {
        return costDirection;
    }

    public void setCostDirection(OneTimeTransaction.CostDirection costDirection) {
        this.costDirection = costDirection;
    }

    public CyclicTransaction.CyclicCostPeriod getPeriod() {
        return period;
    }

    public void setPeriod(CyclicTransaction.CyclicCostPeriod period) {
        this.period = period;
    }

    public BankAccountDto getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccountDto bankAccount) {
        this.bankAccount = bankAccount;
    }
}
