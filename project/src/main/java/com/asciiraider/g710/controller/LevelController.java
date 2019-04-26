package com.asciiraider.g710.controller;

import com.asciiraider.g710.model.level.Level;
import com.asciiraider.g710.model.level.LevelManager;
import com.googlecode.lanterna.input.KeyStroke;

public class LevelController {

    private LevelManager levelManager;

    public LevelController(LevelManager levelManager) {

        this.levelManager = levelManager;
    }

    public void handleKeyPress(KeyStroke key) {
        KeyPressEvent.handle(key, levelManager.getCurrentLevel().getPlayer());
    }

    public Level getCurrentLevel() {
        return levelManager.getCurrentLevel();
    }

}
