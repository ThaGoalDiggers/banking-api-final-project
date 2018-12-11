package com.bobby.bankingapifinal.controllers;

import com.bobby.bankingapifinal.domains.Deposit;
import com.bobby.bankingapifinal.dto.SuccessDetails;
import com.bobby.bankingapifinal.exceptions.ResourceNotFoundException;
import com.bobby.bankingapifinal.services.DepositService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class DepositController {
    @Autowired
    private DepositService depositService;

    @RequestMapping(method = RequestMethod.GET, value = "/deposits")
    public ResponseEntity<Iterable<Deposit>> getAllDeposits(){
        Iterable<Deposit> deposits = depositService.getAllDeposits();

        SuccessDetails successDetails = new SuccessDetails(HttpStatus.OK.value(),"Success",deposits);
        return new ResponseEntity(successDetails, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/accounts/{accountId}/deposits")
    public ResponseEntity<List<Deposit>> getAllWithdrawalsByAccount(@PathVariable Long accountId){
        List<Deposit> deposits = depositService.getAllDepositsByAccount(accountId);

        SuccessDetails successDetails = new SuccessDetails(HttpStatus.OK.value(),"Success",deposits);
        return new ResponseEntity(successDetails, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/deposits/{depositId}")
    public ResponseEntity<?> getDepositById(@PathVariable Long depositId){
        verifyDeposit(depositId);
        Deposit deposit = depositService.getDepositById(depositId).orElse(null);
        SuccessDetails successDetails = new SuccessDetails(HttpStatus.OK.value(),"Success",deposit);
        return new ResponseEntity(successDetails, HttpStatus.OK);
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
        SuccessDetails successDetails = new SuccessDetails(HttpStatus.OK.value(),"Success",deposit);
        return new ResponseEntity(successDetails, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/deposits/{depositId}")
    public ResponseEntity<?> deleteDeposit(@PathVariable Long depositId){
        verifyDeposit(depositId);
        depositService.deleteDeposit(depositId);

        SuccessDetails successDetails = new SuccessDetails(HttpStatus.OK.value(),"Success");
        return new ResponseEntity(successDetails, HttpStatus.OK);
    }

    protected void verifyDeposit(Long depositId) throws ResourceNotFoundException {
        Deposit deposit = depositService.getDepositById(depositId).isPresent() ? depositService.getDepositById(depositId).get() : null;
        System.out.println(deposit);
        if(deposit == (null)){
            throw new ResourceNotFoundException("Error Fetching Deposit");
        }
    }

}
