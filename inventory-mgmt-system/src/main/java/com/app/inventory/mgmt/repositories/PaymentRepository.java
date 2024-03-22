package com.app.inventory.mgmt.repositories;

import com.app.inventory.mgmt.models.entities.Payment;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class PaymentRepository {
    private Map<String, Payment> payments = new HashMap<>();

    public Payment save(Payment payment) {
        if(payment.getId() == null) {
            payment.setId(UUID.randomUUID().toString());
        }
        payments.put(payment.getId(), payment);
        return payment;
    }
}
