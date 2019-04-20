package com.asciiraider.g710;

import com.asciiraider.g710.model.level.*;

public class Application {
    public static void main(String[] args) {
        System.out.println("Hello World");

        LevelManager levelManager = new LevelManager();
        Level currentLevel = levelManager.nextLevel();

    }
}
