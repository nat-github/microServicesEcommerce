package com.example.contracttesting.orderservice.controller;

import com.example.contracttesting.orderservice.model.Customer;
import com.example.contracttesting.orderservice.model.Order;
import com.example.contracttesting.orderservice.model.OrderResponse;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.Instant;

@RestController
@RequestMapping
public class ApiOrderController {
    @PostMapping(value = "/api/processOrder",consumes = "application/json",produces = "application/json")
    public OrderResponse processOrder(@RequestBody Order order) throws URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Customer> customer = restTemplate.getForEntity(new URI("http://localhost:8090/api/customers/"+order.getCustomerId()),Customer.class);
        OrderResponse orderresponse = new OrderResponse();
        orderresponse.setOrder_id(order.getOrder_id());
        orderresponse.setOrder_status(order.getOrder_status());
        orderresponse.setOrder_description(order.getOrder_description());
        orderresponse.setCustomerId(order.getCustomerId());
        orderresponse.setCustomerName(customer.getBody().getCustomerName());
        orderresponse.setBillingAddress(customer.getBody().getBillingAddress());
        orderresponse.setPaymentType(customer.getBody().getPaymentType());
        return orderresponse;
    }
    @GetMapping(value="/api/orderStatus", produces = "application/json")
    public Order orderStatus() throws URISyntaxException {
        Order orderresponse = new Order(172481,"In progress","In progress",Boolean.FALSE,"1234");
        //RestTemplate restTemplate = new RestTemplate();
        //ResponseEntity<Customer> customer = restTemplate.getForEntity(new URI("http://localhost:8090/api/customers/"+order.getCustomerId()),Customer.class);
        orderresponse.setOrder_id(172481);
        orderresponse.setOrder_status("In progress");
        orderresponse.setCustomerId("1234");
        orderresponse.setOrder_description("Order description");
        orderresponse.setSpecial_order(Boolean.FALSE);
        return orderresponse;
    }
}
