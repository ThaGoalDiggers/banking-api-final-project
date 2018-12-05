package com.bobby.bankingapifinal.controllers;

import com.bobby.bankingapifinal.domains.Withdrawal;
import com.bobby.bankingapifinal.services.WithdrawalServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WithdrawalController {

    @Autowired
    private WithdrawalServices withdrawalServices;

    @RequestMapping(method = RequestMethod.GET, value = "/accounts/{accountId}/withdrawals")
    public ResponseEntity<Iterable<Withdrawal>> getAllWithdrawals(){ return withdrawalServices.getAllWithdrawals(); }


    @RequestMapping(method = RequestMethod.GET, value = "/accounts/{accountId}/withdrawals/{withdrawalId}")
    public ResponseEntity<?> getWithdrawalById(@PathVariable Long withdrawalId, Long accountId){ return withdrawalServices.getWithdrawalById(withdrawalId); }

    @RequestMapping(method = RequestMethod.POST, value = "/accounts/{accountId}/withdrawals")
    public void createWithdrawal(@RequestBody Withdrawal withdrawal){ withdrawalServices.createWithdrawal(withdrawal); }


    @RequestMapping(method = RequestMethod.PUT, value = "/accounts/{accountId}/withdrawals/{withdrawalId}")
    public void updateWithdrawal(@RequestBody Withdrawal withdrawal, @PathVariable Long withdrawalId, Long accountId){ withdrawalServices.updateWithdrawal(withdrawal);}

    
    @RequestMapping(method = RequestMethod.DELETE, value = "/accounts/{accountId}/withdrawals/{withdrawalId}")
    public void deleteWithdrawal(@PathVariable Long withdrawalId, Long accountId){ withdrawalServices.deleteDeposit(withdrawalId);}
}
