package com.app.rental.controller;

import com.app.rental.models.dto.BookingRequestDto;
import com.app.rental.models.dto.BookingResponseDto;
import com.app.rental.services.BookingService;

public class BookingController {
    private BookingService bookingService;
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    public BookingResponseDto bookVehicle(BookingRequestDto bookingRequestDto) {
        return bookingService.createBooking(bookingRequestDto);
    }
}
