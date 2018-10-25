package com.urban.gosia.bankAccount;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Optional;

@Entity(name = "BankAccount")
@Table(name = "BankAccount")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class BankAccount {
    public enum BankAccountTypes {
        EXPENSES, SAVINGS
    }

    @Id
    @GeneratedValue
    @Column
    private int id;
    @Column
    private String accountNumber;
    @Column(nullable = false)
    private String bankName;
    @Column
    @Enumerated(EnumType.STRING)
    private BankAccountTypes accountType;
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date balanceUpdate;
    @Column
    @Builder.Default
    private BigDecimal currentBalance = BigDecimal.ZERO;

    public BankAccount(String accountNumber, String bankName, BankAccountTypes accountType, BigDecimal currentBalance) {
        this.accountNumber = accountNumber;
        this.bankName = bankName;
        this.accountType = accountType;
        this.currentBalance = currentBalance;
    }

    public static class BankAccountBuilder {
        public BankAccountBuilder id(Optional<Integer> optional) {
            optional.ifPresent(id -> this.id = id);
            return this;
        }
    }
}
