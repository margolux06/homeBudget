package com.urban.gosia;

import com.urban.gosia.models.BankAccount;

public class BankAccountDto {
    private Integer id;
    private String accountNumber;
    private String bankName;
    private BankAccount.BankAccountTypes accountType;

    public BankAccountDto() {
    }

    public BankAccountDto(Integer id, String accountNumber, String bankName, BankAccount.BankAccountTypes accountType) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.bankName = bankName;
        this.accountType = accountType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public BankAccount.BankAccountTypes getAccountType() {
        return accountType;
    }

    public void setAccountType(BankAccount.BankAccountTypes accountType) {
        this.accountType = accountType;
    }

    public BankAccount convert() {
        BankAccount bankAccount = new BankAccount();
        bankAccount.setAccountNumber(getAccountNumber());
        bankAccount.setAccountType(getAccountType());
        bankAccount.setBankName(getBankName());
        if (getId() != null) {
            bankAccount.setId(getId());
        }
        return bankAccount;
    }
}
