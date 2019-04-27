package com.asciiraider.g710.controller;

import com.asciiraider.g710.model.level.Level;
import com.asciiraider.g710.model.level.LevelManager;
import com.asciiraider.g710.view.Event;

public class LevelController {

    private LevelManager levelManager;

    public LevelController(LevelManager levelManager) {

        this.levelManager = levelManager;
    }

    public void handleKeyPress(Event event) {
        switch (event){
            case UP_KEY:
                getCurrentLevel().getPlayer().moveUp();
                break;
            case DOWN_KEY:
                getCurrentLevel().getPlayer().moveDown();
                break;
            case RIGHT_KEY:
                getCurrentLevel().getPlayer().moveRight();
                break;
            case LEFT_KEY:
                getCurrentLevel().getPlayer().moveLeft();
                break;
        }
    }

    public Level getCurrentLevel() {
        return levelManager.getCurrentLevel();
    }

}
