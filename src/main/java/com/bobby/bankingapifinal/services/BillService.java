package com.bobby.bankingapifinal.services;



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



    //GET all bills for a specified account
    public List<Bill> getAllBillsByAccount(Long accountId)
    {
        List<Bill> bills = new ArrayList<>();
        billRepository.findByAccountId(accountId).forEach(bills::add);
        return bills;
    }



    //GET a bill by id
    public Optional<Bill> getBill(Long id)
    { return billRepository.findById(id); }



    //GET all bills for a customer
    public List<Bill> getAllBillsByCustomer(Long customerId)
    {
        List<Bill> bills = new ArrayList<>();
        billRepository.findByCustomerId(customerId).forEach(bills::add);
        return bills;
    }



    //POST a bill
    public void addBill(Bill bill)
    { billRepository.save(bill); }



    //PUT a bill (update)
    public void updateBill(Bill bill)
    { billRepository.save(bill); }



    //DELETE a bill
    public void deleteBill(Long id)
    {

        Bill billToDelete;

        for(Bill b : billRepository.findAll())
        {
            if (b.getId() == id)
            {
                billToDelete = b;
                billRepository.delete(billToDelete);
            }
        }

    }



}
