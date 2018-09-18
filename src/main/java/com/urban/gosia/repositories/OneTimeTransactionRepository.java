package com.urban.gosia.repositories;

import com.urban.gosia.models.OneTimeTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OneTimeTransactionRepository extends JpaRepository<OneTimeTransaction, UUID> {
}
