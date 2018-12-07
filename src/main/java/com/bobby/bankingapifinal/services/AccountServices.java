package com.bobby.bankingapifinal.services;

import com.bobby.bankingapifinal.domains.Account;
import com.bobby.bankingapifinal.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AccountServices {

    @Autowired
    private AccountRepository accountRepository;


    public List<Account> getAllAccounts(Long customerId){

        List<Account> accounts = new ArrayList<>();
        accountRepository.findByCustomerId(customerId).forEach(accounts::add);
        return accounts;
    }


//    public Optional<Account> getOneAccount(Long customerId){
//        return accountRepository.findByCustomerId(customerId);
//    }



    public void addAccount(Account account){
        accountRepository.save(account);
    }

    public void updateAccount(Account account, Long accountId){
        for (Account a : accountRepository.findAll())
        {
            if (a.getId().equals(accountId)) accountRepository.save(account);
        }
    }

    public void deleteAccount(Long id){
        accountRepository.deleteById(id);
    }
}
