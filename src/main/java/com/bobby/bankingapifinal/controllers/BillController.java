package com.bobby.bankingapifinal.controllers;
//This controller was made by Derian


import com.bobby.bankingapifinal.domains.Bill;
import com.bobby.bankingapifinal.exceptions.ResourceNotFoundException;
import com.bobby.bankingapifinal.services.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import java.net.URI;
import java.util.List;
import java.util.Optional;


@RestController
public class BillController
{



    @Autowired
    private BillService billService;



    @RequestMapping(value = "/bills", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Bill>> getAllBills()
    {
        Iterable<Bill> allBills = billService.getAllBills();
        return new ResponseEntity<>(allBills, HttpStatus.OK);
    }



    @RequestMapping(value = "/accounts/{accountId}/bills", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Bill>> getAllBillsByAccount(@PathVariable Long accountId)
    {
        Iterable<Bill> bills = billService.getAllBillsByAccount(accountId);
        return new ResponseEntity<>(bills, HttpStatus.OK);
    }



    @RequestMapping(value = "/bills/{billId}", method = RequestMethod.GET)
    public ResponseEntity<?> getOneBillById(@PathVariable Long billId)
    {
        verifyBill(billId);
        Bill bill = billService.getOneBillById(billId).orElse(null);
        return new ResponseEntity<>(bill, HttpStatus.OK);
    }



    @RequestMapping(value = "/customers/{customerId}/bills", method = RequestMethod.GET)
    public ResponseEntity<?> getAllBillsByCustomer(@PathVariable Long customerId)
    {
        List<Bill> bills = billService.getAllBillsByCustomer(customerId);
        return new ResponseEntity<>(bills, HttpStatus.OK);
    }



    @RequestMapping(value = "/accounts/{accountId}/bills", method = RequestMethod.POST)
    public ResponseEntity<?> createBill(@RequestBody Bill bill, @PathVariable Long accountId)
    {
        billService.createBill(bill, accountId);
        HttpHeaders httpHeaders = new HttpHeaders();
        URI newAccountUri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/bills")
                .buildAndExpand(bill.getId())
                .toUri();
        httpHeaders.setLocation(newAccountUri);
        return new ResponseEntity<>(bill,httpHeaders,HttpStatus.CREATED);
    }



    @RequestMapping(value = "/bills/{billId}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateBill(@RequestBody Bill bill, @PathVariable Long billId)
    {
        verifyBill(billId);
        billService.updateBill(bill, billId);
        return new ResponseEntity<>(bill, HttpStatus.OK);
    }



    @RequestMapping(value = "/bills/{billId}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteBill(@PathVariable Long billId)
    {
        verifyBill(billId);
        billService.deleteBill(billId);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    protected void verifyBill(Long billId)  {
        Optional<Bill> account = billService.getOneBillById(billId);
        if(account.equals(Optional.empty())) {
            throw new ResourceNotFoundException("Error Fetching Bill");
        }
    }

}
