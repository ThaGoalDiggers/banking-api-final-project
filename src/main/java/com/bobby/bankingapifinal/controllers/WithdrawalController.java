package com.bobby.bankingapifinal.controllers;

import com.bobby.bankingapifinal.domains.Account;
import com.bobby.bankingapifinal.domains.Withdrawal;
import com.bobby.bankingapifinal.exceptions.ResourceNotFoundException;
import com.bobby.bankingapifinal.services.AccountServices;
import com.bobby.bankingapifinal.services.WithdrawalServices;
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
public class WithdrawalController {

    @Autowired
    private WithdrawalServices withdrawalServices;

    @Autowired
    private AccountServices accountServices;

    @RequestMapping(method = RequestMethod.GET, value = "/accounts/{accountId}/withdrawals")
    public ResponseEntity<Iterable<Withdrawal>> getAllWithdrawals(@PathVariable Long accountId){
        verifyAccount(accountId);

        Iterable<Withdrawal> withdrawals = withdrawalServices.getAllWithdrawals();

        return new ResponseEntity<>(withdrawals, HttpStatus.OK);
    }


    @RequestMapping(method = RequestMethod.GET, value = "/accounts/{accountId}/withdrawals/{withdrawalId}")
    public ResponseEntity<?> getWithdrawalById(@PathVariable Long withdrawalId, Long accountId){
        verifyWithdrawal(withdrawalId);

        Optional<Withdrawal> withdrawals = withdrawalServices.getWithdrawalById(withdrawalId);

        return new ResponseEntity<>(withdrawals, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/accounts/{accountId}/withdrawals")
    public ResponseEntity<?> createWithdrawal(@RequestBody Withdrawal withdrawal, @PathVariable Long accountId){
        verifyAccount(accountId);

        withdrawalServices.createWithdrawal(withdrawal);

        HttpHeaders responseHeaders = new HttpHeaders();
        URI newBillUri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(withdrawal.getId())
                .toUri();
        responseHeaders.setLocation(newBillUri);
        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }


    @RequestMapping(method = RequestMethod.PUT, value = "/accounts/{accountId}/withdrawals/{withdrawalId}")
    public ResponseEntity<?> updateWithdrawal(@RequestBody Withdrawal withdrawal, @PathVariable Long withdrawalId, Long accountId){
        verifyWithdrawal(withdrawalId);

        withdrawalServices.updateWithdrawal(withdrawal);

        return new ResponseEntity<>(withdrawal, HttpStatus.OK);
    }


    @RequestMapping(method = RequestMethod.DELETE, value = "/accounts/{accountId}/withdrawals/{withdrawalId}")
    public ResponseEntity<?> deleteWithdrawal(@PathVariable Long withdrawalId, Long accountId){
        verifyWithdrawal(withdrawalId);

        withdrawalServices.deleteDeposit(withdrawalId);

        return new ResponseEntity<>(HttpStatus.OK);

    }

    protected void verifyWithdrawal(Long withdrawalId) throws ResourceNotFoundException {
        Withdrawal withdrawal = withdrawalServices.getWithdrawalById(withdrawalId).isPresent() ? withdrawalServices.getWithdrawalById(withdrawalId).get() : null;
        System.out.println(withdrawal);
        if(withdrawal == (null)){
            throw new ResourceNotFoundException("Withdrawal with id " + withdrawalId + " not found.");
        }
    }

    protected void verifyAccount(Long accountId) throws ResourceNotFoundException
    {
        Account account = accountServices.getOneAccount(accountId).isPresent() ? accountServices.getOneAccount(accountId).get() : null;
        System.out.println(account);
        if(account == (null))
        {
            throw new ResourceNotFoundException("Account with id " + accountId + " not found");
        }
    }
}
