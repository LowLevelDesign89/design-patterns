package com.app.nullobject;

public class Main {
    public static void main(String[] args) {
        Vehicle vehicle = VehicleFactory.getVehicleInstance(AppConstants.BIKE);
        System.out.println("Seating Capacity : " + vehicle.getSeatingCapacity());
        System.out.println("Tank Capacity : " + vehicle.getTankCapacity());
    }
}
