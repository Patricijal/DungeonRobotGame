import java.io.IOException;
import java.util.List;

public class Main {
    static Map map = new Map();
    static Robot robot = new Robot(3, 3);
    static List<MovingObstacle> obstacles = List.of(
            new MovingObstacle(10, 6, 1, 0, 3),
            new MovingObstacle(4, 10, 0, 1, 5)
    );

    static GameRules gameRules = new GameRules(map, robot, obstacles);
    static GameRenderer gameRenderer = new GameRenderer(map, robot, obstacles);

    public static void main(String[] args) throws IOException {
        while (true) {
            gameRenderer.render();
            gameRules.pickKey();
            gameRules.useKey();
            gameRules.loseLife();
            gameRules.checkGameOver();
            gameRules.gameFinish();
            Integer read = getUserInput();
            if (read == null)
                continue;
            gameRules.processInput(read);
            gameRules.moveObstacles();
        }
    }

    private static Integer getUserInput() throws IOException {
        int read = System.in.read();
        if (read == 10)
            return null;
        return read;
    }
}