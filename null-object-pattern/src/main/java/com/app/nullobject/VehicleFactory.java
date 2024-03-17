package com.app.nullobject;

public class VehicleFactory {
    public static Vehicle getVehicleInstance(String type) {
        if(type.equals(AppConstants.CAR)) {
            return new Car();
        }
        return new NullObject();
    }
}
