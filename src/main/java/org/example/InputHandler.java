package org.example;

public class InputHandler {
    private final Robot robot;
    private final Map map;

    public InputHandler(Robot robot, Map map) {
        this.robot = robot;
        this.map = map;
    }

    public void processInput(int input) {
        MovementCommand command = createCommand(input);
        if (command != null && command.canExecute()) {
            command.execute();
        }
    }

    public MovementCommand createCommand(int input) {
        return switch (input) {
            case 'a' -> new MoveLeftCommand(robot, map);
            case 'd' -> new MoveRightCommand(robot, map);
            case 'w' -> new MoveUpCommand(robot, map);
            case 's' -> new MoveDownCommand(robot, map);
            default -> null;
        };
    }
}
