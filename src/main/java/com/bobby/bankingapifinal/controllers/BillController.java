package com.bobby.bankingapifinal.controllers;
//This controller was made by Derian


import com.bobby.bankingapifinal.domains.Bill;
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



    @RequestMapping(value = "/accounts/{accountId}/bills", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Bill>> getAllBillsByAccount(@PathVariable Long accountId)
    {
        Iterable<Bill> bills = billService.getAllBillsByAccount(accountId);
        return new ResponseEntity<>(bills, HttpStatus.OK);
    }



    @RequestMapping(value = "/bills/{billId}", method = RequestMethod.GET)
    public ResponseEntity<?> getBill(@PathVariable Long billId)
    {
        Optional<Bill> bill = billService.getBill(billId);
        return new ResponseEntity<>(bill, HttpStatus.OK);
    }



    @RequestMapping(value = "/customers/{customerId}/bills", method = RequestMethod.GET)
    public ResponseEntity<?> getAllBillsByCustomer(@PathVariable Long customerId)
    {
        List<Bill> bills = billService.getAllBillsByCustomer(customerId);
        return new ResponseEntity<>(bills, HttpStatus.OK);
    }



    @RequestMapping(value = "/accounts/{accountId}/bills", method = RequestMethod.POST)
    public ResponseEntity<?> addBill(@RequestBody Bill bill, @PathVariable Long accountId)
    {
        billService.addBill(bill);
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newBillUri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(bill.getId())
                .toUri();
        responseHeaders.setLocation(newBillUri);
        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }



    @RequestMapping(value = "/bills/{billId}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateBill(@RequestBody Bill bill, @PathVariable Long billId)
    {
        if(billService.getBill(billId) == null)
        {
            billService.addBill(bill);

            return new ResponseEntity<>(bill, HttpStatus.OK);
        }

        else
        {
            billService.updateBill(bill);

            return new ResponseEntity<>(bill, HttpStatus.OK);
        }
    }



    @RequestMapping(value = "/bills/{billId}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteBill(@PathVariable Long billId)
    {
            billService.deleteBill(billId);

            return new ResponseEntity<>(HttpStatus.OK);
    }



}
