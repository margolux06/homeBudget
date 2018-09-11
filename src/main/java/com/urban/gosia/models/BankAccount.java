package com.urban.gosia.models;

import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

@Entity(name = "BankAccount")
@Table(name = "BankAccount")
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
    private BigDecimal currentBalance = BigDecimal.ZERO;

    public BankAccount() {
    }

    public BankAccount(String accountNumber, String bankName, BankAccountTypes accountType, BigDecimal currentBalance) {
        this.accountNumber = accountNumber;
        this.bankName = bankName;
        this.accountType = accountType;
        this.currentBalance = currentBalance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public BankAccountTypes getAccountType() {
        return accountType;
    }

    public void setAccountType(BankAccountTypes accountType) {
        this.accountType = accountType;
    }

    public BigDecimal getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(BigDecimal currentBalance) {
        this.currentBalance = currentBalance;
    }

    public Date getBalanceUpdate() {
        return balanceUpdate;
    }

    public void setBalanceUpdate(Date balanceUpdate) {
        this.balanceUpdate = balanceUpdate;
    }
}
