package com.app.elevator.models;

import com.app.elevator.models.enums.ElevatorDoorStatus;

public class ElevatorDoor {
    private ElevatorDoorStatus status;

    public ElevatorDoorStatus getStatus() {
        return status;
    }

    public void setStatus(ElevatorDoorStatus status) {
        this.status = status;
    }
}
