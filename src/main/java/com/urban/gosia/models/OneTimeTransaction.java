package com.urban.gosia.models;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity(name = "Costs")
@Table(name = "OneTimeTransaction")
public class OneTimeTransaction extends Transaction {
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date payDate;

    public OneTimeTransaction() {
    }

    public OneTimeTransaction(String name, BigDecimal value, Transaction.CostDirection costDirection, Date payDate, BankAccount bankAccount, boolean isActive) {
        super(name, value, costDirection, bankAccount, isActive);
        this.payDate = payDate;
    }

    public Date getPayDate() {
        return payDate;
    }

    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }
}
