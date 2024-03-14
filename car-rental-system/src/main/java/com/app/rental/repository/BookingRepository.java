package com.app.rental.repository;

import com.app.rental.models.entity.Booking;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public class BookingRepository {
    private Map<Long, Booking> bookings = new HashMap<>();
    private AtomicLong bookingId = new AtomicLong(1l);

    public Booking save(Booking booking) {
        if(booking.getId() == null) {
            booking.setId(bookingId.get());
            bookingId.incrementAndGet();
        }
        bookings.put(booking.getId(), booking);
        return booking;
    }
}
