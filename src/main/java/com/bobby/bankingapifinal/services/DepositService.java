package com.bobby.bankingapifinal.services;

import com.bobby.bankingapifinal.domains.Account;
import com.bobby.bankingapifinal.domains.Deposit;
import com.bobby.bankingapifinal.repositories.AccountRepository;
import com.bobby.bankingapifinal.repositories.DepositRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DepositService {

    @Autowired
    private DepositRepository depositRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AccountService accountService;

    public Double depositMoney(Account account, Deposit deposit){
        return account.getBalance() + deposit.getAmount();
    }

    public Iterable<Deposit> getAllDeposits(){
       return depositRepository.findAll();
    }

    public Optional<Deposit> getDepositById(Long id){
        return depositRepository.findById(id);
    }

    public void createDeposit(Deposit deposit, Long accountId){
        for (Account acc : accountService.getAllAccounts()){
            if (acc.getId().equals(accountId)){
                deposit.setAccount(acc);
                depositRepository.save(deposit);
                acc.setBalance((depositMoney(acc, deposit)));
                accountRepository.save(acc);
            }
        }
    }

    public void deleteDeposit(Long id){
        depositRepository.deleteById(id);
    }
}
