package com.app.rental.services;

import com.app.rental.models.dto.SearchRequestDto;
import com.app.rental.models.entity.Vehicle;
import com.app.rental.models.enums.VehicleReservationStatus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SearchService {
    private Map<VehicleReservationStatus, List<Vehicle>> vehcicleInventory;

    public SearchService() {
        vehcicleInventory = new HashMap<>();
        vehcicleInventory.put(VehicleReservationStatus.AVAILABLE, new ArrayList<>());
        vehcicleInventory.put(VehicleReservationStatus.BOOKED, new ArrayList<>());
    }

    public List<Vehicle> retrieveAvailableVehicles(SearchRequestDto searchRequestDto) {
        List<Vehicle> vehicles = vehcicleInventory.getOrDefault(VehicleReservationStatus.AVAILABLE, new ArrayList<>());
        if(vehicles.isEmpty()) {
            throw new RuntimeException("There is no available vehicle, try after sometime");
        }
        return vehicles.stream()
                .filter(vehicle -> searchRequestDto.getVehicleType() != null && vehicle.getVehicleType() == searchRequestDto.getVehicleType())
                .filter(vehicle -> searchRequestDto.getMake() != null && vehicle.getMetadata().getMake().equals(searchRequestDto.getMake()))
                .filter(vehicle -> searchRequestDto.getModel() != null && vehicle.getStore().getId().equals(searchRequestDto.getStoreId()))
                .filter(vehicle -> searchRequestDto.getAddress() != null && vehicle.getStore().equals(searchRequestDto.getAddress()))
                .collect(Collectors.toList());
    }

    public Vehicle removeVehicle(VehicleReservationStatus previousReservationStatus, Vehicle vehicle) {
        vehcicleInventory.get(previousReservationStatus).remove(vehicle);
        return vehicle;
    }

    public Vehicle addVehicle(VehicleReservationStatus vehicleReservationStatus, Vehicle vehicle) {
        if(!vehcicleInventory.get(vehicleReservationStatus).contains(vehicle)) {
            vehcicleInventory.get(vehicleReservationStatus).add(vehicle);
        }
        return vehicle;
    }

    public void changeStatusFromTo(VehicleReservationStatus from, VehicleReservationStatus to, Vehicle vehicle) {
        removeVehicle(from, vehicle);
        addVehicle(to, vehicle);
    }
}
