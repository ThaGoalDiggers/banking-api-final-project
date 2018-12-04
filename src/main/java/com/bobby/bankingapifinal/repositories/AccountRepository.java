package com.bobby.bankingapifinal.repositories;

import com.bobby.bankingapifinal.domains.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, Long> {

}
