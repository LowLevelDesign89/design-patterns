package com.app.commands;

import com.app.appliances.AirConditioner;

public class TurnOffACCommand implements ICommand {
    private AirConditioner airConditioner;

    public TurnOffACCommand(AirConditioner airConditioner) {
        this.airConditioner = airConditioner;
    }

    @Override
    public void execute() {
        airConditioner.turnOff();
    }
}
