package com.app.invokers;

import com.app.appliances.AirConditioner;
import com.app.commands.ICommand;

public class MyRemoteControl {
    private ICommand iCommand;

    public MyRemoteControl(ICommand iCommand) {
        this.iCommand = iCommand;
    }
    public void pressButton() {
        iCommand.execute();
    }
}
