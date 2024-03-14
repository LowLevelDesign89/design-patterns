package com.app.rental.models.entity;

import lombok.Data;

import java.util.List;

@Data
public class ContactDetails {
    private String emailAddress;
    private List<String> phoneNumbers;
}
