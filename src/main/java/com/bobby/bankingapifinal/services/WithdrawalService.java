package com.bobby.bankingapifinal.services;

import com.bobby.bankingapifinal.domains.Withdrawal;
import com.bobby.bankingapifinal.repositories.WithdrawalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WithdrawalService {

    @Autowired
    private WithdrawalRepository withdrawalRepository;

    @Autowired
    private  AccountService accountService;

    public Iterable<Withdrawal> getAllWithdrawals(){
        return withdrawalRepository.findAll();
    }

    public Optional<Withdrawal> getWithdrawalById(Long id){
        return withdrawalRepository.findById(id);
    }

    public void createWithdrawal(Withdrawal withdrawal){
        withdrawalRepository.save(withdrawal);
    }

    public void updateWithdrawal(Withdrawal withdrawal){
        withdrawalRepository.save(withdrawal);
    }

    public void deleteDeposit(Long id){
        withdrawalRepository.deleteById(id);
    }
}
