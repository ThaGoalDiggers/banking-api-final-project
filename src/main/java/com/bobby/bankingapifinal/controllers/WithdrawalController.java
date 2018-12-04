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

    @RequestMapping("/accounts/{acountId}/withdrawals")
    public ResponseEntity<Iterable<Withdrawal>> getAllWithdrawals(){ return withdrawalServices.getAllWithdrawals(); }

    @RequestMapping("/withdrawals/{withdrawalId}")
    public ResponseEntity<?> getWithdrawalById(@PathVariable Long id){ return withdrawalServices.getWithdrawalById(id); }

    @RequestMapping(method = RequestMethod.POST, value = "/accounts/{accountId}/withdrawals")
    public void createWithdrawal(@RequestBody Withdrawal withdrawal){ withdrawalServices.createWithdrawal(withdrawal); }

    @RequestMapping(method = RequestMethod.PUT, value = "/withdrawals/{withdrawalId}")
    public void updateWithdrawal(@RequestBody Withdrawal withdrawal, @PathVariable Long id){ withdrawalServices.updateWithdrawal(withdrawal);}

    @RequestMapping(method = RequestMethod.DELETE, value = "/withdrawals/{withdrawalId}")
    public void deleteWithdrawal(@PathVariable Long id){ withdrawalServices.deleteDeposit(id);}
}
