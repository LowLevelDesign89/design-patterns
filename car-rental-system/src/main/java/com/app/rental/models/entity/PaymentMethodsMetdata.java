package com.app.rental.models.entity;

import com.app.rental.models.enums.PaymentMethod;
import lombok.Data;

@Data
public class PaymentMethodsMetdata {
    private PaymentMethod paymentMethod;
    private String description;
}
