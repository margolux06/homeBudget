package com.urban.gosia.transaction.services;

import com.urban.gosia.exceptions.CyclicPeriodNotFoundException;
import com.urban.gosia.transaction.models.CyclicTransactionPeriod;
import com.urban.gosia.transaction.repository.CyclicTransactionPeriodRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Data
@Service
public class CyclicTransactionPeriodService {
    private final CyclicTransactionPeriodRepository repository;

    public List<CyclicTransactionPeriod> findAll(){
        return repository.findAll();
    }

    public CyclicTransactionPeriod getById(int id) throws CyclicPeriodNotFoundException {
        return Optional.ofNullable(repository.findOne(id))
                .orElseThrow(CyclicPeriodNotFoundException::new);
    }

    public CyclicTransactionPeriod save(CyclicTransactionPeriod costPeriod){
        return repository.save(costPeriod);
    }
}
