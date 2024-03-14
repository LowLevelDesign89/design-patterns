package com.app.rental.services;

import com.app.rental.models.dto.BookingRequestDto;
import com.app.rental.models.entity.Booking;
import com.app.rental.models.entity.Member;
import com.app.rental.models.entity.Payment;
import com.app.rental.models.enums.PaymentStatus;
import com.app.rental.repository.PaymentRepository;
import com.app.rental.services.strategy.VehiclePricingStrategy;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
public class PaymentService {
    private VehiclePricingStrategy vehiclePricingStrategy;
    private PaymentRepository paymentRepository;

    public PaymentService() {

    }

    public Payment initiatePayment(Booking booking, Member member, BookingRequestDto bookingRequestDto) {
        try {
            Payment payment = new Payment();
            payment.setMember(member);
            payment.setBooking(booking);
            BigDecimal price = vehiclePricingStrategy.calculatePrice(booking.getVehicle(), bookingRequestDto);
            payment.setAmount(price);
            payment.setPaymentMethod(bookingRequestDto.getPaymentMethod());
            payment.setPaymentStatus(PaymentStatus.PAYMENT_COMPLETED);
            Thread.sleep(1000);
            paymentRepository.save(payment);
            return payment;
        } catch (Exception exception) {
           throw new RuntimeException("There was an exception while doing the payment " + exception.getMessage());
        }
    }
}
