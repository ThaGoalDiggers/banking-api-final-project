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
        System.out.println("getAllBillsByAccount method called");

        List<Bill> bills = new ArrayList<>();
        System.out.println("bills ArrayList created");

        billRepository.findByAccountId(accountId).forEach(bills::add);
        System.out.println("each bill from account #" + accountId + "added to bills ArrayList");

        System.out.println("Bills: " + bills);
        return bills;
    }



    //GET a bill by id
    public Optional<Bill> getBill(Long id)
    {
        System.out.println("getBill method called");

        return billRepository.findById(id);
    }



    //GET all bills for a customer
    public List<Bill> getAllBillsByCustomer(Long customerId)
    {
        System.out.println("getAllBillsByCustomer method called");

        List<Bill> bills = new ArrayList<>();
        System.out.println("bills ArrayList created");

        billRepository.findByCustomerId(customerId).forEach(bills::add);
        System.out.println("each bill for customer #" + customerId + "added to bills ArrayList");

        System.out.println("Bills: " + bills);
        return bills;
    }



    //POST a bill
    public void addBill(Bill bill)
    {
        System.out.println("addBill method called");

        billRepository.save(bill);

        System.out.println("bill added");
    }



    //PUT a bill (update)
    public void updateBill(Bill bill)
    {
        System.out.println("updateBill method called");

        billRepository.save(bill);

        System.out.println("bill updated");
    }



    //DELETE a bill
    public void deleteBill(Long id)
    {
        System.out.println("deleteBill method called");

        Bill billToDelete;

        for(Bill b : billRepository.findAll())
        {
            System.out.println("searching for bill with id #" + id);
            if (b.getId() == id)
            {
                System.out.println("bill #" + id + "found");
                billToDelete = b;
                billRepository.delete(billToDelete);
                System.out.println("bill #" + id + "deleted");
            }
        }

    }



}
