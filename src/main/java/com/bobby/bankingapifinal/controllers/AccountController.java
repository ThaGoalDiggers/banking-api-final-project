package com.bobby.bankingapifinal.controllers;


import com.bobby.bankingapifinal.domains.Account;
import com.bobby.bankingapifinal.dto.SuccessDetails;
import com.bobby.bankingapifinal.exceptions.ResourceNotFoundException;
import com.bobby.bankingapifinal.services.AccountService;
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
    private AccountService accountService;


    @RequestMapping(value = "/accounts", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Account>> getAllAccounts()throws ResourceNotFoundException{
        Iterable<Account> allAccounts = accountService.getAllAccounts();
        SuccessDetails successDetails = new SuccessDetails(HttpStatus.OK.value(),"Success",allAccounts);
        return new ResponseEntity(successDetails, HttpStatus.OK);
    }


    @RequestMapping(value = "/customers/{customerId}/accounts", method = RequestMethod.POST)
    public ResponseEntity<?> createAccount(@RequestBody Account account, @PathVariable Long customerId) throws ResourceNotFoundException{
        accountService.createAccount(account, customerId);
        HttpHeaders httpHeaders = new HttpHeaders();
        URI newAccountUri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/accounts")
                .buildAndExpand(account.getId())
                .toUri();
        httpHeaders.setLocation(newAccountUri);
        SuccessDetails successDetails = new SuccessDetails(HttpStatus.OK.value(),"Success",account);
        return new ResponseEntity(successDetails, HttpStatus.OK);
    }

    @RequestMapping(value = "/accounts/{accountId}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateAccount(@RequestBody Account account, @PathVariable Long accountId){
        verifyAccount(accountId);
        accountService.updateAccount(account, accountId);
        HttpHeaders httpHeaders = new HttpHeaders();
        URI newAccountUri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{accountId}")
                .buildAndExpand(account.getId())
                .toUri();
        httpHeaders.setLocation(newAccountUri);
        SuccessDetails successDetails = new SuccessDetails(HttpStatus.OK.value(),"Success",account);
        return new ResponseEntity(successDetails, HttpStatus.OK);
    }

    @RequestMapping(value = "/accounts/{accountId}", method = RequestMethod.GET)
    public ResponseEntity<?> getOneAccountById(@PathVariable Long accountId){
        verifyAccount(accountId);
        Account account = accountService.getOneAccountById(accountId).orElse(null);

        HttpHeaders httpHeaders = new HttpHeaders();
        URI newAccountUri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(account.getId())
                .toUri();
        httpHeaders.setLocation(newAccountUri);
        SuccessDetails successDetails = new SuccessDetails(HttpStatus.OK.value(),"Success",account);
        return new ResponseEntity(successDetails, HttpStatus.OK);
    }


    @RequestMapping(value = "/accounts/{accountId}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteAccount(@PathVariable Long accountId){
        verifyAccount(accountId);
        accountService.deleteAccount(accountId);
        SuccessDetails successDetails = new SuccessDetails(HttpStatus.OK.value(),"Success");
        return new ResponseEntity(successDetails, HttpStatus.OK);
    }



    @RequestMapping(value = "/customers/{customerId}/accounts", method = RequestMethod.GET)
    public ResponseEntity<?> getAllAccountsByCustomer(@PathVariable Long customerId) throws ResourceNotFoundException {
        List<Account> accounts = accountService.getAllAccountsByCustomer(customerId);
        HttpHeaders httpHeaders = new HttpHeaders();
        URI newAccountUri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(accounts)
                .toUri();
        httpHeaders.setLocation(newAccountUri);
        SuccessDetails successDetails = new SuccessDetails(HttpStatus.OK.value(), "Success", accounts);
        return new ResponseEntity(successDetails, HttpStatus.OK);
    }


    protected void verifyAccount(Long accountId)  {
        Optional<Account> account = accountService.getOneAccountById(accountId);
        if(account.equals(Optional.empty())) {
            throw new ResourceNotFoundException("Error fetching account");
        }
    }

}
