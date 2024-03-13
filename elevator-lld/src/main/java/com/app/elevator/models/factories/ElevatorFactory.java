package com.app.elevator.models.factories;

import com.app.elevator.models.ElevatorCar;
import com.app.elevator.models.InternalButton;
import com.app.elevator.services.ElevatorService;

import java.util.ArrayList;
import java.util.List;

public class ElevatorFactory {
    public static List<ElevatorService> createElevators() {
        List<InternalButton> internalButtons = internalButtons();
        List<ElevatorService> elevatorServiceList = new ArrayList<>();
        ElevatorCar elevatorCar1 = new ElevatorCar(1, internalButtons);

        ElevatorService controller1 = new ElevatorService(elevatorCar1);

        ElevatorCar elevatorCar2 = new ElevatorCar(2, internalButtons);
        ElevatorService controller2 = new ElevatorService(elevatorCar2);

        elevatorServiceList.add(controller1);
        elevatorServiceList.add(controller2);
        return elevatorServiceList;
    }

    public static List<InternalButton> internalButtons() {
        List<InternalButton> internalButtons = new ArrayList<>();
        for(int i = 1; i <= 10; i++) {
            internalButtons.add(new InternalButton(i));
        }
        return internalButtons;
    }
}
