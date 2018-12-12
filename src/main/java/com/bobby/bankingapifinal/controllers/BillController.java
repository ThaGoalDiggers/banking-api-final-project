package com.bobby.bankingapifinal.controllers;
//This controller was made by Derian


import com.bobby.bankingapifinal.domains.Bill;
import com.bobby.bankingapifinal.dto.SuccessDetails;
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
@CrossOrigin(origins = {"http://localhost:4200"})
public class BillController
{



    @Autowired
    private BillService billService;



    @RequestMapping(value = "/bills", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Bill>> getAllBills()throws ResourceNotFoundException
    {
        Iterable<Bill> allBills = billService.getAllBills();
        SuccessDetails successDetails = new SuccessDetails(HttpStatus.OK.value(),"Success",allBills);
        return new ResponseEntity(successDetails, HttpStatus.OK);
    }



    @RequestMapping(value = "/accounts/{accountId}/bills", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Bill>> getAllBillsByAccount(@PathVariable Long accountId)throws ResourceNotFoundException
    {
        Iterable<Bill> bills = billService.getAllBillsByAccount(accountId);
        SuccessDetails successDetails = new SuccessDetails(HttpStatus.OK.value(),"Success",bills);
        return new ResponseEntity(successDetails, HttpStatus.OK);
    }



    @RequestMapping(value = "/bills/{billId}", method = RequestMethod.GET)
    public ResponseEntity<?> getOneBillById(@PathVariable Long billId)
    {
        verifyBill(billId);
        Bill bill = billService.getOneBillById(billId).orElse(null);
        SuccessDetails successDetails = new SuccessDetails(HttpStatus.OK.value(),"Success",bill);
        return new ResponseEntity(successDetails, HttpStatus.OK);
    }



    @RequestMapping(value = "/customers/{customerId}/bills", method = RequestMethod.GET)
    public ResponseEntity<?> getAllBillsByCustomer(@PathVariable Long customerId)throws ResourceNotFoundException
    {
        List<Bill> bills = billService.getAllBillsByCustomer(customerId);
        SuccessDetails successDetails = new SuccessDetails(HttpStatus.OK.value(),"Success",bills);
        return new ResponseEntity(successDetails, HttpStatus.OK);
    }



    @RequestMapping(value = "/accounts/{accountId}/bills", method = RequestMethod.POST)
    public ResponseEntity<?> createBill(@RequestBody Bill bill, @PathVariable Long accountId)throws ResourceNotFoundException
    {
        billService.createBill(bill, accountId);
        HttpHeaders httpHeaders = new HttpHeaders();
        URI newAccountUri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/bills")
                .buildAndExpand(bill.getId())
                .toUri();
        httpHeaders.setLocation(newAccountUri);
        SuccessDetails successDetails = new SuccessDetails(HttpStatus.OK.value(),"Success",bill);
        return new ResponseEntity(successDetails, HttpStatus.OK);
    }



    @RequestMapping(value = "/bills/{billId}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateBill(@RequestBody Bill bill, @PathVariable Long billId)
    {
        verifyBill(billId);
        billService.updateBill(bill, billId);
        SuccessDetails successDetails = new SuccessDetails(HttpStatus.OK.value(),"Success",bill);
        return new ResponseEntity(successDetails, HttpStatus.OK);
    }



    @RequestMapping(value = "/bills/{billId}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteBill(@PathVariable Long billId)
    {
        verifyBill(billId);
        billService.deleteBill(billId);
        SuccessDetails successDetails = new SuccessDetails(HttpStatus.OK.value(),"Success");
        return new ResponseEntity(successDetails, HttpStatus.OK);
    }


    protected void verifyBill(Long billId)  {
        Optional<Bill> account = billService.getOneBillById(billId);
        if(account.equals(Optional.empty())) {
            throw new ResourceNotFoundException("Error Fetching Bill");
        }
    }

}
