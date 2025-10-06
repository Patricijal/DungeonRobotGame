import java.util.List;

public class GameRenderer {
    private Map map;
    private Robot robot;
    private List<MovingObstacle> obstacles;

    private int visionRadius = 100;

    public GameRenderer(Map map, Robot robot, List<MovingObstacle> obstacles) {
        this.map = map;
        this.robot = robot;
        this.obstacles = obstacles;
    }

    public void render() {
        for (int i = 0; i < map.getHeight(); i++) {
            for (int j = 0; j < map.getWidth(); j++) {
                int dx = Math.abs(i - robot.getX());
                int dy = Math.abs(j - robot.getY());

                if (dx <= visionRadius && dy <= visionRadius) {
                    // inside vision
                    if (i == robot.getX() && j == robot.getY()) {
                        System.out.print("R");
                    } else if (isObstacleAt(i, j)) {
                        System.out.print("@");
                    } else {
                        System.out.print(map.model[i][j]);
                    }
                } else {
                    // outside vision (fog)
                    System.out.print("?");
                }
            }
            System.out.println();
        }
    }

    private boolean isObstacleAt(int x, int y) {
        for (MovingObstacle obstacle : obstacles) {
            if (obstacle.getX() == x && obstacle.getY() == y) return true;
        }
        return false;
    }
}
