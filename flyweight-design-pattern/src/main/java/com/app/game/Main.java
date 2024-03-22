package com.app.game;

public class Main {
    public static void main(String[] args) {
        IRobot humanoid1 = RobotFactory.createRobot("HUMANOID");
        humanoid1.display(1,2);

        IRobot humanoid2 = RobotFactory.createRobot("HUMANOID");
        humanoid2.display(10,30);

        IRobot roboticDog1 = RobotFactory.createRobot("ROBOTICDOG");
        roboticDog1.display(34,20);

        IRobot roboticDog2 = RobotFactory.createRobot("ROBOTICDOG");
        roboticDog2.display(23,10);
    }
}
