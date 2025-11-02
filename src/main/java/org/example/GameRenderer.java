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
        renderHeader(screenBuffer);
        renderGameGrid(screenBuffer);
        renderControls(screenBuffer);
        return screenBuffer.toString();
    }

    private void renderHeader(StringBuilder screenBuffer) {
        screenBuffer.append("Lives: ").append(robot.getLives()).append(" ");
        screenBuffer.append("Keys: ").append(robot.getKeys()).append("\n\n");
    }

    private void renderGameGrid(StringBuilder screenBuffer) {
        for (int i = 0; i < map.getHeight(); i++) {
            renderGridRow(screenBuffer, i);
            screenBuffer.append("\n");
        }
    }

    private void renderGridRow(StringBuilder screenBuffer, int row) {
        for (int j = 0; j < map.getWidth(); j++) {
            renderGridCell(screenBuffer, row, j);
        }
    }

    private void renderGridCell(StringBuilder screenBuffer, int x, int y) {
        int dx = Math.abs(x - robot.getX());
        int dy = Math.abs(y - robot.getY());
        if (dx <= visionRadius && dy <= visionRadius) {
            renderVisibleCell(screenBuffer, x, y);
        } else {
            screenBuffer.append("?"); // Fog of war
        }
    }

    private void renderVisibleCell(StringBuilder screenBuffer, int x, int y) {
        if (x == robot.getX() && y == robot.getY()) {
            screenBuffer.append("R");
        } else if (isObstacleAt(x, y)) {
            renderObstacleCell(screenBuffer, x, y);
        } else {
            screenBuffer.append(map.getModel()[x][y]);
        }
    }

    private void renderObstacleCell(StringBuilder screenBuffer, int x, int y) {
        MovingObstacle obstacle = getObstacleAt(x, y);
        if (obstacle instanceof DisappearingMovingObstacle) {
            screenBuffer.append(((DisappearingMovingObstacle) obstacle).getDisplaySymbol());
        } else {
            screenBuffer.append("@");
        }
    }

    private void renderControls(StringBuilder screenBuffer) {
        screenBuffer.append("\n[WASD] + [Enter] to move, [Q] to quit.\n");
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
