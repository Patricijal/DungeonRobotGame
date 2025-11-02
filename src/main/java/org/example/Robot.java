package org.example;

public class Robot {
    private int x;
    private int y;

    private int keys = 0;
    private int lives = 3;

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

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setKeys(int keys) {
        this.keys = keys;
    }

    public void setLives(int lives) {
        this.lives = lives;
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
