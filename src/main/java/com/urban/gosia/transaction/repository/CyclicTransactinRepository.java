package com.urban.gosia.transaction.repository;

import com.urban.gosia.transaction.models.CyclicTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CyclicTransactinRepository extends JpaRepository<CyclicTransaction, UUID> {
}
