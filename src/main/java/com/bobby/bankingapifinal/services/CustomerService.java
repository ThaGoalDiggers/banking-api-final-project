package com.bobby.bankingapifinal.services;

import com.bobby.bankingapifinal.domains.Customer;
import com.bobby.bankingapifinal.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;


    //Get Customer by account



    //Get all
    public Iterable<Customer> getallcustomers(){
        return customerRepository.findAll();
    }


    //Get one

    public Optional<Customer> findbycustomerid(Long customerId){
        return customerRepository.findById(customerId);
    }

    //Create Customer
    public void createCustomer(Customer customer){
        customerRepository.save(customer);
    }

    //Update Customer
    public Customer updateCustomer (Customer customer, Long customerId){
            customerRepository.save(customer);
        return customer;
    }





}
