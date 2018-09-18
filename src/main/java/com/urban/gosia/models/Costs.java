package com.urban.gosia.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@Entity(name = "Costs")
@Table(name = "Costs")
public class Costs {
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
    private boolean isCyclic = false;
    @Column
    @Enumerated(EnumType.STRING)
    private CostDirection costDirection;
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date payDate;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bank_account_id")
    private BankAccount bankAccount;
    @Column
    private boolean isActive = true;

    public Costs() {
    }

    public Costs(String name, BigDecimal value, boolean isCyclic, CostDirection costDirection, Date payDate, BankAccount bankAccount) {
        this.name = name;
        this.value = value;
        this.isCyclic = isCyclic;
        this.costDirection = costDirection;
        this.payDate = payDate;
        this.bankAccount = bankAccount;
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

    public boolean isCyclic() {
        return isCyclic;
    }

    public void setCyclic(boolean cyclic) {
        isCyclic = cyclic;
    }

    public CostDirection getCostDirection() {
        return costDirection;
    }

    public void setCostDirection(CostDirection costDirection) {
        this.costDirection = costDirection;
    }

    public Date getPayDate() {
        return payDate;
    }

    public void setPayDate(Date payDate) {
        this.payDate = payDate;
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
