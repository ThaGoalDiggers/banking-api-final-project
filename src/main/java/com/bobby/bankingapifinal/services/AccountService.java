package com.bobby.bankingapifinal.services;

import com.bobby.bankingapifinal.domains.Account;
import com.bobby.bankingapifinal.domains.Customer;
import com.bobby.bankingapifinal.repositories.AccountRepository;
import com.bobby.bankingapifinal.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private CustomerRepository customerRepository;


    public List<Account> getAllAccountsByCustomer(Long customerId){

        List<Account> accounts = new ArrayList<>();
        accountRepository.findByCustomerId(customerId).forEach(accounts::add);
        return accounts;
    }

    public Iterable<Account> getAllAccounts(){
        return accountRepository.findAll();
    }

    public Optional<Account> getOneAccountById(Long accountId){
        return accountRepository.findById(accountId);
    }

    public void createAccount(Account account, Long customerId){

        for(Customer c : customerRepository.findAll()){
            if(c.getId().equals(customerId)){
                account.setCustomer(c);
                accountRepository.save(account);
            }
        }
    }

    public void updateAccount(Account account, Long accountId){
        for(Account acc : accountRepository.findAll()){
            if(acc.getId().equals(accountId)) accountRepository.save(account);
        }
    }

    public void deleteAccount(Long id){
        accountRepository.deleteById(id);
    }
}
