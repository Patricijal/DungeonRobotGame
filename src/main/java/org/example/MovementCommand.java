package org.example;

public interface MovementCommand {
    boolean canExecute();
    void execute();
}
