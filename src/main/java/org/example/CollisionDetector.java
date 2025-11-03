package org.example;

import java.util.List;
import java.util.Objects;

public class CollisionDetector {
    private final Map map;
    private final List<MovingObstacle> obstacles;

    public CollisionDetector(Map map, List<MovingObstacle> obstacles) {
        this.map = map;
        this.obstacles = obstacles;
    }

    public boolean shouldLoseLife(Robot robot) {
        return isOnTrap(robot) || isCollidingWithObstacle(robot);
    }

    private boolean isOnTrap(Robot robot) {
        return Objects.equals(map.getModel()[robot.getX()][robot.getY()], "@");
    }

    private boolean isCollidingWithObstacle(Robot robot) {
        return obstacles.stream()
                .anyMatch(obstacle ->
                        obstacle.getX() == robot.getX() &&
                                obstacle.getY() == robot.getY());
    }

    public boolean isOnExit(Robot robot) {
        return Objects.equals(map.getModel()[robot.getX()][robot.getY()], "E");
    }
}
