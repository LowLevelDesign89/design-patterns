package com.app.rental.models.dto;

import com.app.rental.models.entity.Address;
import com.app.rental.models.entity.PaymentMethodsMetdata;
import lombok.Data;

@Data
public class UserRequestDto {
    private String username;
    private String password;
    private Address address;
    private String emailAddress;
    private String phoneNumber;
    private PaymentMethodsMetdata paymentMethodsMetdata;

}
