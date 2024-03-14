package com.app.rental.models.entity;

import lombok.Data;

@Data
public class Address extends BaseModel {
    private String street;
    private String city;
    private String state;
    private String countryCode;
    private String zipCode;
}
