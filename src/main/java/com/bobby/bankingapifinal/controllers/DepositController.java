package com.bobby.bankingapifinal.controllers;

import com.bobby.bankingapifinal.domains.Deposit;
import com.bobby.bankingapifinal.exceptions.ResourceNotFoundException;
import com.bobby.bankingapifinal.services.AccountService;
import com.bobby.bankingapifinal.services.DepositServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
public class DepositController {
    @Autowired
    private DepositServices depositServices;

    @Autowired
    private AccountService accountService;

    @RequestMapping(method = RequestMethod.GET, value = "/accounts/{accountId}/deposits")
    public ResponseEntity<Iterable<Deposit>> getAllDeposits(@PathVariable Long accountId){
//        verifyAccount(accountId);

        Iterable<Deposit> deposits = depositServices.getAllDeposits();

        return new ResponseEntity<>(deposits, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/accounts/{accountId}/deposits/{depositId}")
    public ResponseEntity<?> getDepositById(Long accountId, @PathVariable Long depositId){
        verifyDeposit(depositId);

        Optional<Deposit> deposit = depositServices.getDepositById(depositId);

        return new ResponseEntity<>(deposit, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/accounts/{accountId}/deposits")
    public ResponseEntity<?> createDeposit(@RequestBody Deposit deposit, @PathVariable Long accountId){
//        verifyAccount(accountId);

        depositServices.createDeposit(deposit);

        HttpHeaders responseHeaders = new HttpHeaders();
        URI newBillUri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(deposit.getId())
                .toUri();
        responseHeaders.setLocation(newBillUri);
        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }


    @RequestMapping(method = RequestMethod.PUT, value = "/accounts/{accountId}/deposits/{depositId}")
    public ResponseEntity<?> updateDeposit(@RequestBody Deposit deposit, @PathVariable Long depositId, Long accountId){
        verifyDeposit(depositId);

        depositServices.updateDeposit(deposit);

        return new ResponseEntity<>(deposit, HttpStatus.OK);
    }


    @RequestMapping(method = RequestMethod.DELETE, value = "/accounts/{accountId}/deposits/{depositId}")
    public ResponseEntity<?> deleteDeposit(@PathVariable Long depositId, Long accountId){
        verifyDeposit(depositId);

        depositServices.deleteDeposit(depositId);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    protected void verifyDeposit(Long depositId) throws ResourceNotFoundException {
        Deposit deposit = depositServices.getDepositById(depositId).isPresent() ? depositServices.getDepositById(depositId).get() : null;
        System.out.println(deposit);
        if(deposit == (null)){
            throw new ResourceNotFoundException("Deposit with id " + depositId + " not found.");
        }
    }

//    protected void verifyAccount(Long accountId) throws ResourceNotFoundException
//    {
//        Account account = accountServices.getOneAccount(accountId).isPresent() ? accountServices.getOneAccount(accountId).get() : null;
//        System.out.println(account);
//        if(account == (null))
//        {
//            throw new ResourceNotFoundException("Account with id " + accountId + " not found");
//        }
//    }
}
