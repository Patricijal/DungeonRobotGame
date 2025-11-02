package org.example;

import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;

import java.io.IOException;
import java.util.List;

public class Main {
    static Map map = new Map();
    static Robot robot = new Robot(3, 3);
    static List<MovingObstacle> obstacles = List.of(
            new MovingObstacle(13, 10, 0, 1, 8),
            new MovingObstacle(16, 18, 0, -1, 8),

            new MovingObstacle(3, 21, 0, 1, 4),
            new MovingObstacle(5, 25, 0, -1, 4),

            new MovingObstacle(1, 29, 1, 0, 8),
            new MovingObstacle(9, 32, -1, 0, 8),
            new MovingObstacle(1, 35, 1, 0, 8),

            new MovingObstacle(13, 24, 0, 1, 14),
            new MovingObstacle(16, 38, 0, -1, 14),
            new MovingObstacle(11, 29, 1, 0, 8),
            new MovingObstacle(19, 32, -1, 0, 8)
    );

    static GameRules gameRules = new GameRules(map, robot, obstacles);
    static GameRenderer gameRenderer = new GameRenderer(map, robot, obstacles);

    public static void main(String[] args) throws IOException {
        // need refactoring
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
                Thread.sleep(300); // Adjust the sleep time as needed
            } catch (InterruptedException e) {
                break;
            }
            System.out.print("\033[2J\033[1;1H");
        }
    }

    private static Integer getNonBlockingInput() throws IOException {
        if (System.in.available() > 0) {
            int read = System.in.read();
            return (read == 10) ? null : read;
        }
        return null;
    }
}