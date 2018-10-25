package com.urban.gosia.bankAccount;

import lombok.Data;

@Data
public class BankAccountNotFoundException extends RuntimeException {
    private final int bankAccountId;
}
