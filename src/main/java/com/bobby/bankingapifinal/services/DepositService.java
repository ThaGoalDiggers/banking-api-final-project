package com.bobby.bankingapifinal.services;

import com.bobby.bankingapifinal.domains.Account;
import com.bobby.bankingapifinal.domains.Deposit;
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
    private AccountService accountService;

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
            }
        }
    }

    public void updateDeposit(Deposit deposit, Long depositId){
        for (Deposit d : depositRepository.findAll()){
            if (d.getId().equals(depositId)){
                depositRepository.save(deposit);
            }
        }
    }

    public void deleteDeposit(Long id){
        depositRepository.deleteById(id);
    }
}
