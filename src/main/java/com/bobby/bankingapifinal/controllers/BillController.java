package com.bobby.bankingapifinal.controllers;



import com.bobby.bankingapifinal.domains.Bill;
import com.bobby.bankingapifinal.services.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;



@RestController
public class BillController
{



    @Autowired
    private BillService billService;



    @RequestMapping(method = RequestMethod.GET, value = "/accounts/{accountId}/bills")
    public List<Bill> getAllBillsByAccount(@PathVariable Long accountId)
    { return billService.getAllBillsByAccount(accountId); }



    @RequestMapping(method = RequestMethod.GET, value = "/bills/{billId}")
    public Optional<Bill> getBill(@PathVariable Long billId)
    { return billService.getBill(billId); }



    @RequestMapping(method = RequestMethod.GET, value = "/customers/{customerId}/bills")
    public List<Bill> getAllBillsByCustomer(@PathVariable Long customerId)
    { return billService.getAllBillsByCustomer(customerId); }



    @RequestMapping(method = RequestMethod.POST, value = "/accounts/{accountId}/bills")
    public void addBill(@RequestBody Bill bill, @PathVariable Long accountId)
    { billService.addBill(bill); }



    @RequestMapping(method = RequestMethod.PUT, value = "/bills/{billId}")
    public void updateBill(@RequestBody Bill bill, @PathVariable Long billId)
    { billService.updateBill(bill); }



    @RequestMapping(method = RequestMethod.DELETE, value = "/bills/{billId}")
    public void deleteBill(@PathVariable Long billId)
    { billService.deleteBill(billId); }



}
