package com.bobby.bankingapifinal.controllers;
//This controller was made by Derian


import com.bobby.bankingapifinal.domains.Bill;
import com.bobby.bankingapifinal.services.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;



@RestController
public class BillController
{



    @Autowired
    private BillService billService;



//    @RequestMapping(value = "/accounts/{accountId}/bills", method = RequestMethod.GET)
//    public List<Bill> getAllBillsByAccount(@PathVariable Long accountId)
//    { return billService.getAllBillsByAccount(accountId); }



    @RequestMapping(value = "/bills/{billId}", method = RequestMethod.GET)
    public Optional<Bill> getBill(@PathVariable Long billId)
    { return billService.getBill(billId); }



//    @RequestMapping(value = "/customers/{customerId}/bills", method = RequestMethod.GET)
//    public List<Bill> getAllBillsByCustomer(@PathVariable Long customerId)
//    { return billService.getAllBillsByCustomer(customerId); }



    @RequestMapping(value = "/accounts/{accountId}/bills", method = RequestMethod.POST)
    public void addBill(@RequestBody Bill bill, @PathVariable Long accountId)
    { billService.addBill(bill); }



    @RequestMapping(value = "/bills/{billId}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateBill(@RequestBody Bill bill, @PathVariable Long billId)
    {
        if(billService.getBill(billId) == null)
        {
            billService.addBill(bill);

            return new ResponseEntity<>(HttpStatus.CREATED);
        }

        else
        {
            billService.updateBill(bill);

            return new ResponseEntity<>(HttpStatus.OK);
        }
    }



    @RequestMapping(value = "/bills/{billId}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteBill(@PathVariable Long billId)
    {
        if(billService.getBill(billId) != null)
        {
            billService.deleteBill(billId);

            return new ResponseEntity<>(HttpStatus.OK);
        }

        else
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }



}
