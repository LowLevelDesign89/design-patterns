package com.app.elevator.models;

import com.app.elevator.models.enums.ElevatorDirection;

public class ElevatorDisplay {
    private ElevatorDirection direction;
    private int currentFloor;

    public void setDisplay(ElevatorDirection direction, int currentFloor) {
        this.direction = direction;
        this.currentFloor = currentFloor;
    }

    public void showDisplay() {
        System.out.println("Direction: " + direction + " <=> Floor: " + currentFloor);
    }

    public ElevatorDirection getDirection() {
        return direction;
    }

    public void setDirection(ElevatorDirection direction) {
        this.direction = direction;
    }
}
