package org.example;

public class MovingObstacle {
    private int x;
    private int y;
    private MovementStrategy movementStrategy;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public MovingObstacle(int x, int y, int directionX, int directionY, int maxSteps) {
        this.x = x;
        this.y = y;
        this.movementStrategy = new LinearMovement(directionX, directionY, maxSteps);
    }

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void move() {
        movementStrategy.move(this);
        movementStrategy = movementStrategy.reverse();
    }
}
