package com.urban.gosia.models.dto;

import com.urban.gosia.models.OneTimeTransaction;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

public class OneTimeTransactionDto {
    private UUID id;
    private String name;
    private BigDecimal value;
    private OneTimeTransaction.CostDirection costDirection;
    private Date payDate;
    private BankAccountDto bankAccountDto;

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

    public OneTimeTransaction.CostDirection getCostDirection() {
        return costDirection;
    }

    public void setCostDirection(OneTimeTransaction.CostDirection costDirection) {
        this.costDirection = costDirection;
    }

    public Date getPayDate() {
        return payDate;
    }

    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }

    public BankAccountDto getBankAccountDto() {
        return bankAccountDto;
    }

    public void setBankAccountDto(BankAccountDto bankAccountDto) {
        this.bankAccountDto = bankAccountDto;
    }

    public static OneTimeTransactionDto convertToDto(OneTimeTransaction t){
        OneTimeTransactionDto dto = new OneTimeTransactionDto();
        dto.setBankAccountDto(BankAccountDto.convertoToDto(t.getBankAccount()));
        dto.setCostDirection(t.getCostDirection());
        dto.setId(t.getId());
        dto.setName(t.getName());
        dto.setPayDate(t.getPayDate());
        dto.setValue(t.getValue());
        return dto;
    }
}
