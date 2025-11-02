package org.example;

public class LinearMovement implements MovementStrategy {
    // Using Strategy Pattern for obstacle movement
    private final int directionX;
    private final int directionY;
    private int stepsTaken;
    private final int maxSteps;

    public LinearMovement(int directionX, int directionY, int maxSteps) {
        this.directionX = directionX;
        this.directionY = directionY;
        this.maxSteps = maxSteps;
        this.stepsTaken = 0;
    }

    public LinearMovement(int directionX, int directionY, int maxSteps, int stepsTaken) {
        this.directionX = directionX;
        this.directionY = directionY;
        this.maxSteps = maxSteps;
        this.stepsTaken = stepsTaken;
    }

    @Override
    public void move(MovingObstacle obstacle) {
        obstacle.setPosition(
                obstacle.getX() + directionX,
                obstacle.getY() + directionY
        );
        stepsTaken++;
    }

    @Override
    public MovementStrategy reverse() {
        if (stepsTaken >= maxSteps) {
            return new LinearMovement(-directionX, -directionY, maxSteps, 0);
        }
        return this;
    }
}
