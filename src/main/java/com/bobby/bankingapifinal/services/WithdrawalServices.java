package com.bobby.bankingapifinal.services;

import com.bobby.bankingapifinal.domains.Withdrawal;
import com.bobby.bankingapifinal.repositories.WithdrawalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class WithdrawalServices {

    @Autowired
    private WithdrawalRepository withdrawalRepository;

    private List<Withdrawal> withdrawals = Arrays.asList(
            new Withdrawal(1234567890L, "bluh", "January 2", "Approved", 1234567890L, "Cash", 2000D, "aaaaaaa")
    );

    public ResponseEntity<Iterable<Withdrawal>> getAllWithdrawals(){
        Iterable<Withdrawal> allWithdrawals = withdrawalRepository.findAll();
        return new ResponseEntity<>(withdrawalRepository.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<?> getWithdrawalById(Long id){
        withdrawalRepository.findById(id);
        return new ResponseEntity<>(HttpStatus.OK);
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
