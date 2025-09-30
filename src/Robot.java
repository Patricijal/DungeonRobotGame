public class Robot {
    protected int x;
    protected int y;

    protected int keys = 0;
    protected int lives = 3;

    public Robot(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getKeys() {
        return keys;
    }

    public int getLives() {
        return lives;
    }

    public void moveLeft() {
        y--;
    }

    public void moveRight() {
        y++;
    }

    public void moveUp() {
        x--;
    }

    public void moveDown() {
        x++;
    }
}
