package com.urban.gosia.transaction.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "Costs")
@Table(name = "OneTimeTransaction")
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
public class OneTimeTransaction extends Transaction {
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date payDate;

}
