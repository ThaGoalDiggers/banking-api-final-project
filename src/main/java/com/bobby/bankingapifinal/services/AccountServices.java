package com.bobby.bankingapifinal.services;

import com.bobby.bankingapifinal.domains.Account;
import com.bobby.bankingapifinal.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountServices {

    private AccountRepository accountRepository;


    public List<Account> getAllAccount(Long id){
        List<Account> accounts = new ArrayList<>();
        accountRepository.findById(id);
        return accounts;
    }

    public void addAccount(Account account){
        accountRepository.save(account);
    }

    public void updateAccont(Account account){
        accountRepository.save(account);
    }

    public void deleteAccount(Long id){
        accountRepository.deleteById(id);
    }
}
