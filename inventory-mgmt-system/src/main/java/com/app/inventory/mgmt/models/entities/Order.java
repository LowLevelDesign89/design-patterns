package com.app.inventory.mgmt.models.entities;

import com.app.inventory.mgmt.models.enums.OrderStatus;
import lombok.Data;

import java.util.Map;

@Data
public class Order {
    private String id;
    private User user;
    private Map<Product, Integer> cartMap;
    private Warehouse warehouse;
    private OrderStatus orderStatus;
    private Payment payment;
    private Invoice invoice;
    private Address address;
}
