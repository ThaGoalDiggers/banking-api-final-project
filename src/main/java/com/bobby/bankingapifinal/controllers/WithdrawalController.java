package com.bobby.bankingapifinal.controllers;

import com.bobby.bankingapifinal.domains.Withdrawal;
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

    @RequestMapping(method = RequestMethod.GET, value = "/accounts/{accountId}/withdrawals")
    public ResponseEntity<Iterable<Withdrawal>> getAllWithdrawals(){
        Iterable<Withdrawal> withdrawals = withdrawalServices.getAllWithdrawals();

        return new ResponseEntity<>(withdrawals, HttpStatus.OK);
    }


    @RequestMapping(method = RequestMethod.GET, value = "/accounts/{accountId}/withdrawals/{withdrawalId}")
    public ResponseEntity<?> getWithdrawalById(@PathVariable Long withdrawalId, Long accountId){
        Optional<Withdrawal> withdrawals = withdrawalServices.getWithdrawalById(withdrawalId);

        return new ResponseEntity<>(withdrawals, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/accounts/{accountId}/withdrawals")
    public ResponseEntity<?> createWithdrawal(@RequestBody Withdrawal withdrawal){
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
        withdrawalServices.updateWithdrawal(withdrawal);

        return new ResponseEntity<>(withdrawal, HttpStatus.OK);
    }


    @RequestMapping(method = RequestMethod.DELETE, value = "/accounts/{accountId}/withdrawals/{withdrawalId}")
    public ResponseEntity<?> deleteWithdrawal(@PathVariable Long withdrawalId, Long accountId){
        withdrawalServices.deleteDeposit(withdrawalId);

        return new ResponseEntity<>(HttpStatus.OK);

    }
}
