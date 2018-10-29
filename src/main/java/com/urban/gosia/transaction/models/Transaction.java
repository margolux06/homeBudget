package com.urban.gosia.transaction.models;

import com.urban.gosia.bankAccount.BankAccount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;

@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
@Data
public abstract class Transaction {
    public enum CostDirection {
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
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "bank_account_id")
    private BankAccount bankAccount;
    @Column
    private boolean isActive = true;
}
