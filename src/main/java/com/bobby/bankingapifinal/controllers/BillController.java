package com.bobby.bankingapifinal.controllers;
//This controller was made by Derian


import com.bobby.bankingapifinal.domains.Bill;
import com.bobby.bankingapifinal.exceptions.ResourceNotFoundException;
import com.bobby.bankingapifinal.services.AccountService;
import com.bobby.bankingapifinal.services.BillService;
import com.bobby.bankingapifinal.services.CustomerService;
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

    @Autowired
    private AccountService accountService;

    @Autowired
    private CustomerService customerService;



    @RequestMapping(value = "/accounts/{accountId}/bills", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Bill>> getAllBillsByAccount(@PathVariable Long accountId)
    {
//        verifyAccount(accountId);
        Iterable<Bill> bills = billService.getAllBillsByAccount(accountId);
        return new ResponseEntity<>(bills, HttpStatus.OK);
    }



    @RequestMapping(value = "/bills/{billId}", method = RequestMethod.GET)
    public ResponseEntity<?> getBill(@PathVariable Long billId)
    {
        verifyBill(billId);
        Optional<Bill> bill = billService.getBill(billId);
        return new ResponseEntity<>(bill, HttpStatus.OK);
    }



    @RequestMapping(value = "/customers/{customerId}/bills", method = RequestMethod.GET)
    public ResponseEntity<?> getAllBillsByCustomer(@PathVariable Long customerId)
    {
//        verifyCustomer(customerId);
        List<Bill> bills = billService.getAllBillsByCustomer(customerId);
        return new ResponseEntity<>(bills, HttpStatus.OK);
    }



    @RequestMapping(value = "/accounts/{accountId}/bills", method = RequestMethod.POST)
    public ResponseEntity<?> addBill(@RequestBody Bill bill, @PathVariable Long accountId)
    {

//        verifyAccount(accountId);

        billService.addBill(bill);
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newBillUri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(bill.getId())
                .toUri();
        responseHeaders.setLocation(newBillUri);
        return new ResponseEntity<>(bill, responseHeaders, HttpStatus.CREATED);
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



    protected void verifyBill(Long billId) throws ResourceNotFoundException
    {
        Bill bill = billService.getBill(billId).isPresent() ? billService.getBill(billId).get() : null;
        System.out.println(bill);
        if(bill == (null))
        {
            throw new ResourceNotFoundException("Bill with id " + billId + " not found");
        }
    }



//    protected void verifyAccount(Long accountId) throws ResourceNotFoundException
//    {
//        Account account = accountService.getOneAccount(accountId).isPresent() ? accountService.getOneAccount(accountId).get() : null;
//        System.out.println(account);
//        if(account == (null))
//        {
//            throw new ResourceNotFoundException("Account with id " + accountId + " not found");
//        }
//    }



//    protected void verifyCustomer(Long customerId) throws ResourceNotFoundException
//    {
//        Customer customer = customerService.findbycustomerid(customerId).isPresent() ? customerService.findbycustomerid(customerId).get() : null;
//        System.out.println(customer);
//        if(customer == (null))
//        {
//            throw new ResourceNotFoundException("Customer with id " + customerId + " not found");
//        }
//    }



}
