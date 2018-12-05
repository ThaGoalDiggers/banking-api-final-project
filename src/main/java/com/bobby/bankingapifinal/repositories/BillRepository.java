package com.bobby.bankingapifinal.repositories;
//This repository was made by Derian


import com.bobby.bankingapifinal.domains.Bill;
import org.springframework.data.repository.CrudRepository;



public interface BillRepository extends CrudRepository<Bill, Long> {}
