package com.app.game;

import java.util.HashMap;
import java.util.Map;

public class RobotFactory {
    private static Map<String, IRobot> robotFactoryCache = new HashMap<>();

    public static IRobot createRobot(String robotType) {
        if(robotFactoryCache.containsKey(robotType))
            return robotFactoryCache.get(robotType);
        else {
            if(robotType == "HUMANOID") {
                Sprites humanSprite = new Sprites();
                IRobot humanRobot = new HumanoidRobot(robotType, humanSprite);
                robotFactoryCache.put(robotType, humanRobot);
                return humanRobot;
            } else if(robotType == "ROBOTICDOG") {
                Sprites dogSprite = new Sprites();
                IRobot dogRobot = new DogRobot(robotType, dogSprite);
                robotFactoryCache.put(robotType, dogRobot);
                return dogRobot;
            }
        }
        return null;
    }
}
