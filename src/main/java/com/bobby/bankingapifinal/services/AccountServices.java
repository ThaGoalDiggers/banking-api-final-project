package com.bobby.bankingapifinal.services;

import com.bobby.bankingapifinal.domains.Account;
import com.bobby.bankingapifinal.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountServices {

    @Autowired
    private AccountRepository accountRepository;


    public Optional<Account> getAccountByCustomerId(Long customerId){
        return accountRepository.findById(customerId);
    }


    public Optional<Account> getOneAccount(Long id){
        return accountRepository.findById(id);
    }

    public Iterable<Account> getAllAccount(){
        return accountRepository.findAll();
    }

    public Account addAccount(Account account){
        accountRepository.save(account);
        return account;
    }

    public Account updateAccont(Account account){
        accountRepository.save(account);
        return account;
    }

    public void deleteAccount(Long id){
        accountRepository.deleteById(id);
    }
}
