package com.bobby.bankingapifinal.repositories;

import com.bobby.bankingapifinal.domains.Deposit;
import org.springframework.data.repository.CrudRepository;

public interface DepositRepository extends CrudRepository<Deposit, Long> {
}
