package com.app.rental.repository;

import com.app.rental.models.entity.Vehicle;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

public class VehicleRepository {
    private Map<Long, Vehicle> vehicles = new HashMap<>();
    private AtomicLong vehicleId = new AtomicLong(1l);

    public Vehicle save(Vehicle vehicle) {
        if(vehicle.getId() == null) {
            vehicle.setId(vehicleId.get());
            vehicleId.incrementAndGet();
        }

        vehicles.put(vehicle.getId(), vehicle);

        return vehicle;
    }

    public Optional<Vehicle> findById(Long vehicleId) {
        Vehicle vehicle = vehicles.getOrDefault(vehicleId, null);
        return (vehicle == null) ? Optional.empty(): Optional.of(vehicle);
    }
}
