package com.bobby.bankingapifinal.controllers;

import com.bobby.bankingapifinal.domains.Customer;
import com.bobby.bankingapifinal.exceptions.ResourceNotFoundException;
import com.bobby.bankingapifinal.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    //Get customer by account





   //Get all customers
    @RequestMapping(value = "/customers",method = RequestMethod.GET)
    public ResponseEntity<Iterable<Customer>> getCustomers(){
        Iterable<Customer> allcustomers = customerService.getallcustomers();
            return new ResponseEntity<>(allcustomers, HttpStatus.OK);
    }


    //get customer by id
    @RequestMapping(value = "/customers/{id} ",method = RequestMethod.GET)
    public  ResponseEntity<?> getCustomerbyId(@PathVariable Long customerId){
        Optional<Customer> customer = customerService.findbycustomerid(customerId);
        verifyCustomer(customerId);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }


    //create customer



    //update specific customer

    @RequestMapping(value = "/customers/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateCustomer(@RequestBody Customer customer, @PathVariable Long customerid){
        customerService.updateCustomer(customer,customerid);
        verifyCustomer(customerid);
      return new ResponseEntity<>(HttpStatus.OK);
    }


    //Error checker
    protected void verifyCustomer(Long customerId)  {
        Optional<Customer> customer = customerService.findbycustomerid(customerId);
        if(customer.equals(Optional.empty())) {
            throw new ResourceNotFoundException("Customer with id " + customerId + " not found");
        }
    }












    //========================================================
}
