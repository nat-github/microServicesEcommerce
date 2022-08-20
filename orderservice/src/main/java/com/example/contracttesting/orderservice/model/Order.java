package com.example.contracttesting.orderservice.model;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Order {
    private int order_id;
    private String order_description;
    private String order_status;
    private Boolean special_order;
    private String customerId;

    public Order(int order_id, String order_description, String order_status, Boolean special_order,String customerId)
    {
        this.order_id = order_id;
        this.order_description = order_description;
        this.order_status = order_status;
        this.special_order = special_order;
        this.customerId = customerId;
    }
}