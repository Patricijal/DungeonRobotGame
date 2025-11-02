package org.example;

public interface MovementStrategy {
    void move(MovingObstacle obstacle);
    MovementStrategy reverse();
}
