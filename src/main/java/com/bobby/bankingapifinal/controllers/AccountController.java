package com.bobby.bankingapifinal.controllers;


import com.bobby.bankingapifinal.domains.Account;
import com.bobby.bankingapifinal.repositories.AccountRepository;
import com.bobby.bankingapifinal.services.AccountServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountController {


    @Autowired
    private AccountServices accountServices;

    @RequestMapping(value = "/accounts/{accountId}", method = RequestMethod.DELETE)
    public void deleteAccount(@PathVariable Long id){
        accountServices.deleteAccount(id);
    }


}
