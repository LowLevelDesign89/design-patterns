package com.app.elevator.models;

import com.app.elevator.models.enums.ElevatorDirection;

public class ExternalButton {
    private ElevatorDirection direction;

    public ExternalButton(ElevatorDirection direction) {
        this.direction = direction;
    }

    public ElevatorDirection getDirection() {
        return direction;
    }

    public void setDirection(ElevatorDirection direction) {
        this.direction = direction;
    }
}
