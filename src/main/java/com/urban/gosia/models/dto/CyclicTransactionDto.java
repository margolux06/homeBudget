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
    private BankAccountDto bankAccountDto;

    public CyclicTransactionDto() {
    }

    public CyclicTransactionDto(String name, BigDecimal value, Date firstPayDate, Date lastPayDate, Transaction.CostDirection costDirection, CyclicTransaction.CyclicCostPeriod period, BankAccountDto bankAccountDto) {
        this.name = name;
        this.value = value;
        this.firstPayDate = firstPayDate;
        this.lastPayDate = lastPayDate;
        this.costDirection = costDirection;
        this.period = period;
        this.bankAccountDto = bankAccountDto;
    }

    public static CyclicTransactionDto convertToDto(CyclicTransaction transaction) {
        CyclicTransactionDto dto = new CyclicTransactionDto();
        dto.setBankAccountDto(BankAccountDto.convertoToDto(transaction.getBankAccount()));
        dto.setCostDirection(transaction.getCostDirection());
        dto.setFirstPayDate(transaction.getFirstPayDate());
        dto.setId(transaction.getId());
        dto.setLastPayDate(transaction.getLastPayDate());
        dto.setName(transaction.getName());
        dto.setPeriod(transaction.getPeriod());
        dto.setValue(transaction.getValue());
        return dto;
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

    public BankAccountDto getBankAccountDto() {
        return bankAccountDto;
    }

    public void setBankAccountDto(BankAccountDto bankAccountDto) {
        this.bankAccountDto = bankAccountDto;
    }
}
