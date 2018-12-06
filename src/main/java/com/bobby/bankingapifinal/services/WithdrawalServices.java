package com.bobby.bankingapifinal.services;

import com.bobby.bankingapifinal.domains.Withdrawal;
import com.bobby.bankingapifinal.repositories.WithdrawalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class WithdrawalServices {

    @Autowired
    private WithdrawalRepository withdrawalRepository;

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
