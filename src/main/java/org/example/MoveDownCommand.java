package org.example;

public class MoveDownCommand implements MovementCommand {
    private final Robot robot;
    private final Map map;

    public MoveDownCommand(Robot robot, Map map) {
        this.robot = robot;
        this.map = map;
    }

    @Override
    public boolean canExecute() {
        int newX = robot.getX() + 1;
        int newY = robot.getY();
        return !map.isWall(newX, newY) &&
                !(map.isLockedDoor(newX, newY) && robot.getKeys() == 0);
    }

    @Override
    public void execute() {
        robot.moveDown();
    }
}
