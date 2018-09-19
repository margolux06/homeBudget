package com.urban.gosia.exceptions;

import java.util.UUID;

public class TransactionNotFoundException extends RuntimeException {
    private final UUID cyclicTransactionId;

    public TransactionNotFoundException(UUID uuid) {
        this.cyclicTransactionId = uuid;
    }

    public UUID getBankAccountId() {
        return cyclicTransactionId;
    }
}
