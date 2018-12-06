package com.bobby.bankingapifinal.services;

import com.bobby.bankingapifinal.domains.Deposit;
import com.bobby.bankingapifinal.repositories.DepositRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class DepositServices {

    @Autowired
    private DepositRepository depositRepository;

    public Iterable<Deposit> getAllDeposits(){
        return depositRepository.findAll();
    }

    public Optional<Deposit> getDepositById(Long id){
        return depositRepository.findById(id);
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
