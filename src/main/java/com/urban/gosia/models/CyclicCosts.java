package com.urban.gosia.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@Entity(name = "CyclicCosts")
@Table(name = "CyclicCosts")
public class CyclicCosts {
    public enum CyclicCostPeriod{
        PER_WEEK,
        PER_MONTH,
        PER_THREE_MONTHS,
        PER_YEAR
    }

    @Id
    @Column
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private BigDecimal value;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date firstPayDate;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastPayDate;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private CyclicCostPeriod period;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bank_account_id")
    private BankAccount bankAccount;

    @Column
    private boolean isActive = true;

    public CyclicCosts(String name, BigDecimal value, Date firstPayDate, Date lastPayDate, CyclicCostPeriod period, BankAccount bankAccount, boolean isActive) {
        this.name = name;
        this.value = value;
        this.firstPayDate = firstPayDate;
        this.lastPayDate = lastPayDate;
        this.period = period;
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

    public Date getFirstPayDate() {
        return firstPayDate;
    }

    public void setFirstPayDate(Date firstPayDate) {
        this.firstPayDate = firstPayDate;
    }

    public Date getLastPayDate() {
        return lastPayDate;
    }

    public void setLastPayDate(Date lastPayDate) {
        this.lastPayDate = lastPayDate;
    }

    public CyclicCostPeriod getPeriod() {
        return period;
    }

    public void setPeriod(CyclicCostPeriod period) {
        this.period = period;
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
