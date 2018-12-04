package com.bobby.bankingapifinal.services;

import com.bobby.bankingapifinal.domains.Address;
import com.bobby.bankingapifinal.domains.Customer;
import com.bobby.bankingapifinal.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CustomerService {


  public Set<Address> addies = new HashSet<Address>(Arrays.asList(
          new Address("street","3232","cityy","zip")

  ));



    public List<Customer> customers = new ArrayList<>(Arrays.asList(

            new Customer("zach","rivera",addies)
    ));


    //GET ALL
    public List<Customer> getAllCustomer(){
        return customers;
    }

    //GET ONE
    public Customer getCustomerbyID(Long customerid){
        return customers.stream().filter(c -> c.getId().equals(customerid)).findFirst().get();
    }


   //


}
