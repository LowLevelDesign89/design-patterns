package com.app;

import com.app.appliances.AirConditioner;
import com.app.commands.TurnOnACCommand;
import com.app.invokers.MyRemoteControl;

public class Client {
    public static void main(String[] args) {
        AirConditioner airConditioner = new AirConditioner();
        TurnOnACCommand turnOnACCommand = new TurnOnACCommand(airConditioner);
        MyRemoteControl myRemoteControl = new MyRemoteControl(turnOnACCommand);

        myRemoteControl.pressButton();
    }
}
