package com.app.elevator.models;

import com.app.elevator.models.enums.ElevatorCarStatus;
import com.app.elevator.models.enums.ElevatorDirection;
import com.app.elevator.models.enums.ElevatorDoorStatus;

import java.util.ArrayList;
import java.util.List;

public class ElevatorCar {
    private int id;
    private ElevatorDisplay elevatorDisplay;
    private List<InternalButton> internalButtons;
    private ElevatorCarStatus elevatorCarStatus;
    private List<ExternalButton> externalButtons;
    private ElevatorDoor elevatorDoor;
    private int currentFloor;

    public ElevatorCar(int id, List<InternalButton> internalButtons) {
        this.id = id;
        externalButtons = new ArrayList<>();
        externalButtons.add(new ExternalButton(ElevatorDirection.UP));
        externalButtons.add(new ExternalButton(ElevatorDirection.DOWN));
        this.externalButtons = new ArrayList<>();
        this.elevatorCarStatus = ElevatorCarStatus.IDLE;
        this.elevatorDisplay = new ElevatorDisplay();
        this.elevatorDoor = new ElevatorDoor();
        this.elevatorDoor.setStatus(ElevatorDoorStatus.OPEN);
        this.currentFloor = 0;
    }

    public boolean moveElevator(int destinatorFloor, ElevatorDirection direction) {
        if(direction == ElevatorDirection.UP) {
            int startFloor = currentFloor;
            for(int i = startFloor; i <= destinatorFloor; i++) {
                currentFloor = i;
                this.elevatorDisplay.setDisplay(direction, currentFloor);
                this.elevatorDisplay.showDisplay();
                if(i == destinatorFloor) {
                    return true;
                }
            }
        } else {
            int startFloor = currentFloor;
            for(int i = startFloor; i >= destinatorFloor; i--) {
                currentFloor = i;
                this.elevatorDisplay.setDisplay(direction, currentFloor);
                this.elevatorDisplay.showDisplay();
                if(i == destinatorFloor) {
                    return true;
                }
            }
        }
        return false;
    }


    public int getId() {
        return id;
    }

    public ElevatorCarStatus getElevatorCarStatus() {
        return elevatorCarStatus;
    }

    public void setElevatorCarStatus(ElevatorCarStatus elevatorCarStatus) {
        this.elevatorCarStatus = elevatorCarStatus;
    }


    public ElevatorDisplay getElevatorDisplay() {
        return elevatorDisplay;
    }

}
