package com.urban.gosia.repositories;

import com.urban.gosia.models.Costs;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CostsRepository extends JpaRepository<Costs, UUID> {
}
