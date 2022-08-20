package com.example.contracttesting.customerservice.controller;

import com.example.contracttesting.customerservice.model.Customer;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class ApiCustomerController {
    @GetMapping(value = "/api/customers/{id}", produces = "application/json")
    public Customer getCustomer(@PathVariable(value = "id") String id){
        Customer customerresponse = new Customer();
        customerresponse.setCustomerId("172481");
        customerresponse.setCustomerName("Contract Testing");
        customerresponse.setBillingAddress("Cognizant");
        customerresponse.setPaymentType("Credit card");
        return customerresponse;
    }
}
