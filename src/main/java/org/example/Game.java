package org.example;

import java.io.IOException;

public class Game {
    private final GameRules gameRules;
    private final GameRenderer gameRenderer;

    public Game(GameRules gameRules, GameRenderer gameRenderer) {
        this.gameRules = gameRules;
        this.gameRenderer = gameRenderer;
    }

    public void start() throws IOException {
        while (isGameRunning()) {
            executeGameLoop();
        }
    }

    private boolean isGameRunning() {
        return true;
    }

    private void executeGameLoop() throws IOException {
        renderGameState();
        processGameLogic();
        handlePlayerInput();
        updateObstacles();
        manageGameTiming();
        clearScreen();
    }

    private void renderGameState() {
        gameRenderer.render();
    }

    private void processGameLogic() {
        gameRules.pickKey();
        gameRules.useKey();
        gameRules.loseLife();
        gameRules.checkGameOver();
    }

    private void handlePlayerInput() throws IOException {
        Integer input = getNonBlockingInput();
        if (input != null) {
            if (isQuitCommand(input)) {
                exitGame();
            } else {
                gameRules.processInput(input);
            }
        }
    }

    private void updateObstacles() {
        gameRules.moveObstacles();
    }

    private void manageGameTiming() {
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void clearScreen() {
        System.out.print("\033[2J\033[1;1H");
    }

    private boolean isQuitCommand(Integer input) {
        return input == 'q';
    }

    private void exitGame() {
        System.out.println("Quitting the game.");
        System.exit(0);
    }

    private Integer getNonBlockingInput() throws IOException {
        if (System.in.available() > 0) {
            int read = System.in.read();
            return (read == 10) ? null : read;
        }
        return null;
    }
}
