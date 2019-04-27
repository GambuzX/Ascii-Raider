package com.asciiraider.g710;

import com.asciiraider.g710.controller.LevelController;
import com.asciiraider.g710.model.level.LevelManager;
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
            levelView = new LevelView(18, 12, 48);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (levelView == null) return;

        LevelView finalLevelView = levelView;

        /**
         * Draw Cicle
         */
        // TODO: ve se gostas assim sem o LevelManager na view. ainda n sei onde por isto, mas tem de ser numa thread
        Thread draw_t = new Thread() {
            @Override
            public void run(){
                while (true){
                    try {
                        finalLevelView.drawElements(levelManager.getCurrentLevel());
                        Thread.sleep(100);
                    } catch (IOException | InterruptedException e) {
                        e.printStackTrace();
                    }
                    if(isInterrupted()) break;
                }
            }
        };
        draw_t.start();
        Thread input_t = new Thread() {
            @Override
            public void run(){
                while (true){
                    levelController.handleKeyPress(finalLevelView.getKey());
                    if(isInterrupted()) break;
                }
            }
        };
        input_t.start();

        /*
        while(!levelManager.isGameFinished()) {
            try {
                levelView.handleCurrentLevel();
            } catch (IOException e) {
                e.printStackTrace();
            }
            levelManager.nextLevel();
        }
*/
        // You win, GG
    }
}
