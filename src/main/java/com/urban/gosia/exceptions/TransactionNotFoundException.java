package com.urban.gosia.exceptions;

import lombok.Data;

import java.util.UUID;

@Data
public class TransactionNotFoundException extends RuntimeException {
    private final UUID transactionID;
}
