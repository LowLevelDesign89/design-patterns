package com.app.commands;

import com.app.appliances.AirConditioner;

public class TurnOnACCommand implements ICommand {
    private AirConditioner airConditioner;

    public TurnOnACCommand(AirConditioner airConditioner) {
        this.airConditioner = airConditioner;
    }

    @Override
    public void execute() {
        airConditioner.turnOn();
    }
}
