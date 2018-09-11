package com.urban.gosia;

import java.math.BigDecimal;

public class AccountBalanceCreateDTO {
    private BigDecimal balanceValue;
    private int bankAccountId;

    public AccountBalanceCreateDTO() {
    }

    public AccountBalanceCreateDTO(BigDecimal balanceValue, int bankAccountId) {
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
