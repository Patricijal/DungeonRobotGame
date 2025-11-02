package org.example;

import java.util.ArrayList;
import java.util.List;

public class GameBuilder {
    private Map map;
    private Robot robot;
    private final List<MovingObstacle> obstacles = new ArrayList<>();

    public GameBuilder withMap(Map map) {
        this.map = map;
        return this;
    }

    public GameBuilder withRobot(Robot robot) {
        this.robot = robot;
        return this;
    }

    public GameBuilder addObstacle(int x, int y, int directionX, int directionY, int maxSteps) {
        this.obstacles.add(new MovingObstacle(x, y, directionX, directionY, maxSteps));
        return this;
    }

    public GameBuilder addSlowObstacle(int x, int y, int directionX, int directionY, int maxSteps, int moveDelay) {
        this.obstacles.add(new SlowMovingObstacle(x, y, directionX, directionY, maxSteps, moveDelay));
        return this;
    }

    public GameBuilder addDisappearingObstacle(int x, int y, int directionX, int directionY, int maxSteps) {
        this.obstacles.add(new DisappearingMovingObstacle(x, y, directionX, directionY, maxSteps));
        return this;
    }

    public Game build() {
        if (map == null) {
            map = new Map();
        }
        if (robot == null) {
            robot = new Robot(3, 3);
        }
        GameRules gameRules = new GameRules(map, robot, obstacles);
        GameRenderer gameRenderer = new GameRenderer(map, robot, obstacles);
        return new Game(gameRules, gameRenderer);
    }
}
