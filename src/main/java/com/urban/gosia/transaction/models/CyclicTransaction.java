package com.urban.gosia.transaction.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "CyclicTransaction")
@Table(name = "CyclicTransaction")
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
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
}
