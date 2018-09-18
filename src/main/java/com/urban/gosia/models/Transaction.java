package com.urban.gosia.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;

@MappedSuperclass
public class Transaction {
    public enum CostDirection{
        INCOMING, OUTGOING
    }

    @Id
    @Column
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID id;

    @Column
    private String name;

    @Column
    private BigDecimal value;

    @Column
    @Enumerated(EnumType.STRING)
    private Transaction.CostDirection costDirection;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bank_account_id")
    private BankAccount bankAccount;

    @Column
    private boolean isActive = true;

    public Transaction() {
    }

    public Transaction(String name, BigDecimal value, CostDirection costDirection, BankAccount bankAccount, boolean isActive) {
        this.name = name;
        this.value = value;
        this.costDirection = costDirection;
        this.bankAccount = bankAccount;
        this.isActive = isActive;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public CostDirection getCostDirection() {
        return costDirection;
    }

    public void setCostDirection(CostDirection costDirection) {
        this.costDirection = costDirection;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
