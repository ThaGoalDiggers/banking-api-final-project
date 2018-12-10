package com.bobby.bankingapifinal.repositories;

import com.bobby.bankingapifinal.domains.Deposit;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DepositRepository extends CrudRepository<Deposit, Long> {
    List<Deposit> findByAccountId(Long accountId);
}
