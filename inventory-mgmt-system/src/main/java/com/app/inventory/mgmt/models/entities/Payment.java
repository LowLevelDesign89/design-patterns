package com.app.inventory.mgmt.models.entities;

import com.app.inventory.mgmt.models.enums.PaymentMethod;
import com.app.inventory.mgmt.models.enums.PaymentStatus;
import lombok.Data;

@Data
public class Payment {
    private String id;
    private PaymentMethod paymentMethod;
    private PaymentStatus paymentStatus;
    private String accountId;
}
