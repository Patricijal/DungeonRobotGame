import java.util.Objects;

public class GameRules {
    private Map map;
    private Robot robot;

    public GameRules(Map map, Robot robot) {
        this.map = map;
        this.robot = robot;
    }

    public void processInput(int input) {
        if (input == 'a' && !map.isWall(robot.getX(), robot.getY() - 1) && !(map.isLockedDoor(robot.getX(), robot.getY() - 1) && robot.keys == 0)) {
            robot.moveLeft();
        } else if (input == 'd' && !map.isWall(robot.getX(), robot.getY() + 1) && !(map.isLockedDoor(robot.getX(), robot.getY() + 1) && robot.keys == 0)) {
            robot.moveRight();
        } else if (input == 'w' && !map.isWall(robot.getX() - 1, robot.getY()) && !(map.isLockedDoor(robot.getX() - 1, robot.getY()) && robot.keys == 0)) {
            robot.moveUp();
        } else if (input == 's' && !map.isWall(robot.getX() + 1, robot.getY()) && !(map.isLockedDoor(robot.getX() + 1, robot.getY()) && robot.keys == 0)) {
            robot.moveDown();
        }
    }

    public void pickKey() {
        if (Objects.equals(map.model[robot.getX()][robot.getY()], "K")) {
            robot.keys += 1;
            map.model[robot.getX()][robot.getY()] = " ";
        }
    }

    public void useKey() {
        if (Objects.equals(map.model[robot.getX()][robot.getY()], "X") && robot.keys > 0) {
            robot.keys -= 1;
            map.model[robot.getX()][robot.getY()] = " ";
        }
    }

    public void loseLife() {
        if (Objects.equals(map.model[robot.getX()][robot.getY()], "@")) {
            robot.lives -= 1;
            robot.x = 3;
            robot.y = 3;
            System.out.println("You lost a life! Remaining lives: " + robot.lives);
        }
    }

    public void checkGameOver() {
        if (robot.lives == 0) {
            System.out.println("Game Over!");
            System.exit(0);
        }
    }

    public void gameFinish() {
        if (Objects.equals(map.model[robot.getX()][robot.getY()], "E")) {
            System.out.println("You win!");
            System.exit(0);
        }
    }
}
