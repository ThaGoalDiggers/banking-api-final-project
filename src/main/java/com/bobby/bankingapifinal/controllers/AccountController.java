package com.bobby.bankingapifinal.controllers;


import com.bobby.bankingapifinal.domains.Account;
import com.bobby.bankingapifinal.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountController {


    private AccountRepository accountRepository;
    @Autowired
    public AccountController(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }

    @RequestMapping(value = "/accounts", method = RequestMethod.GET)
    public List<Account> getAllAccounts(@PathVariable )


}
