package com.bobby.bankingapifinal.controllers;

import com.bobby.bankingapifinal.domains.Customer;
import com.bobby.bankingapifinal.exceptions.ResourceNotFoundException;
import com.bobby.bankingapifinal.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
public class CustomerController {
    @Autowired
    private CustomerService customerService;


   //Get all customers
    @RequestMapping(value = "/customers", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Customer>> getAllCustomers(){
        Iterable<Customer> allCustomers = customerService.getAllCustomers();
            return new ResponseEntity<>(allCustomers, HttpStatus.OK);
    }


    //get customer by id
    @RequestMapping(value = "/customers/{customerId}", method = RequestMethod.GET)
    public  ResponseEntity<?> getOneCustomerById(@PathVariable Long customerId){
        verifyCustomer(customerId);
        Optional<Customer> customer = customerService.getOneCustomerById(customerId);
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newCustomerUri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(customer.get().getId())
                .toUri();
        responseHeaders.setLocation(newCustomerUri);

        return new ResponseEntity<>(customer,responseHeaders, HttpStatus.OK);
    }


    //create customer
    @RequestMapping(value="/customers", method=RequestMethod.POST)
    public ResponseEntity<?> createCustomer( @RequestBody Customer customer){
        customerService.createCustomer(customer);
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newCustomerUri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(customer.getId())
                .toUri();
        responseHeaders.setLocation(newCustomerUri);
        return new ResponseEntity<>(customer, responseHeaders, HttpStatus.CREATED);


    }

    //update specific customer
    @RequestMapping(value = "/customers/{customerId}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateCustomerById(@RequestBody Customer customer, @PathVariable Long customerId){
        verifyCustomer(customerId);
        customerService.updateCustomerById(customer,customerId);
      return new ResponseEntity<>(HttpStatus.OK);
    }



    @RequestMapping(value = "/customers/{customerId}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteCustomerById(@PathVariable Long customerId){
        customerService.deleteCustomerById(customerId);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    //Error checker
    protected void verifyCustomer(Long customerId)  {
        Optional<Customer> customer = customerService.getOneCustomerById(customerId);
        if(customer.equals(Optional.empty())) {
            throw new ResourceNotFoundException("Customer with id " + customerId + " not found");
        }
    }



}
