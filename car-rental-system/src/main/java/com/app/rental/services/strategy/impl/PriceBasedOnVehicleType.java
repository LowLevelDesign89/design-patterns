package com.app.rental.services.strategy.impl;

import com.app.rental.models.dto.BookingRequestDto;
import com.app.rental.models.entity.Vehicle;
import com.app.rental.models.enums.VehicleType;
import com.app.rental.services.strategy.VehiclePricingStrategy;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.Map;

public class PriceBasedOnVehicleType implements VehiclePricingStrategy {
    private Map<VehicleType, BigDecimal> priceMap = Map.of(VehicleType.CAR, BigDecimal.valueOf(400),
            VehicleType.BIKE, BigDecimal.valueOf(200), VehicleType.CYCLE, BigDecimal.valueOf(100));


    @Override
    public BigDecimal calculatePrice(Vehicle vehicle, BookingRequestDto bookingRequestDto) {
        Duration duration = Duration.between(bookingRequestDto.getBookedFrom(), bookingRequestDto.getBookedTill());
        BigDecimal perDayPrice = priceMap.get(vehicle.getVehicleType());
        return perDayPrice.multiply(BigDecimal.valueOf(duration.toDays()));
    }
}
