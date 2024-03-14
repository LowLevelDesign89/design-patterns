package com.app.rental.controller;

import com.app.rental.models.dto.VehicleRequestDto;
import com.app.rental.models.entity.Vehicle;
import com.app.rental.services.VehicleService;

public class VehicleController {
    private VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    public Vehicle addVehicle(VehicleRequestDto vehicleRequestDto) {
        return this.vehicleService.addVehicle(vehicleRequestDto);
    }
}
