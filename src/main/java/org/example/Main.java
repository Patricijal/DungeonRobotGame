package org.example;

import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        // Builder Pattern to create the game
        Game game = new GameBuilder()
                .withMap(new Map())
                .withRobot(new Robot(3, 3))
                .addObstacle(13, 10, 0, 1, 8)
                .addObstacle(16, 18, 0, -1, 8)
                .addObstacle(3, 21, 0, 1, 4)
                .addObstacle(5, 25, 0, -1, 4)
                .addObstacle(1, 29, 1, 0, 8)
                .addObstacle(9, 32, -1, 0, 8)
                .addObstacle(1, 35, 1, 0, 8)
                .addObstacle(13, 24, 0, 1, 14)
                .addObstacle(16, 38, 0, -1, 14)
                .addObstacle(11, 29, 1, 0, 8)
                .addObstacle(19, 32, -1, 0, 8)
                .build();
        game.start();
    }
}