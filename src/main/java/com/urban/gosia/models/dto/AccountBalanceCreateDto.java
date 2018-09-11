package com.urban.gosia.models.dto;

import java.math.BigDecimal;

public class AccountBalanceCreateDto {
    private BigDecimal balanceValue;
    private int bankAccountId;

    public AccountBalanceCreateDto() {
    }

    public AccountBalanceCreateDto(BigDecimal balanceValue, int bankAccountId) {
        this.balanceValue = balanceValue;
        this.bankAccountId = bankAccountId;
    }

    public BigDecimal getBalanceValue() {
        return balanceValue;
    }

    public void setBalanceValue(BigDecimal balanceValue) {
        this.balanceValue = balanceValue;
    }

    public int getBankAccountId() {
        return bankAccountId;
    }

    public void setBankAccountId(int bankAccountId) {
        this.bankAccountId = bankAccountId;
    }
}
