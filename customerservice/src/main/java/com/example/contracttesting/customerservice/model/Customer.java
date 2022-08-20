package com.example.contracttesting.customerservice.model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
//@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    private String customerName;
    private String billingAddress;
    private String paymentType;
    private String customerId;
}