package com.urban.gosia.accountBalance;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
class AccountBalanceCreateDto {
    private BigDecimal balanceValue;
    private int bankAccountId;
}
