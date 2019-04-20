package model.level;

public class LevelTwoBuilder implements LevelBuilder {

    private Level result = new Level();

    @Override
    public void reset() {
        result.reset();
    }

    @Override
    public void createWalls() {

    }

    @Override
    public void createSand() {

    }

    @Override
    public void createStoneBlocks() {

    }

    @Override
    public void createStoneBoulders() {

    }

    @Override
    public void createExitDoor() {

    }

    @Override
    public void createLevelKeys() {

    }

    @Override
    public void createTNT() {
        return;
    }

    @Override
    public void createEnemies() {
        return;
    }

    @Override
    public void createPlayer() {

    }

    public Level getResult() {
        return result;
    }
}
