package org.example;

public class LifeManager {
    private final CollisionDetector collisionDetector;
    private Position spawnPoint;

    public LifeManager(CollisionDetector collisionDetector, Position initialSpawnPoint) {
        this.collisionDetector = collisionDetector;
        this.spawnPoint = initialSpawnPoint;
    }

    public void loseLife(Robot robot) {
        if (collisionDetector.shouldLoseLife(robot)) {
            robot.setLives(robot.getLives() - 1);
            showLifeLostMessage(robot);
            respawnRobot(robot);
        }
    }

    private void showLifeLostMessage(Robot robot) {
        System.out.println("You lost a life! Remaining lives: " + robot.getLives());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void respawnRobot(Robot robot) {
        robot.setX(spawnPoint.x());
        robot.setY(spawnPoint.y());
    }

    public void updateSpawnPoint(int x, int y) {
        this.spawnPoint = new Position(x, y);
    }

    public boolean isGameOver(Robot robot) {
        return robot.getLives() == 0;
    }
}
