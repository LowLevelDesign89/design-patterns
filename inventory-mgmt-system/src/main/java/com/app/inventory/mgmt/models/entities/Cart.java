package com.app.inventory.mgmt.models.entities;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class Cart {
    private Map<Product, Integer> cartItems;

    public Cart() {
        cartItems = new HashMap<>();
    }
}
