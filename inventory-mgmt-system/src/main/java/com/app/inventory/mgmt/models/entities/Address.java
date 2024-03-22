package com.app.inventory.mgmt.models.entities;

import lombok.Data;

@Data
public class Address {
    private String city;
    private String street;
    private String zipCode;
    private String state;
    private String countryCode;
}
