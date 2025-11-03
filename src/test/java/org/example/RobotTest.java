package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RobotTest {
    @Test
    void shouldMoveRobotLeft() {
        Robot robot = new Robot(5, 5);
        robot.moveLeft();
        assertEquals(5, robot.getX());
        assertEquals(4, robot.getY());
    }

    @Test
    void shouldMoveRobotRight() {
        Robot robot = new Robot(5, 5);
        robot.moveRight();
        assertEquals(5, robot.getX());
        assertEquals(6, robot.getY());
    }

    @Test
    void shouldMoveRobotUp() {
        Robot robot = new Robot(5, 5);
        robot.moveUp();
        assertEquals(4, robot.getX());
        assertEquals(5, robot.getY());
    }

    @Test
    void shouldMoveRobotDown() {
        Robot robot = new Robot(5, 5);
        robot.moveDown();
        assertEquals(6, robot.getX());
        assertEquals(5, robot.getY());
    }

    @Test
    void shouldDecreaseLives() {
        Robot robot = new Robot(5, 5);
        robot.setLives(3);
        robot.setLives(robot.getLives() - 1);
        assertEquals(2, robot.getLives());
    }

    @Test
    void shouldIncreaseKeys() {
        Robot robot = new Robot(5, 5);
        robot.setKeys(0);
        robot.setKeys(robot.getKeys() + 1);
        assertEquals(1, robot.getKeys());
    }
}