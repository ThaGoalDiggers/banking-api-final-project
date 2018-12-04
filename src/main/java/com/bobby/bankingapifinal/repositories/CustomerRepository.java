package com.bobby.bankingapifinal.repositories;

import com.bobby.bankingapifinal.domains.Customer;
import org.springframework.data.repository.CrudRepository;

//Completed

public interface CustomerRepository extends CrudRepository<Customer,Long> {
}
