package com.bobby.bankingapifinal.controllers;


import com.bobby.bankingapifinal.domains.Account;
import com.bobby.bankingapifinal.repositories.AccountRepository;
import com.bobby.bankingapifinal.services.AccountServices;
import org.hibernate.validator.constraints.pl.REGON;
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
public class AccountController {


    @Autowired
    private AccountServices accountServices;


    @RequestMapping(value = "/customers/accounts", method = RequestMethod.POST)
    public ResponseEntity<?> createAccount(@RequestBody Account account){
        accountServices.addAccount(account);
        HttpHeaders httpHeaders = new HttpHeaders();
        URI newAccountUri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(account.getId())
                .toUri();
        httpHeaders.setLocation(newAccountUri);
        return new ResponseEntity<>(null,HttpStatus.CREATED);
    }

    @RequestMapping(value = "/accounts/{accountId}", method = RequestMethod.PUT)
    public void updateAccount(@RequestBody Account account, @PathVariable Long accountId){
        accountServices.updateAccont(account);
    }

    @RequestMapping(value = "/accounts/{accountId}", method = RequestMethod.GET)
    public Optional<Account> getOneAccount(@PathVariable Long accountId){
        return accountServices.getOneAccount(accountId);
    }

    @Autowired
    private AccountRepository accountRepository;

    @RequestMapping(value = "/accounts", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Account>> getAllAccount(){
        Iterable<Account> allAccounts = accountRepository.findAll();
        return new ResponseEntity<>(allAccounts, HttpStatus.OK);
    }

    @RequestMapping(value = "/accounts/{accountId}", method = RequestMethod.DELETE)
    public void deleteAccount(@PathVariable Long accountId){
        accountServices.deleteAccount(accountId);
    }

    @RequestMapping(value = "/customer/{customerId}/accounts", method = RequestMethod.GET)
    public Optional<Account> getAccountByCustomerID(@PathVariable Long customerId){
        return accountServices.getAccountByCustomerId(customerId);
    }


//[
//    {
//        "id": 1,
//            "accountType": "SAVINGS",
//            "nickName": "Tsavage",
//            "rewards": 20,
//            "balance": 20.000,
//            "customer":{
//        "firstName": "Zach",
//                "lastName": "Rivera",
//                "address":[
//        {
//            "id":1,
//                "streetNumber": "701",
//                "streetname": "Birchwood dr",
//                "city": "Newark",
//                "state":"DE",
//                "zip":"19713"
//        },
//        {
//            "id":2,
//                "streetNumber": "7",
//                "streetname": "Birch",
//                "city": "New",
//                "state":"DE",
//                "zip":"19713"
//        }
//        ]
//
//    }
//   }
//]


}
