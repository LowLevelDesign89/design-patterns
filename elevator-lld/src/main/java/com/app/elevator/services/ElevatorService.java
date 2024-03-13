package com.app.elevator.services;

import com.app.elevator.models.ElevatorCar;
import com.app.elevator.models.enums.ElevatorCarStatus;
import com.app.elevator.models.enums.ElevatorDirection;

import java.util.Collections;
import java.util.PriorityQueue;

public class ElevatorService {
    private ElevatorCar elevatorCar;
    private ElevatorDirection requestedDirection;

    private PriorityQueue<Integer> minQ;
    private PriorityQueue<Integer> maxQ;

    public ElevatorService() {
        this.minQ = new PriorityQueue<>();
        this.maxQ = new PriorityQueue<>(Collections.reverseOrder());
    }

    public ElevatorService(ElevatorCar elevatorCar) {
        this.elevatorCar = elevatorCar;
    }

    public void submitExternalRequest(ElevatorDirection elevatorDirection) {
        requestedDirection = elevatorDirection;
        if(elevatorCar.getElevatorCarStatus() == ElevatorCarStatus.IDLE) {
            elevatorCar.setElevatorCarStatus(ElevatorCarStatus.MOVING);
            elevatorCar.getElevatorDisplay().setDirection(elevatorDirection);
        }
    }

    public void submitInternalRequest(int floor) {
        if(requestedDirection == ElevatorDirection.UP) {
            if(elevatorCar.getElevatorDisplay().getDirection() == ElevatorDirection.UP) {
                minQ.add(floor);
            } else {
                maxQ.add(floor);
            }
        } else {
            if(elevatorCar.getElevatorDisplay().getDirection() == ElevatorDirection.DOWN) {
                maxQ.add(floor);
            } else {
                minQ.add(floor);
            }
        }
    }
}
