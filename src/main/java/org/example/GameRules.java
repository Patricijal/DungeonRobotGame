package org.example;

import java.util.List;
import java.util.Objects;

public class GameRules {
    private Map map;
    private Robot robot;
    private List<MovingObstacle> obstacles;
    private Position spawnPoint = new Position(3, 3);

    public GameRules(Map map, Robot robot, List<MovingObstacle> obstacles) {
        this.map = map;
        this.robot = robot;
        this.obstacles = obstacles;
    }

    public void processInput(int input) {
        MovementCommand command = createCommand(input);
        if (command != null && command.canExecute()) {
            command.execute();
        }
    }

    private MovementCommand createCommand(int input) {
        return switch (input) {
            case 'a' -> new MoveLeftCommand(robot, map);
            case 'd' -> new MoveRightCommand(robot, map);
            case 'w' -> new MoveUpCommand(robot, map);
            case 's' -> new MoveDownCommand(robot, map);
            default -> null;
        };
    }

    public void moveObstacles() {
        for (MovingObstacle obstacle : obstacles) {
            obstacle.move();
        }
    }

    public void pickKey() {
        if (Objects.equals(map.getModel()[robot.getX()][robot.getY()], "K")) {
            robot.setKeys(robot.getKeys() + 1);
            map.getModel()[robot.getX()][robot.getY()] = " ";
        }
    }

    public void useKey() {
        if (Objects.equals(map.getModel()[robot.getX()][robot.getY()], "X") && robot.getKeys() > 0) {
            robot.setKeys(robot.getKeys() - 1);
            map.getModel()[robot.getX()][robot.getY()] = " ";
            updateSpawnPoint(robot.getX(), robot.getY());
        }
    }

    private void updateSpawnPoint(int x, int y) {
        this.spawnPoint = new Position(x, y);
    }

    public void loseLife() {
        if (shouldLoseLife()) {
            robot.setLives(robot.getLives() - 1);
            showLifeLostMessage();
            respawnRobot();
        }
    }

    private void showLifeLostMessage() {
        System.out.println("You lost a life! Remaining lives: " + robot.getLives());
        try {
            Thread.sleep(5000); // Pause for 5 second to let the player see the message
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void respawnRobot() {
        robot.setX(spawnPoint.x());
        robot.setY(spawnPoint.y());
    }

    private boolean shouldLoseLife() {
        return isOnTrap() || isCollidingWithObstacle();
    }

    private boolean isOnTrap() {
        return Objects.equals(map.getModel()[robot.getX()][robot.getY()], "@");
    }

    private boolean isCollidingWithObstacle() {
        return obstacles.stream()
                .anyMatch(obstacle ->
                        obstacle.getX() == robot.getX() &&
                                obstacle.getY() == robot.getY());
    }

    public void checkGameOver() {
        if (robot.getLives() == 0) {
            System.out.println("Game Over! You lose!");
            System.exit(0);
        }
    }

    public void gameFinish() {
        if (Objects.equals(map.getModel()[robot.getX()][robot.getY()], "E")) {
            System.out.println("You win!");
            System.exit(0);
        }
    }
}
