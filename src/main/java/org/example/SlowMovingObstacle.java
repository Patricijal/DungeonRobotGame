package org.example;

public class SlowMovingObstacle extends MovingObstacle {
    private int moveCounter = 0;
    private final int moveEveryNTicks;

    public SlowMovingObstacle(int x, int y, int directionX, int directionY, int maxSteps, int moveEveryNTicks) {
        super(x, y, directionX, directionY, maxSteps);
        this.moveEveryNTicks = moveEveryNTicks;
    }

    @Override
    public void move() {
        moveCounter++;
        if (moveCounter >= moveEveryNTicks) {
            super.move();
            moveCounter = 0;
        }
    }
}
