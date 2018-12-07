package com.bobby.bankingapifinal.repositories;

import com.bobby.bankingapifinal.domains.Account;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AccountRepository extends CrudRepository<Account, Long> {

    List<Account> findByCustomerId(Long customerId);

}
