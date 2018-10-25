package com.urban.gosia.transaction;

import lombok.Data;

import java.util.UUID;

@Data
public class TransactionNotFoundException extends RuntimeException {
    private final UUID cyclicTransactionId;
}
