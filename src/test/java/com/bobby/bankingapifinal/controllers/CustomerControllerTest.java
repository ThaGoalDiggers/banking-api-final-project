package com.bobby.bankingapifinal.controllers;


import com.bobby.bankingapifinal.services.CustomerService;

import org.junit.Before;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


@RunWith(SpringRunner.class)
@WebMvcTest(CustomerController.class)
@WebAppConfiguration
public class CustomerControllerTest {



    @Autowired
    private WebApplicationContext wac;
    private MockMvc mockMvc;
    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerController customerController;


    @Before
    public void setup() {
        this.mockMvc =
                MockMvcBuilders.webAppContextSetup
                        (this.wac).build();
    }



}
