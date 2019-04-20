package model.level;

public class LevelDirector {

    public void buildFullLevel(LevelBuilder levelBuilder) {
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
