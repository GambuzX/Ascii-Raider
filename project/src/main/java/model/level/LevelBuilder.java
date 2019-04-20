package model.level;

public interface LevelBuilder {
    void reset();
    void createWalls();
    void createSand();
    void createStoneBlocks();
    void createStoneBoulders();
    void createExitDoor();
    void createLevelKeys();
    void createTNT();
    void createEnemies();
    void createPlayer();
    Level getResult();
}
