import java.io.IOException;

public class Main {
    static Robot robot = new Robot(3, 3);
    static Map map = new Map();

    static GameRules gameRules = new GameRules(map, robot);
    static GameRenderer gameRenderer = new GameRenderer(map, robot);

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
        }
    }

    private static Integer getUserInput() throws IOException {
        int read = System.in.read();
        if (read == 10)
            return null;
        return read;
    }
}