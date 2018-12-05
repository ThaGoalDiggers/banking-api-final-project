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

    @RequestMapping("/accounts/{accountId}/withdrawals")
    public ResponseEntity<Iterable<Withdrawal>> getAllWithdrawals(){ return withdrawalServices.getAllWithdrawals(); }

    //fix
    @RequestMapping("/accounts/{accountId}/withdrawals/{withdrawalId}")
    public ResponseEntity<?> getWithdrawalById(@PathVariable Long id){ return withdrawalServices.getWithdrawalById(id); }

    @RequestMapping(method = RequestMethod.POST, value = "/accounts/{accountId}/withdrawals")
    public void createWithdrawal(@RequestBody Withdrawal withdrawal){ withdrawalServices.createWithdrawal(withdrawal); }

    //fix
    @RequestMapping(method = RequestMethod.PUT, value = "/accounts/{accountId}/withdrawals/{withdrawalId}")
    public void updateWithdrawal(@RequestBody Withdrawal withdrawal, @PathVariable Long id){ withdrawalServices.updateWithdrawal(withdrawal);}

    //fix
    @RequestMapping(method = RequestMethod.DELETE, value = "/accounts/{accountId}/withdrawals/{withdrawalId}")
    public void deleteWithdrawal(@PathVariable Long id){ withdrawalServices.deleteDeposit(id);}
}
