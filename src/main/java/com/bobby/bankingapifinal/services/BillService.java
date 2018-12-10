package com.bobby.bankingapifinal.services;
//This service was made by Derian


import com.bobby.bankingapifinal.domains.Account;
import com.bobby.bankingapifinal.domains.Bill;
import com.bobby.bankingapifinal.repositories.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




import java.util.ArrayList;
import java.util.List;
import java.util.Optional;



@Service
public class BillService
{



    @Autowired
    private BillRepository billRepository;

    @Autowired
    private AccountService accountService;



    //GET all bills for a specified account
    public List<Bill> getAllBillsByAccount(Long accountId)
    {
        List<Bill> bills = new ArrayList<>();
        billRepository.findByAccountId(accountId).forEach(bills::add);
        return bills;
    }



    //GET all bills
    public Iterable<Bill> getAllBills()
    { return billRepository.findAll(); }



    //GET a bill by id
    public Optional<Bill> getOneBillById(Long id)
    { return billRepository.findById(id); }



    //GET all bills for a customer
    public List<Bill> getAllBillsByCustomer(Long customerId)
    {
        List<Account> accounts = accountService.getAllAccountsByCustomer(customerId);
        List<Bill> bills = new ArrayList<>();

        for(Account acc : accounts)
        { billRepository.findByAccountId(acc.getId()).forEach(bills::add); }

        return bills;
    }



    //POST a bill
    public void createBill(Bill bill, Long accountId)
    {
        for(Account acc : accountService.getAllAccounts())
        {
            if(acc.getId().equals(accountId))
            {
                bill.setAccount(acc);
                billRepository.save(bill);
            }
        }
    }



    //PUT a bill (update)
    public void updateBill(Bill bill, Long billId)
    {
        for(Bill b : billRepository.findAll())
        {
            if(b.getId().equals(billId)) billRepository.save(bill);
        }
    }



    //DELETE a bill
    public void deleteBill(Long id)
    { billRepository.deleteById(id); }



}
