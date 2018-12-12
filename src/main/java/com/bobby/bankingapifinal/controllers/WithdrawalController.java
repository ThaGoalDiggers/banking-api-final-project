package com.bobby.bankingapifinal.controllers;

import com.bobby.bankingapifinal.domains.Withdrawal;
import com.bobby.bankingapifinal.exceptions.ResourceNotFoundException;
import com.bobby.bankingapifinal.services.WithdrawalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
public class WithdrawalController {

    @Autowired
    private WithdrawalService withdrawalService;

    @RequestMapping(method = RequestMethod.GET, value = "/withdrawals")
    public ResponseEntity<Iterable<Withdrawal>> getAllWithdrawals(){
        Iterable<Withdrawal> withdrawals = withdrawalService.getAllWithdrawals();

        return new ResponseEntity<>(withdrawals, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/accounts/{accountId}/withdrawals")
    public ResponseEntity<List<Withdrawal>> getAllWithdrawalsByAccount(@PathVariable Long accountId){
        List<Withdrawal> withdrawals = withdrawalService.getAllWithdrawalsByAccount(accountId);

        return new ResponseEntity<>(withdrawals, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/withdrawals/{withdrawalId}")
    public ResponseEntity<?> getWithdrawalById(@PathVariable Long withdrawalId){
        verifyWithdrawal(withdrawalId);
        Withdrawal withdrawals = withdrawalService.getWithdrawalById(withdrawalId).orElse(null);

        return new ResponseEntity<>(withdrawals, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/accounts/{accountId}/withdrawals")
    public ResponseEntity<?> createWithdrawal(@RequestBody Withdrawal withdrawal, @PathVariable Long accountId){
        withdrawalService.createWithdrawal(withdrawal, accountId);

        HttpHeaders httpHeaders = new HttpHeaders();
        URI newBillUri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(withdrawal.getId())
                .toUri();
        httpHeaders.setLocation(newBillUri);
        return new ResponseEntity<>(withdrawal, httpHeaders, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/withdrawals/{withdrawalId}")
    public ResponseEntity<?> deleteWithdrawal(@PathVariable Long withdrawalId){
        verifyWithdrawal(withdrawalId);
        withdrawalService.deleteDeposit(withdrawalId);

        return new ResponseEntity<>(HttpStatus.OK);

    }

    protected void verifyWithdrawal(Long withdrawalId) throws ResourceNotFoundException {
        Withdrawal withdrawal = withdrawalService.getWithdrawalById(withdrawalId).isPresent() ? withdrawalService.getWithdrawalById(withdrawalId).get() : null;
        System.out.println(withdrawal);
        if(withdrawal == (null)){
            throw new ResourceNotFoundException("Error fetching Withdrawal");
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
