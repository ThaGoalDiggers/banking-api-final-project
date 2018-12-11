package com.bobby.bankingapifinal.services;

import com.bobby.bankingapifinal.domains.Account;
import com.bobby.bankingapifinal.domains.Withdrawal;
import com.bobby.bankingapifinal.repositories.AccountRepository;
import com.bobby.bankingapifinal.repositories.WithdrawalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class WithdrawalService {

    @Autowired
    private WithdrawalRepository withdrawalRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private  AccountService accountService;

    public Double withdrawalMoney(Account account, Withdrawal withdrawal){
        return account.getBalance() - withdrawal.getAmount();
    }

    public Iterable<Withdrawal> getAllWithdrawals(){
        return withdrawalRepository.findAll();
    }

    public List<Withdrawal> getAllWithdrawalsByAccount(Long accountId) {
        List<Withdrawal> withdrawals = new ArrayList<>();
        withdrawalRepository.findByAccountId(accountId).forEach(withdrawals::add);
        return withdrawals;
    }

    public Optional<Withdrawal> getWithdrawalById(Long id){
        return withdrawalRepository.findById(id);
    }

    public void createWithdrawal(Withdrawal withdrawal, Long accountId){
        for (Account acc : accountService.getAllAccounts()){
            if (acc.getId().equals(accountId)){
                withdrawal.setAccount(acc);
                withdrawalRepository.save(withdrawal);
                acc.setBalance(withdrawalMoney(acc, withdrawal));
                accountRepository.save(acc);
            }
        }
    }

    public void deleteDeposit(Long id){
        withdrawalRepository.deleteById(id);
    }
}
