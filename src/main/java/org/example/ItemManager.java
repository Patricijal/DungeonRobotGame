package org.example;

import java.util.Objects;

public class ItemManager {
    private final Map map;
    private final LifeManager lifeManager;

    public ItemManager(Map map, LifeManager lifeManager) {
        this.map = map;
        this.lifeManager = lifeManager;
    }

    public void pickKey(Robot robot) {
        if (Objects.equals(map.getModel()[robot.getX()][robot.getY()], "K")) {
            robot.setKeys(robot.getKeys() + 1);
            map.getModel()[robot.getX()][robot.getY()] = " ";
        }
    }

    public void useKey(Robot robot) {
        if (Objects.equals(map.getModel()[robot.getX()][robot.getY()], "X") && robot.getKeys() > 0) {
            robot.setKeys(robot.getKeys() - 1);
            map.getModel()[robot.getX()][robot.getY()] = " ";
            lifeManager.updateSpawnPoint(robot.getX(), robot.getY());
        }
    }
}
