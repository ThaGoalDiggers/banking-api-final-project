package com.bobby.bankingapifinal.controllers;


import com.bobby.bankingapifinal.domains.Account;
import com.bobby.bankingapifinal.domains.Customer;
import com.bobby.bankingapifinal.repositories.AccountRepository;
import com.bobby.bankingapifinal.services.AccountServices;
import com.bobby.bankingapifinal.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class AccountController {


    @Autowired
    private AccountServices accountServices;

    @Autowired
    private CustomerService customerService;


    @RequestMapping(value = "/customers/{customerId}/accounts", method = RequestMethod.POST)
    public ResponseEntity<?> createAccount(@RequestBody Account account, @PathVariable Long customerId){
        account.setCustomer(customerService.findbycustomerid(customerId).orElse(null));
        HttpHeaders httpHeaders = new HttpHeaders();
        URI newAccountUri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(account.getId())
                .toUri();
        httpHeaders.setLocation(newAccountUri);
        return new ResponseEntity<>(account,httpHeaders,HttpStatus.CREATED);
    }

    @RequestMapping(value = "/customers/{customerId}/accounts/{accountId}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateAccount(@RequestBody Account account, @PathVariable Long accountId, @PathVariable Long customerId){
        for (Customer c: customerService.getallcustomers())
        {
            if (c.getId().equals(customerId)) accountServices.updateAccount(account, accountId);
        }
        HttpHeaders httpHeaders = new HttpHeaders();
        URI newAccountUri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(account.getId())
                .toUri();
        httpHeaders.setLocation(newAccountUri);
        return new ResponseEntity<>(account,httpHeaders,HttpStatus.OK);
    }

    @RequestMapping(value = "/customers/{customerId}/accounts/{accountId}", method = RequestMethod.GET)
    public ResponseEntity<?> getOneAccount(@PathVariable Long accountId,@PathVariable Long customerId){
        List<Account> accounts = accountServices.getAllAccounts(customerId);

        Account account = null;
        for (Account ac:accounts)
        {
            if(accountId.equals(ac.getId())) account = ac;
        }

        HttpHeaders httpHeaders = new HttpHeaders();
        URI newAccountUri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(account.getId())
                .toUri();
        httpHeaders.setLocation(newAccountUri);
        return new ResponseEntity<>(account,httpHeaders,HttpStatus.OK);
    }


    @RequestMapping(value = "/customers/{customerId}/accounts/{accountId}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteAccount(@PathVariable Long accountId, @PathVariable Long customerId){
        accountServices.deleteAccount(accountId);
    }

    @RequestMapping(value = "/customers/{customerId}/accounts", method = RequestMethod.GET)
    public ResponseEntity<?> getAccountByCustomerID(@PathVariable Long customerId){
        List<Account> accounts = accountServices.getAllAccounts(customerId);
        HttpHeaders httpHeaders = new HttpHeaders();
        URI newAccountUri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(accounts)
                .toUri();
        httpHeaders.setLocation(newAccountUri);
        return new ResponseEntity<>(accounts,httpHeaders,HttpStatus.CREATED);
    }




}
