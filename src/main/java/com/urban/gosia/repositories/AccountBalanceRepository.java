package com.urban.gosia.repositories;

import com.urban.gosia.models.AccountBalance;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AccountBalanceRepository extends JpaRepository<AccountBalance, UUID> {

    @Transactional
    default Optional<AccountBalance> findCurrentAccountBalance(int bankAccountId) {
        List<AccountBalance> accountBalanceList = findTop1AccountBalance(bankAccountId, new PageRequest(0, 1));
        return accountBalanceList.isEmpty() ? Optional.empty() : Optional.ofNullable(accountBalanceList.get(0));
    }

    @Query("SELECT a from AccountBalance as a where a.bankAccount.id = :bankAccountId order by a.updateDate DESC")
    List<AccountBalance> findTop1AccountBalance(@Param("bankAccountId") int bankAccountId, Pageable pageable);
}
