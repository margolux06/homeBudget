package com.urban.gosia.models.dto;

import com.urban.gosia.models.CyclicCosts;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

public class CyclicCostsDto {
    private UUID id;
    private String name;
    private BigDecimal value;
    private Date firstPayDate;
    private Date lastPayDate;
    private CyclicCosts.CyclicCostPeriod period;
    private BankAccountDto bankAccount;

    public CyclicCostsDto(String name, BigDecimal value, Date firstPayDate, Date lastPayDate, CyclicCosts.CyclicCostPeriod period, BankAccountDto bankAccount) {
        this.name = name;
        this.value = value;
        this.firstPayDate = firstPayDate;
        this.lastPayDate = lastPayDate;
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

    public CyclicCosts.CyclicCostPeriod getPeriod() {
        return period;
    }

    public void setPeriod(CyclicCosts.CyclicCostPeriod period) {
        this.period = period;
    }

    public BankAccountDto getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccountDto bankAccount) {
        this.bankAccount = bankAccount;
    }
}
