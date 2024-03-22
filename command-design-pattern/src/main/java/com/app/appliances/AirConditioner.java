package com.app.appliances;

public class AirConditioner {
    private boolean isOn;
    private int temperature;

    public void turnOn() {
        System.out.println("Turning on AC");
        isOn = true;
    }

    public void turnOff() {
        System.out.println("Turning off AC");
        isOn = false;
    }

    public void setTemperature(int temperature) {
        System.out.println("setting temperature to " + temperature);
        this.temperature = temperature;
    }
}
