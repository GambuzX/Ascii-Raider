package com.asciiraider.g710.model.level;

import java.util.List;

// TODO: continuar a testar
public class LevelManager {

    private static LevelManager instance;
    private LevelBuilder lvlBuilder;
    private List<Level> levels;
    private int currentLevel;

    public static LevelManager getInstance() {
        if (instance == null) {
            instance = new LevelManager(2);
        }
        return instance;
    }

    public void resetLevel() {
        currentLevel = 0;
    }

    public Level nextLevel() {
        return levels.get((currentLevel++) % levels.size());
    }

    public int getCurrentLevel() {
        return currentLevel;
    }


    private LevelManager(int numberLevels) {
        currentLevel = 0;
        lvlBuilder = new LevelBuilder(numberLevels);
        levels = lvlBuilder.buildAllLevels();
    }

}
