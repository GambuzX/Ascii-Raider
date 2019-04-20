package model.level;

import java.util.List;
import java.util.ArrayList;

public class LevelManager {

    private List<Level> levels = new ArrayList<>();
    private int currentLevel;

    private LevelDirector levelDirector;

    public LevelManager() {
        currentLevel = 0;
        levelDirector = new LevelDirector();
        buildAllLevels();
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


    private void buildAllLevels() {
        buildLevel(new LevelOneBuilder());
        buildLevel(new LevelTwoBuilder());
    }

    private void buildLevel(LevelBuilder levelBuilder) {
        if (levelBuilder == null) {
            System.out.println("Tried to use a null levelBuilder");
            return;
        }
        levelDirector.buildFullLevel(levelBuilder);
        levels.add(levelBuilder.getResult());
    }
}
