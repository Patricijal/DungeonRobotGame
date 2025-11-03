package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MovingObstacleTest {
    @Test
    void shouldInitializeWithCorrectPosition() {
        MovingObstacle obstacle = new MovingObstacle(5, 10, 1, 0, 3);
        assertEquals(5, obstacle.getX());
        assertEquals(10, obstacle.getY());
    }

    @Test
    void shouldMoveRightWhenDirectionIsPositiveX() {
        MovingObstacle obstacle = new MovingObstacle(0, 0, 1, 0, 3);

        obstacle.move(); // Move 1: (1, 0)
        assertEquals(1, obstacle.getX());
        assertEquals(0, obstacle.getY());

        obstacle.move(); // Move 2: (2, 0)
        assertEquals(2, obstacle.getX());
        assertEquals(0, obstacle.getY());

        obstacle.move(); // Move 3: (3, 0)
        assertEquals(3, obstacle.getX());
        assertEquals(0, obstacle.getY());
    }

    @Test
    void shouldMoveLeftWhenDirectionIsNegativeX() {
        MovingObstacle obstacle = new MovingObstacle(10, 5, -1, 0, 2);

        obstacle.move(); // Move 1: (9, 5)
        assertEquals(9, obstacle.getX());
        assertEquals(5, obstacle.getY());

        obstacle.move(); // Move 2: (8, 5)
        assertEquals(8, obstacle.getX());
        assertEquals(5, obstacle.getY());
    }

    @Test
    void shouldMoveUpWhenDirectionIsNegativeY() {
        MovingObstacle obstacle = new MovingObstacle(0, 0, 0, -1, 2);

        obstacle.move(); // Move 1: (0, -1)
        assertEquals(0, obstacle.getX());
        assertEquals(-1, obstacle.getY());

        obstacle.move(); // Move 2: (0, -2)
        assertEquals(0, obstacle.getX());
        assertEquals(-2, obstacle.getY());
    }

    @Test
    void shouldMoveDownWhenDirectionIsPositiveY() {
        MovingObstacle obstacle = new MovingObstacle(0, 0, 0, 1, 2);

        obstacle.move(); // Move 1: (0, 1)
        assertEquals(0, obstacle.getX());
        assertEquals(1, obstacle.getY());

        obstacle.move(); // Move 2: (0, 2)
        assertEquals(0, obstacle.getX());
        assertEquals(2, obstacle.getY());
    }

    @Test
    void shouldReverseDirectionAfterMaxStepsAndContinuePattern() {
        MovingObstacle obstacle = new MovingObstacle(5, 5, 1, 0, 2);

        // Pattern: right, right, left, left, right, right, etc.
        obstacle.move(); // (6, 5) - step 1
        assertEquals(6, obstacle.getX());

        obstacle.move(); // (7, 5) - step 2 (max reached, reverse)
        assertEquals(7, obstacle.getX());

        obstacle.move(); // (6, 5) - step 1 of reverse
        assertEquals(6, obstacle.getX());

        obstacle.move(); // (5, 5) - step 2 of reverse (max reached, reverse again)
        assertEquals(5, obstacle.getX());

        obstacle.move(); // (6, 5) - back to original direction
        assertEquals(6, obstacle.getX());
    }

}