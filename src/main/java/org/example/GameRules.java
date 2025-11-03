package org.example;

import java.util.List;

public class GameRules {
//    private final Map map;
    private final Robot robot;
    private final InputHandler inputHandler;
    private final CollisionDetector collisionDetector;
    private final ItemManager itemManager;
    private final LifeManager lifeManager;
    private final GameState gameState;
    private final List<MovingObstacle> obstacles;


    public GameRules(Map map, Robot robot, List<MovingObstacle> obstacles) {
//        this.map = map;
        this.robot = robot;
        this.obstacles = obstacles;
        this.inputHandler = new InputHandler(robot, map);
        this.collisionDetector = new CollisionDetector(map, obstacles);
        this.lifeManager = new LifeManager(collisionDetector, new Position(3,3));
        this.itemManager = new ItemManager(map, lifeManager);
        this.gameState = new GameState();
    }

    public void processInput(int input) {
        inputHandler.processInput(input);
    }

    public void moveObstacles() {
        for (MovingObstacle obstacle : obstacles) {
            obstacle.move();
        }
    }

    public void pickKey() {
        itemManager.pickKey(robot);
    }

    public void useKey() {
        itemManager.useKey(robot);
    }

    public void loseLife() {
        lifeManager.loseLife(robot);
    }

    public void checkGameOver() {
        gameState.checkGameStatus(robot, collisionDetector, lifeManager);
    }
}
