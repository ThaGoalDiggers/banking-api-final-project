package com.bobby.bankingapifinal.repositories;

import com.bobby.bankingapifinal.domains.Withdrawal;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface WithdrawalRepository extends CrudRepository<Withdrawal, Long> {
    List<Withdrawal> findByAccountId(Long accountId);
}
