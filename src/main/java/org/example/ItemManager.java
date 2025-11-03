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
        if (isOnKey(robot)) {
            robot.setKeys(robot.getKeys() + 1);
            map.getModel()[robot.getX()][robot.getY()] = " ";
        }
    }

    public void useKey(Robot robot) {
        if (isOnLockedDoor(robot) && hasKeys(robot)) {
            robot.setKeys(robot.getKeys() - 1);
            map.getModel()[robot.getX()][robot.getY()] = " ";
            lifeManager.updateSpawnPoint(robot.getX(), robot.getY());
        }
    }

    private boolean isOnKey(Robot robot) {
        return Objects.equals(map.getModel()[robot.getX()][robot.getY()], "K");
    }

    private boolean isOnLockedDoor(Robot robot) {
        return Objects.equals(map.getModel()[robot.getX()][robot.getY()], "X");
    }

    private boolean hasKeys(Robot robot) {
        return robot.getKeys() > 0;
    }
}
