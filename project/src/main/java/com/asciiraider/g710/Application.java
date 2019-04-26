package com.asciiraider.g710;

import com.asciiraider.g710.controller.LevelController;
import com.asciiraider.g710.model.level.*;
import com.asciiraider.g710.view.LevelView;

import java.io.IOException;

public class Application {
    public static void main(String[] args) {
        new Application().run();
    }

    private void run() {
        System.out.println("Hello World");

        LevelManager levelManager = LevelManager.getInstance();

        LevelController levelController = new LevelController(levelManager);
        LevelView levelView = null;
        try {
            levelView = new LevelView(levelController, 18, 12);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (levelView == null) return;

        while(!levelManager.isGameFinished()) {
            try {
                levelView.handleCurrentLevel();
            } catch (IOException e) {
                e.printStackTrace();
            }
            levelManager.nextLevel();
        }

        // You win, GG
    }
}
