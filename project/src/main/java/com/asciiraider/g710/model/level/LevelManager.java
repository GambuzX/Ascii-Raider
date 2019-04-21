package com.asciiraider.g710.model.level;

import java.util.List;
import java.util.ArrayList;

// TODO: continuar a testar
public class LevelManager {

    private static LevelManager instance;

    private List<Level> levels = new ArrayList<>();
    private int currentLevel;
    private LevelDirector levelDirector;

    public static LevelManager getInstance() {
        if (instance == null) {
            instance = new LevelManager();
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


    private LevelManager() {
        currentLevel = 0;
        levelDirector = new LevelDirector();
        buildAllLevels();
    }

    private void buildAllLevels() {
        buildLevel(new LevelOneBuilder());
        buildLevel(new LevelTwoBuilder());
    }

    private void buildLevel(LevelBuilder levelBuilder) throws IllegalArgumentException{
        if (levelBuilder == null)
            throw new IllegalArgumentException("Tried to use a null levelBuilder");
        levelDirector.buildFullLevel(levelBuilder);
        levels.add(levelBuilder.getResult());
    }
}
