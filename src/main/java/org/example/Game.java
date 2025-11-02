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
        while (true) {
            gameRenderer.render();
            gameRules.pickKey();
            gameRules.useKey();
            gameRules.loseLife();
            gameRules.checkGameOver();
            gameRules.gameFinish();

            Integer input = getNonBlockingInput();
            if (input != null) {
                if (input == 'q') {
                    System.out.println("Quitting the game.");
                    break;
                }
                gameRules.processInput(input);
            }

            gameRules.moveObstacles();

            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                break;
            }
            System.out.print("\033[2J\033[1;1H");
        }
    }

    private Integer getNonBlockingInput() throws IOException {
        if (System.in.available() > 0) {
            int read = System.in.read();
            return (read == 10) ? null : read;
        }
        return null;
    }
}
