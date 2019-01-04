package com.urban.gosia.bankAccount;

import lombok.Data;

@Data
public class BankAccountNotFoundException extends Exception {
    private final int bankAccountId;
}
