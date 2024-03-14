package com.app.rental.services;

import com.app.rental.models.dto.BookingRequestDto;
import com.app.rental.models.dto.BookingResponseDto;
import com.app.rental.models.dto.UserResponseDto;
import com.app.rental.models.entity.Booking;
import com.app.rental.models.entity.Member;
import com.app.rental.models.entity.Payment;
import com.app.rental.models.entity.Vehicle;
import com.app.rental.models.enums.BookingStatus;
import com.app.rental.models.enums.VehicleReservationStatus;
import com.app.rental.repository.BookingRepository;
import com.app.rental.repository.UserRepository;
import com.app.rental.repository.VehicleRepository;
import lombok.AllArgsConstructor;

import java.time.ZonedDateTime;
import java.util.Optional;

@AllArgsConstructor
public class BookingService {
    private UserRepository userRepository;
    private VehicleRepository vehicleRepository;
    private BookingRepository bookingRepository;
    private SearchService searchService;
    private PaymentService paymentService;

    public BookingResponseDto createBooking(BookingRequestDto bookingRequestDto) {
        Optional<Member> member = userRepository.findById(bookingRequestDto.getUserId());
        if(!member.isPresent()) {
            throw new RuntimeException("User with ID " + bookingRequestDto.getUserId() + " not found");
        }
        Optional<Vehicle> vehicleOptional = vehicleRepository.findById(bookingRequestDto.getVehicleId());
        if(!vehicleOptional.isPresent()) {
            throw new RuntimeException("Vehicle with ID " + bookingRequestDto.getVehicleId() + " not found");
        }
        Vehicle vehicle = vehicleOptional.get();
        if(vehicle.getVehicleReservationStatus() != VehicleReservationStatus.AVAILABLE) {
            throw new RuntimeException("Requsted vehicle " + vehicle + " is not available anymore");
        }
        Booking booking = new Booking();
        booking.setMember(member.get());
        booking.setVehicle(vehicle);
        booking.setBookedOn(ZonedDateTime.now());
        booking.setBookedFrom(bookingRequestDto.getBookedFrom());
        booking.setBookedTo(bookingRequestDto.getBookedTill());
        booking.setBookingStatus(BookingStatus.IN_PROGRESS);
        vehicle.setVehicleReservationStatus(VehicleReservationStatus.BOOKED);
        bookingRepository.save(booking);
        vehicleRepository.save(vehicle);
        searchService.changeStatusFromTo(VehicleReservationStatus.AVAILABLE, VehicleReservationStatus.BOOKED, vehicle);

        // do the payment
        // if fails mark the booking cancelled and adjust the status of vehicle
        Payment createdOPayment = null;
        try {
            createdOPayment = paymentService.initiatePayment(booking, member.get(), bookingRequestDto);
        } catch (Exception exception) {
            vehicle = vehicleRepository.findById(bookingRequestDto.getVehicleId()).get();
            vehicle.setVehicleReservationStatus(VehicleReservationStatus.AVAILABLE);
            vehicleRepository.save(vehicle);
            booking.setBookingStatus(BookingStatus.FAILURE);
            bookingRepository.save(booking);
            searchService.changeStatusFromTo(VehicleReservationStatus.BOOKED, VehicleReservationStatus.AVAILABLE, vehicle);
        }
        return populateResponseDto(vehicle, createdOPayment, member.get());
    }

    private BookingResponseDto populateResponseDto(Vehicle vehicle, Payment payment, Member member) {
        BookingResponseDto bookingResponseDto = new BookingResponseDto();
        bookingResponseDto.setVehicle(vehicle);
        bookingResponseDto.setPayment(payment);
        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setUsername(member.getUserName());
        userResponseDto.setUserId(member.getId());
        userResponseDto.setContactDetails(member.getContactDetails());
        bookingResponseDto.setUserResponseDto(userResponseDto);
        return bookingResponseDto;
    }
}
