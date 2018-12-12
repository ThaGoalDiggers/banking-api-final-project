package com.bobby.bankingapifinal.controllers;

import com.bobby.bankingapifinal.domains.Withdrawal;
import com.bobby.bankingapifinal.dto.SuccessDetails;
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
import java.util.Optional;

@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
public class WithdrawalController {

    @Autowired
    private WithdrawalService withdrawalService;

    @RequestMapping(method = RequestMethod.GET, value = "/withdrawals")
    public ResponseEntity<Iterable<Withdrawal>> getAllWithdrawals()throws ResourceNotFoundException{
        Iterable<Withdrawal> withdrawals = withdrawalService.getAllWithdrawals();

        SuccessDetails successDetails = new SuccessDetails(HttpStatus.OK.value(),"Success",withdrawals);
        return new ResponseEntity(successDetails, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/accounts/{accountId}/withdrawals")
    public ResponseEntity<List<Withdrawal>> getAllWithdrawalsByAccount(@PathVariable Long accountId)throws ResourceNotFoundException{
        List<Withdrawal> withdrawals = withdrawalService.getAllWithdrawalsByAccount(accountId);
        SuccessDetails successDetails = new SuccessDetails(HttpStatus.OK.value(),"Success",withdrawals);
        return new ResponseEntity(successDetails, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/withdrawals/{withdrawalId}")
    public ResponseEntity<?> getWithdrawalById(@PathVariable Long withdrawalId){
        verifyWithdrawal(withdrawalId);
        Withdrawal withdrawals = withdrawalService.getWithdrawalById(withdrawalId).orElse(null);

        SuccessDetails successDetails = new SuccessDetails(HttpStatus.OK.value(),"Success",withdrawalId);
        return new ResponseEntity(successDetails, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/accounts/{accountId}/withdrawals")
    public ResponseEntity<?> createWithdrawal(@RequestBody Withdrawal withdrawal, @PathVariable Long accountId)throws ResourceNotFoundException{
        withdrawalService.createWithdrawal(withdrawal, accountId);

        HttpHeaders httpHeaders = new HttpHeaders();
        URI newBillUri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(withdrawal.getId())
                .toUri();
        httpHeaders.setLocation(newBillUri);
        SuccessDetails successDetails = new SuccessDetails(HttpStatus.OK.value(),"Success",withdrawal);
        return new ResponseEntity(successDetails, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/withdrawals/{withdrawalId}")
    public ResponseEntity<?> deleteWithdrawal(@PathVariable Long withdrawalId){
        verifyWithdrawal(withdrawalId);
        withdrawalService.deleteDeposit(withdrawalId);

        SuccessDetails successDetails = new SuccessDetails(HttpStatus.OK.value(),"Success");
        return new ResponseEntity(successDetails, HttpStatus.OK);

    }

    protected void verifyWithdrawal(Long withdrawalId) throws ResourceNotFoundException {
        Optional<Withdrawal> withdrawal = withdrawalService.getWithdrawalById(withdrawalId);
        System.out.println(withdrawal);
        if(withdrawal == (null)){
            throw new ResourceNotFoundException("Error fetching Withdrawal");
        }
    }

}
