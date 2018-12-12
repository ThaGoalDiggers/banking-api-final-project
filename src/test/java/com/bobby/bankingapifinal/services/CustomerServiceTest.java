package com.bobby.bankingapifinal.services;


import com.bobby.bankingapifinal.domains.Customer;
import com.bobby.bankingapifinal.exceptions.ResourceNotFoundException;
import com.bobby.bankingapifinal.repositories.CustomerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Arrays;
import java.util.Collections;
import java.util.Optional;
import static org.mockito.Mockito.when;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class CustomerServiceTest {



    @Mock
    private CustomerRepository repository;

    @InjectMocks
    private CustomerService customerServiceMock;

//
//
//    @Test
//    public void getAllCustomersNoCustomersTest(){
//        when(customerServiceMock.getAllCustomers()).thenReturn(Collections.emptyList());
//        assertEquals(repository.findAll(), customerServiceMock.getAllCustomers());
//    }
////
//
//
//    @Test
//    public void getAllCustomersOneCustomerTest(){
//        when(customerServiceMock.getAllCustomers()).thenReturn(
//                Arrays.asList(new Customer("Zach", "Rivera",  null)
//                ));
//
//        assertEquals(repository.findAll(), customerServiceMock.getAllCustomers());
//    }
//
//    @Test
//    public void getAllCustomersMultipleCustomersTest() {
//        when(customerServiceMock.getAllCustomers()).thenReturn(
//                Arrays.asList(new Customer("Zach", "Rivera", null),
//                        new Customer("jimmy", "janggles", null),
//                        new Customer("zippity", "Scrogeballs", null)
//                ));
//
//        assertEquals(repository.findAll(), customerServiceMock.getAllCustomers());
//    }
//
////FIND ONE CUSTOMER BY ID
//
//    @Test
//    public void getOneCustomerByAccountIdTest() {
//        when(customerServiceMock.getOneCustomerById(1l)).thenReturn(Optional.of(
//                new Customer("Zach", "Rivera", null)
//        ));
//
//        Optional<Customer> customers = customerServiceMock.getOneCustomerById(1l);
//
//        assertEquals(repository.findById(1l),customers);
//
//    }
//








    //=============================
}
