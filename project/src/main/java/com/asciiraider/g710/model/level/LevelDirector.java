package com.asciiraider.g710.model.level;

public class LevelDirector {

    public void buildLevel(LevelBuilder levelBuilder) {
        levelBuilder.reset();
        levelBuilder.createWalls();
        levelBuilder.createSand();
        levelBuilder.createExitDoor();
        levelBuilder.createStoneBlocks();
        levelBuilder.createStoneBoulders();
        levelBuilder.createTNT();
        levelBuilder.createLevelKeys();
        levelBuilder.createEnemies();
        levelBuilder.createPlayer();
    }
}
