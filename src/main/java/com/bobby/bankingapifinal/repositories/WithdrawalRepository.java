package com.bobby.bankingapifinal.repositories;

import com.bobby.bankingapifinal.domains.Withdrawal;
import org.springframework.data.repository.CrudRepository;

public interface WithdrawalRepository extends CrudRepository<Withdrawal, Long> {
}
