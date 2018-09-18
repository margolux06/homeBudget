package com.urban.gosia.repositories;

import com.urban.gosia.models.CyclicTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CyclicTransactinRepository extends JpaRepository<CyclicTransaction, UUID> {
}
