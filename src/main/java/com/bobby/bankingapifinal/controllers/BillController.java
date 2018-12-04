package com.bobby.bankingapifinal.controllers;



import com.bobby.bankingapifinal.domains.Bill;
import com.bobby.bankingapifinal.services.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class BillController
{



    @Autowired
    private BillService billService;



    @RequestMapping("/accounts/{accountId}/bills")
    public List<Bill> getAllBillsByAccount(@PathVariable Long id)
    { return billService.getAllBillsByAccount(id); }



}
