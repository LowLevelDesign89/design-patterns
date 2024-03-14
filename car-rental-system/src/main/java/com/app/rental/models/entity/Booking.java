package com.app.rental.models.entity;

import com.app.rental.models.enums.BookingStatus;
import lombok.Data;

import java.time.ZonedDateTime;

@Data
public class Booking extends BaseModel {
    private Member member;
    private Vehicle vehicle;
    private ZonedDateTime bookedOn;
    private ZonedDateTime bookedFrom;
    private ZonedDateTime bookedTo;
    private BookingStatus bookingStatus;
}
