package com.app.rental.services.strategy;

import com.app.rental.models.dto.BookingRequestDto;
import com.app.rental.models.entity.Vehicle;

import java.math.BigDecimal;

public interface VehiclePricingStrategy {
    BigDecimal calculatePrice(Vehicle vehicle, BookingRequestDto bookingRequestDto);
}
