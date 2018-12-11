package com.bobby.bankingapifinal.controllers;

import com.bobby.bankingapifinal.domains.Deposit;
import com.bobby.bankingapifinal.exceptions.ResourceNotFoundException;
import com.bobby.bankingapifinal.services.AccountService;
import com.bobby.bankingapifinal.services.DepositService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
public class DepositController {
    @Autowired
    private DepositService depositService;

    @Autowired
    private AccountService accountService;

    @RequestMapping(method = RequestMethod.GET, value = "/deposits")
    public ResponseEntity<Iterable<Deposit>> getAllDeposits(){
        Iterable<Deposit> deposits = depositService.getAllDeposits();

        return new ResponseEntity<>(deposits, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/deposits/{depositId}")
    public ResponseEntity<?> getDepositById(@PathVariable Long depositId){
        Deposit deposit = depositService.getDepositById(depositId).orElse(null);
        return new ResponseEntity<>(deposit, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/accounts/{accountId}/deposits")
    public ResponseEntity<?> createDeposit(@RequestBody Deposit deposit, @PathVariable Long accountId){
        depositService.createDeposit(deposit, accountId);

        HttpHeaders httpHeaders = new HttpHeaders();
        URI newBillUri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/deposits")
                .buildAndExpand(deposit.getId())
                .toUri();
        httpHeaders.setLocation(newBillUri);
        return new ResponseEntity<>(deposit, httpHeaders, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/deposits/{depositId}")
    public ResponseEntity<?> deleteDeposit(@PathVariable Long depositId){
        depositService.deleteDeposit(depositId);

        return new ResponseEntity<>(HttpStatus.OK);
    }

//    protected void verifyDeposit(Long depositId) throws ResourceNotFoundException {
//        Deposit deposit = depositService.getDepositById(depositId).isPresent() ? depositService.getDepositById(depositId).get() : null;
//        System.out.println(deposit);
//        if(deposit == (null)){
//            throw new ResourceNotFoundException("Deposit with id " + depositId + " not found.");
//        }
//    }

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
