package com.app.elevator.controller;

import com.app.elevator.models.factories.ElevatorFactory;
import com.app.elevator.services.ElevatorService;

import java.util.List;

public class ElevatorController {
    private List<ElevatorService> elevatorServiceList;

    public ElevatorController() {
        elevatorServiceList = ElevatorFactory.createElevators();
    }

    public ElevatorController(List<ElevatorService> elevatorServiceList) {
        this.elevatorServiceList = elevatorServiceList;
    }

    public void submitInternalRequest() {

    }

    public void submitExternalRequest() {

    }
}
