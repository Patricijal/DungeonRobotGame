package org.example;

public class GameState {
    public void checkGameStatus(Robot robot, CollisionDetector collisionDetector, LifeManager lifeManager) {
        if (lifeManager.isGameOver(robot)) {
            endGame("Game Over! You lose!");
        } else if (collisionDetector.isOnExit(robot)) {
            endGame("You win!");
        }
    }

    private void endGame(String message) {
        System.out.println(message);
        System.exit(0);
    }
}
