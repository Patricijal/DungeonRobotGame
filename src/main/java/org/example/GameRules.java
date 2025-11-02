package org.example;

import java.util.List;
import java.util.Objects;

public class GameRules {
    private Map map;
    private Robot robot;
    private List<MovingObstacle> obstacles;

    public GameRules(Map map, Robot robot, List<MovingObstacle> obstacles) {
        this.map = map;
        this.robot = robot;
        this.obstacles = obstacles;
    }

    // command pattern implementation (future)
    public void processInput(int input) {
        if (input == 'a' && !map.isWall(robot.getX(), robot.getY() - 1) && !(map.isLockedDoor(robot.getX(), robot.getY() - 1) && robot.getKeys() == 0)) {
            robot.moveLeft();
        } else if (input == 'd' && !map.isWall(robot.getX(), robot.getY() + 1) && !(map.isLockedDoor(robot.getX(), robot.getY() + 1) && robot.getKeys() == 0)) {
            robot.moveRight();
        } else if (input == 'w' && !map.isWall(robot.getX() - 1, robot.getY()) && !(map.isLockedDoor(robot.getX() - 1, robot.getY()) && robot.getKeys() == 0)) {
            robot.moveUp();
        } else if (input == 's' && !map.isWall(robot.getX() + 1, robot.getY()) && !(map.isLockedDoor(robot.getX() + 1, robot.getY()) && robot.getKeys() == 0)) {
            robot.moveDown();
        }
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
        }
    }

    public void loseLife() {
        if (Objects.equals(map.getModel()[robot.getX()][robot.getY()], "@") || obstacles.stream().anyMatch(obstacle -> obstacle.getX() == robot.getX() && obstacle.getY() == robot.getY())) {
            robot.setLives(robot.getLives() - 1);
            System.out.println("You lost a life! Remaining lives: " + robot.getLives());

            try {
                Thread.sleep(5000); // Pause for 5 second to let the player see the message
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            robot.setX(3);
            robot.setY(3);
        }
    }

    public void checkGameOver() {
        if (robot.getLives() == 0) {
            System.out.println("Game Over!");
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
