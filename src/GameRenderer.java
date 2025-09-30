public class GameRenderer {
    private Map map;
    private Robot robot;

    private int visionRadius = 3;

    public GameRenderer(Map map, Robot robot) {
        this.map = map;
        this.robot = robot;
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
}
