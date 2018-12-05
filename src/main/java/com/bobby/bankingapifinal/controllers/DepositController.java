package com.bobby.bankingapifinal.controllers;

import com.bobby.bankingapifinal.domains.Deposit;
import com.bobby.bankingapifinal.services.DepositServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepositController {
    @Autowired
    private DepositServices depositServices;

    @RequestMapping(method = RequestMethod.GET, value = "/accounts/{accountId}/deposits")
    public ResponseEntity<Iterable<Deposit>> getAllDeposits(){ return depositServices.getAllDeposits();}

    //fix
    @RequestMapping(method = RequestMethod.GET, value = "/accounts/{accountId}/deposits/{depositId}")
    public ResponseEntity<?> getDepositById(Long accountId, @PathVariable Long depositId){ return depositServices.getDepositById(depositId);}

    @RequestMapping(method = RequestMethod.POST, value = "/accounts/{accountId}/deposits")
    public void createDeposit(@RequestBody Deposit deposit){ depositServices.createDeposit(deposit);}

    //fix
    @RequestMapping(method = RequestMethod.PUT, value = "/accounts/{accountId}/deposits/{depositId}")
    public void updateDeposit(@RequestBody Deposit deposit, @PathVariable Long depositId, Long accountId){ depositServices.updateDeposit(deposit);}

    //fix
    @RequestMapping(method = RequestMethod.DELETE, value = "/accounts/{accountId}/deposits/{depositId}")
    public void deleteDeposit(@PathVariable Long depositId, Long accountId){ depositServices.deleteDeposit(depositId);}
}
