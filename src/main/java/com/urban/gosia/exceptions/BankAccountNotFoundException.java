package com.urban.gosia.exceptions;

public class BankAccountNotFoundException extends RuntimeException {
    private final int bankAccountId;

    public BankAccountNotFoundException(int bankAccountId) {
        this.bankAccountId = bankAccountId;
    }

    public int getBankAccountId() {
        return bankAccountId;
    }
}
