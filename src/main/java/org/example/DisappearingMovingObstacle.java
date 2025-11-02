package org.example;

public class DisappearingMovingObstacle extends MovingObstacle {
    private int stepCounter = 0;
    private boolean isVisible = true;

    public DisappearingMovingObstacle(int x, int y, int directionX, int directionY, int maxSteps) {
        super(x, y, directionX, directionY, maxSteps);
    }

    @Override
    public void move() {
        super.move();
        stepCounter++;
        if (stepCounter % 2 == 0) {
            isVisible = !isVisible;
        }
    }

    public String getDisplaySymbol() {
        return isVisible ? "@" : " ";
    }
}
