package com.urban.gosia.models;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity(name = "CyclicTransaction")
@Table(name = "CyclicTransaction")
public class CyclicTransaction extends Transaction {
    public enum CyclicCostPeriod {
        PER_WEEK,
        PER_MONTH,
        PER_THREE_MONTHS,
        PER_YEAR
    }

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date firstPayDate;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastPayDate;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private CyclicCostPeriod period;

    public CyclicTransaction() {
    }

    public CyclicTransaction(String name, BigDecimal value, CostDirection costDirection, BankAccount bankAccount,
                             boolean isActive, Date firstPayDate, Date lastPayDate, CyclicCostPeriod period) {
        super(name, value, costDirection, bankAccount, isActive);
        this.firstPayDate = firstPayDate;
        this.lastPayDate = lastPayDate;
        this.period = period;
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
}
