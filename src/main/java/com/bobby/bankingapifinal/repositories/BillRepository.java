package com.bobby.bankingapifinal.repositories;
//This repository was made by Derian


import com.bobby.bankingapifinal.domains.Bill;
import org.springframework.data.repository.CrudRepository;



import java.util.List;



public interface BillRepository extends CrudRepository<Bill, Long>
{
    List<Bill> findByAccountId(Long accountId);
    List<Bill> findByCustomerId(Long customerId);
}
