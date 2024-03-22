package com.app.inventory.mgmt.services;

import com.app.inventory.mgmt.models.dtos.OrderRequestDTO;
import com.app.inventory.mgmt.models.entities.Payment;
import com.app.inventory.mgmt.models.enums.PaymentStatus;
import com.app.inventory.mgmt.repositories.PaymentRepository;
import lombok.AllArgsConstructor;

// this service is responsible for calling payment gateway and perform the payment
@AllArgsConstructor
public class PaymentService {
    private PaymentRepository paymentRepository;

    public Payment initiatePayment(OrderRequestDTO orderRequestDTO) throws Exception{
        Payment payment = new Payment();
        payment.setPaymentMethod(orderRequestDTO.getPaymentMethod());
        payment.setAccountId(orderRequestDTO.getPaymentAccountId());
        payment.setPaymentStatus(PaymentStatus.INITIATED);
        paymentRepository.save(payment);
        try {
            Thread.sleep(1000);
        } catch (Exception ex) {
            payment.setPaymentStatus(PaymentStatus.PAYMENT_FAILURE);
            paymentRepository.save(payment);
            throw ex;
        }
        payment.setPaymentStatus(PaymentStatus.PAYMENT_SUCCESSFUL);
        paymentRepository.save(payment);
        return payment;
    }
}
