package org.example;

public class MovingObstacle {
    private int x;
    private int y;

    private int directionX;
    private int directionY;

    private int stepsTaken = 0;
    private int maxSteps;

    public MovingObstacle(int x, int y, int directionX, int directionY, int maxSteps) {
        this.x = x;
        this.y = y;
        this.directionX = directionX;
        this.directionY = directionY;
        this.maxSteps = maxSteps;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void move() {
        x += directionX;
        y += directionY;
        stepsTaken++;

        if (stepsTaken >= maxSteps) {
            directionX = -directionX;
            directionY = -directionY;
            stepsTaken = 0;
        }
    }
}
