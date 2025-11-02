package org.example;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        // Builder Pattern to create the game
        Game game = new GameBuilder()
                .withMap(new Map())
                .withRobot(new Robot(3, 3))
                .addSlowObstacle(13, 10, 0, 1, 8, 2)
                .addObstacle(16, 18, 0, -1, 8)

                .addSlowObstacle(3, 21, 0, 1, 4,3)
                .addObstacle(5, 25, 0, -1, 4)

                .addObstacle(1, 29, 1, 0, 8)
                .addSlowObstacle(9, 32, -1, 0, 8, 2)
                .addDisappearingObstacle(1, 35, 1, 0, 8)

                .addObstacle(13, 24, 0, 1, 14)
                .addObstacle(16, 38, 0, -1, 14)
                .addDisappearingObstacle(11, 29, 1, 0, 8)
                .addObstacle(19, 32, -1, 0, 8)
                .build();
        game.start();
    }
}