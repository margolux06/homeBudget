package com.urban.gosia.bankAccount;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class BankAccountDto {
    private Integer id;
    private String accountNumber;
    private String bankName;
    private BankAccount.BankAccountTypes accountType;

    public static BankAccountDto convertoToDto(BankAccount bankAccount) {
        return BankAccountDto.builder()
                .id(bankAccount.getId())
                .accountNumber(bankAccount.getAccountNumber())
                .bankName(bankAccount.getBankName())
                .accountType(bankAccount.getAccountType())
                .build();
    }

    BankAccount convert() {
        return BankAccount.builder()
                .accountNumber(getAccountNumber())
                .accountType(getAccountType())
                .bankName(getBankName())
                .id(Optional.ofNullable(getId()))
                .build();
    }
}
