package com.app.rental.models.dto;

import lombok.Data;

import java.time.ZonedDateTime;

@Data
public class VehicleRequestDto {
    private String registrationNumber;
    private ZonedDateTime registrationDate;
    private String make;
    private String model;
    private Integer wheels;
    private Double cc;
    private String color;
    private Long storeId;
}
