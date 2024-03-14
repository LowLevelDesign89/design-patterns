package com.app.rental.models.dto;

import com.app.rental.models.entity.Payment;
import com.app.rental.models.entity.Vehicle;
import lombok.Data;

@Data
public class BookingResponseDto {
    private Vehicle vehicle;
    private Payment payment;
    private UserResponseDto userResponseDto;
}
