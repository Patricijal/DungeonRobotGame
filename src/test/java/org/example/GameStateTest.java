package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameStateTest {
    private GameState gameState;
    private Robot robot;
    private Map map;
    private CollisionDetector collisionDetector;
    private LifeManager lifeManager;

    @BeforeEach
    void setUp() {
        gameState = new GameState();
        robot = new Robot(5, 5);
        map = new Map();
        collisionDetector = new CollisionDetector(map, java.util.Collections.emptyList());
        lifeManager = new LifeManager(collisionDetector, new Position(3, 3));
    }

    @Test
    void shouldReturnTrueWhenGameOver() {
        robot.setLives(0);
        assertTrue(gameState.shouldExitGame(robot, collisionDetector, lifeManager));
    }

    @Test
    void shouldReturnTrueWhenOnExit() {
        robot.setLives(3);
        robot.setX(20);
        robot.setY(27);
        assertTrue(gameState.shouldExitGame(robot, collisionDetector, lifeManager));
    }

    @Test
    void shouldReturnFalseWhenGameContinues() {
        robot.setLives(3);
        robot.setX(1);
        robot.setY(1);
        assertFalse(gameState.shouldExitGame(robot, collisionDetector, lifeManager));
    }
}