package com.bobby.bankingapifinal.services;

import com.bobby.bankingapifinal.domains.Deposit;
import com.bobby.bankingapifinal.repositories.DepositRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class DepositServices {

    @Autowired
    private DepositRepository depositRepository;

    public ResponseEntity<Iterable<Deposit>> getAllDeposits(){
        Iterable<Deposit> allWithdrawals = depositRepository.findAll();
        return new ResponseEntity<>(depositRepository.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<?> getDepositById(Long id){
        depositRepository.findById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public void createDeposit(Deposit deposit){
        depositRepository.save(deposit);
    }

    public void updateDeposit(Deposit deposit){
        depositRepository.save(deposit);
    }

    public void deleteDeposit(Long id){
        depositRepository.deleteById(id);
    }
}
