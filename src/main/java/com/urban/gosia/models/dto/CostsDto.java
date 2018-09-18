package com.urban.gosia.models.dto;

import com.urban.gosia.models.Costs;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

public class CostsDto {
    private UUID id;
    private String name;
    private BigDecimal value;
    private Costs.CostDirection costDirection;
    private Date payDate;
    private BankAccountDto bankAccount;

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

    public Costs.CostDirection getCostDirection() {
        return costDirection;
    }

    public void setCostDirection(Costs.CostDirection costDirection) {
        this.costDirection = costDirection;
    }

    public Date getPayDate() {
        return payDate;
    }

    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }

    public BankAccountDto getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccountDto bankAccount) {
        this.bankAccount = bankAccount;
    }

    public static CostsDto convertToDto(Costs costs){
        CostsDto costsDto = new CostsDto();
        costsDto.setBankAccount(BankAccountDto.convertoToDto(costs.getBankAccount()));
        costsDto.setCostDirection(costs.getCostDirection());
        costsDto.setId(costs.getId());
        costsDto.setName(costs.getName());
        costsDto.setPayDate(costs.getPayDate());
        costsDto.setValue(costs.getValue());
        return costsDto;
    }
}
