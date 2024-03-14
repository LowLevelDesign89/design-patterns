package com.app.rental.models.entity;

import com.app.rental.models.enums.PaymentMethod;
import com.app.rental.models.enums.PaymentStatus;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class Payment extends BaseModel {
    private Booking booking;
    private Member member;
    private BigDecimal amount;
    private PaymentMethod paymentMethod;
    private PaymentStatus paymentStatus;
}
