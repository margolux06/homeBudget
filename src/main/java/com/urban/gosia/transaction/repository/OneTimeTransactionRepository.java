package com.urban.gosia.transaction.repository;

import com.urban.gosia.transaction.models.OneTimeTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OneTimeTransactionRepository extends JpaRepository<OneTimeTransaction, UUID> {
}
