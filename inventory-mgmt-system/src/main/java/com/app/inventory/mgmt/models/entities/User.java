package com.app.inventory.mgmt.models.entities;

import lombok.Data;

import java.util.List;

@Data
public class User {
    private String id;
    private String name;
    private String email;
    private String phoneNumber;
    private List<Address> deliveryAddresses;
    private Cart cart;
}
