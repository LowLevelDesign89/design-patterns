package com.app.rental.models.entity;

import com.app.rental.models.enums.VehicleReservationStatus;
import com.app.rental.models.enums.VehicleStatus;
import com.app.rental.models.enums.VehicleType;
import lombok.Data;

import java.time.ZonedDateTime;

@Data
public class Vehicle extends BaseModel {
    private String vehicleNumber;
    private Store store;
    private ZonedDateTime registrationDate;
    private VehicleMetadata metadata;
    private VehicleStatus vehicleStatus;
    private VehicleType vehicleType;
    private VehicleReservationStatus vehicleReservationStatus;


    @Data
    public static class VehicleMetadata {
        private String color;
        private String make;
        private String model;
        private Integer wheels;
        private Double cc;
    }
}
