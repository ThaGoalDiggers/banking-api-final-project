package com.bobby.bankingapifinal.controllers;


import com.bobby.bankingapifinal.domains.Account;
import com.bobby.bankingapifinal.services.AccountServices;
import org.hibernate.validator.constraints.pl.REGON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AccountController {


    @Autowired
    private AccountServices accountServices;


    @RequestMapping(value = "/customers/accounts", method = RequestMethod.POST)
    public Account createAccount(@RequestBody Account account, @PathVariable Long id){
        return accountServices.addAccount(account);
    }

    @RequestMapping(value = "/accounts/{accountId}", method = RequestMethod.PUT)
    public Account updateAccount(@RequestBody Account account, @PathVariable Long id){
        return accountServices.updateAccont(account);
    }

    @RequestMapping(value = "/accounts/{accountId}", method = RequestMethod.GET)
    public Optional<Account> getOneAccount(@PathVariable Long id){
        return accountServices.getOneAccount(id);
    }

    @RequestMapping(value = "/accounts", method = RequestMethod.GET)
    public Iterable<Account> getAllAccount(@PathVariable Long id){
        return accountServices.getAllAccount();
    }

    @RequestMapping(value = "/accounts/{accountId}", method = RequestMethod.DELETE)
    public void deleteAccount(@PathVariable Long id){
        accountServices.deleteAccount(id);
    }

    @RequestMapping(value = "/customer/{customerId}/accounts", method = RequestMethod.GET)
    public Optional<Account> getAccountByCustomerID(@PathVariable Long customerId){
        return accountServices.getAccountByCustomerId(customerId);
    }


}
