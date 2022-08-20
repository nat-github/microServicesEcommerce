package com.example.contracttesting.orderservice.model;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OrderResponse {
    private int order_id;
    private String order_description;
    private String order_status;
    private String customerId;
    private String billingAddress;
    private String paymentType;
    private String customerName;

    public OrderResponse(int order_id, String order_description,
                         String order_status,String customerId,String billingAddress,String paymentType,String customerName)
    {
        this.order_id = order_id;
        this.order_description = order_description;
        this.order_status = order_status;
        this.billingAddress = billingAddress;
        this.customerId = customerId;
        this.paymentType = paymentType;
        this.customerName = customerName;

    }
}