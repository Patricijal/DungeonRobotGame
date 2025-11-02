package org.example;

public class MoveUpCommand implements MovementCommand {
    private final Robot robot;
    private final Map map;

    public MoveUpCommand(Robot robot, Map map) {
        this.robot = robot;
        this.map = map;
    }

    @Override
    public boolean canExecute() {
        int newX = robot.getX() - 1;
        int newY = robot.getY();
        return !map.isWall(newX, newY) &&
                !(map.isLockedDoor(newX, newY) && robot.getKeys() == 0);
    }

    @Override
    public void execute() {
        robot.moveUp();
    }
}
