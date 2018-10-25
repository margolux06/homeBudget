package com.urban.gosia.accountBalance;

import com.urban.gosia.bankAccount.BankAccount;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@Entity(name = "AccountBalance")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class AccountBalance {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID id;
    @Column
    private BigDecimal value;
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bank_account_id")
    private BankAccount bankAccount;

    static AccountBalance empty(BankAccount account) {
        return AccountBalance.builder()
                .bankAccount(account)
                .value(BigDecimal.ZERO)
                .build();
    }

    @PrePersist
    private void prePersist() {
        this.updateDate = new Date();
    }
}
