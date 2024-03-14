package com.app.rental.models.entity;

import lombok.Data;

@Data
public class Store extends BaseModel {
    private String storeName;
    private String description;
    private Address address;
    private ContactDetails contactDetails;
}
