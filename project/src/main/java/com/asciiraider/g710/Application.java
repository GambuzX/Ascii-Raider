package com.asciiraider.g710;

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
        Level currentLevel = levelManager.nextLevel();

        LevelView view = null;
        try {
            view = new LevelView(currentLevel, 18, 12);
        } catch (IOException e) {
            e.printStackTrace();
        }

        while(true) {
            try {
                view.drawElements();
                Thread.sleep(1);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
