package com.app.rental.models.dto;

import com.app.rental.models.enums.PaymentMethod;
import lombok.Data;

import java.time.ZonedDateTime;

@Data
public class BookingRequestDto {
    private Long userId;
    private Long vehicleId;
    private ZonedDateTime bookedFrom;
    private ZonedDateTime bookedTill;
    private PaymentMethod paymentMethod;
}
