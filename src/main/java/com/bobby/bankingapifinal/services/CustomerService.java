package com.bobby.bankingapifinal.services;

import com.bobby.bankingapifinal.domains.Account;
import com.bobby.bankingapifinal.domains.Customer;
import com.bobby.bankingapifinal.exceptions.ResourceNotFoundException;
import com.bobby.bankingapifinal.repositories.AccountRepository;
import com.bobby.bankingapifinal.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private AccountRepository accountRepository;



    //Get Customer by account
    public Customer getOneCustomerByAccountId(Long accountId){
        Customer customer;
        for(Account acc : accountRepository.findAll()){
            if(acc.getId().equals(accountId)){
                customer = acc.getCustomer();
                return customer;
            }
        }
        return null;
    }


    //Get all
    public Iterable<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }


    //Get one

    public Optional<Customer> getOneCustomerById(Long customerId){
        return customerRepository.findById(customerId);
    }

    //Create Customer
    public void createCustomer(Customer customer){
        customerRepository.save(customer);
    }

    //Update Customer
    public void updateCustomerById(Customer customer, Long customerId){

        for(Customer c : customerRepository.findAll())
        {
            if(c.getId().equals(customerId)) {customerRepository.save(customer);}
            else {
                throw new ResourceNotFoundException("Error updating customer");
            }
        }

    }

    public void deleteCustomerById(Long customerId){
        customerRepository.deleteById(customerId);
    }



}
