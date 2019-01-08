package com.urban.gosia.transaction.repository;

import com.urban.gosia.transaction.models.CyclicTransactionPeriod;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CyclicTransactionPeriodRepository extends JpaRepository<CyclicTransactionPeriod, Integer> {
}
