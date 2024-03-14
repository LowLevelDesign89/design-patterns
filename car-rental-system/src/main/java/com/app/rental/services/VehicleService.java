package com.app.rental.services;

import com.app.rental.models.dto.VehicleRequestDto;
import com.app.rental.models.entity.Store;
import com.app.rental.models.entity.Vehicle;
import com.app.rental.models.enums.VehicleStatus;
import com.app.rental.repository.VehicleRepository;

import java.time.ZonedDateTime;

public class VehicleService {
    private VehicleRepository vehicleRepository;

    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public Vehicle addVehicle(VehicleRequestDto vehicleRequestDto) {
        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleNumber(vehicleRequestDto.getRegistrationNumber());
        vehicle.setVehicleStatus(VehicleStatus.ACTIVE);
        vehicle.setRegistrationDate(vehicleRequestDto.getRegistrationDate());
        vehicle.setStore(new Store()); // need to fillup the store from database
        vehicle.setCreatedAt(ZonedDateTime.now());
        vehicle.setLastUpdatedAt(ZonedDateTime.now());
        vehicle.setMetadata(new Vehicle.VehicleMetadata());
        vehicle.getMetadata().setCc(vehicleRequestDto.getCc());
        vehicle.getMetadata().setModel(vehicleRequestDto.getModel());
        vehicle.getMetadata().setColor(vehicleRequestDto.getColor());
        vehicle.getMetadata().setWheels(vehicleRequestDto.getWheels());
        vehicle.getMetadata().setMake(vehicleRequestDto.getMake());
        vehicleRepository.addVehicle(vehicle);
        return vehicle;
    }
}
