package com.app.rental.repository;

import com.app.rental.models.entity.Payment;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public class PaymentRepository {
    private Map<Long, Payment> payments = new HashMap<>();
    private AtomicLong paymentId = new AtomicLong(1l);

    public Payment save(Payment payment) {
        if(payment.getId() == null) {
            payment.setId(paymentId.get());
            paymentId.incrementAndGet();
        }
        payments.put(payment.getId(), payment);
        return payment;
    }
}
