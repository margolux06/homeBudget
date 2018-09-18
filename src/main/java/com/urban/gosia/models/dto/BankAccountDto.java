package com.urban.gosia.models.dto;

import com.urban.gosia.models.BankAccount;

public class BankAccountDto {
    private Integer id;
    private String accountNumber;
    private String bankName;
    private BankAccount.BankAccountTypes accountType;

    public BankAccountDto() {
    }

    public static BankAccountDto convertoToDto(BankAccount bankAccount) {
        BankAccountDto bankAccountDto = new BankAccountDto();
        bankAccountDto.setAccountNumber(bankAccount.getAccountNumber());
        bankAccountDto.setAccountType(bankAccount.getAccountType());
        bankAccountDto.setBankName(bankAccount.getBankName());
        bankAccountDto.setId(bankAccount.getId());
        return bankAccountDto;
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
