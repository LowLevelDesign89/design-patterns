package com.app.rental.models.dto;

import com.app.rental.models.entity.Address;
import com.app.rental.models.enums.VehicleType;
import lombok.Data;

@Data
public class SearchRequestDto {
    private VehicleType vehicleType;
    private Long storeId;
    private String make;
    private String model;
    private Address address;
}
