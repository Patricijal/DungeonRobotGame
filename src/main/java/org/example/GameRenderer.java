package org.example;

import java.util.List;

public class GameRenderer {
    private Map map;
    private Robot robot;
    private List<MovingObstacle> obstacles;

    private int visionRadius = 100;

    public GameRenderer(Map map, Robot robot, List<MovingObstacle> obstacles) {
        this.map = map;
        this.robot = robot;
        this.obstacles = obstacles;
    }

    public void render() {
        System.out.print(renderToString());
        System.out.println();
    }

    private String renderToString() {
        StringBuilder screenBuffer = new StringBuilder();
        screenBuffer.append("Lives: ").append(robot.getLives()).append(" ");
        screenBuffer.append("Keys: ").append(robot.getKeys()).append("\n\n");
        for (int i = 0; i < map.getHeight(); i++) {
            for (int j = 0; j < map.getWidth(); j++) {
                int dx = Math.abs(i - robot.getX());
                int dy = Math.abs(j - robot.getY());
                if (dx <= visionRadius && dy <= visionRadius) {
                    if (i == robot.getX() && j == robot.getY()) {
                        screenBuffer.append("R");
                    } else if (isObstacleAt(i, j)) {
                        MovingObstacle obstacle = getObstacleAt(i, j);
                        if (obstacle instanceof DisappearingMovingObstacle) {
                            screenBuffer.append(((DisappearingMovingObstacle) obstacle).getDisplaySymbol());
                        } else {
                            screenBuffer.append("@");
                        }
                    } else {
                        screenBuffer.append(map.getModel()[i][j]);
                    }
                } else {
                    screenBuffer.append("?");
                }
            }
            screenBuffer.append("\n");
        }
        screenBuffer.append("\n[WASD] + [Enter] to move, [Q] to quit.\n");
        return screenBuffer.toString();
    }

    private boolean isObstacleAt(int x, int y) {
        for (MovingObstacle obstacle : obstacles) {
            if (obstacle.getX() == x && obstacle.getY() == y) return true;
        }
        return false;
    }

    private MovingObstacle getObstacleAt(int x, int y) {
        for (MovingObstacle obstacle : obstacles) {
            if (obstacle.getX() == x && obstacle.getY() == y) {
                return obstacle;
            }
        }
        return null;
    }
}
