package org.example;

public class MoveRightCommand implements MovementCommand {
    private final Robot robot;
    private final Map map;

    public MoveRightCommand(Robot robot, Map map) {
        this.robot = robot;
        this.map = map;
    }

    @Override
    public boolean canExecute() {
        int newX = robot.getX();
        int newY = robot.getY() + 1;
        return !map.isWall(newX, newY) &&
                !(map.isLockedDoor(newX, newY) && robot.getKeys() == 0);
    }

    @Override
    public void execute() {
        robot.moveRight();
    }
}
