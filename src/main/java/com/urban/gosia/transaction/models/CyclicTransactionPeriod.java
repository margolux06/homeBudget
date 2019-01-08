package com.urban.gosia.transaction.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity(name = "CyclicCostPeriod")
@Table(name = "CyclicTransactionPeriod")
public class CyclicTransactionPeriod {
    @Id
    @GeneratedValue
    private int id;
    @Column
    private String name;
    @Column
    private int monthInterval;
}
