package com.urban.gosia;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class BankAccount {
    enum BankAccountTypes {
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
    private BankAccountTypes accountType;

    public BankAccount() {
    }

    public BankAccount(int id, String accountNumber, String bankName, BankAccountTypes accountType) {
        this.id = id;// TODO: 06.09.2018 usunać to! id generated ma być przy zapisie do bazy dnaych
        this.accountNumber = accountNumber;
        this.bankName = bankName;
        this.accountType = accountType;
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
}
