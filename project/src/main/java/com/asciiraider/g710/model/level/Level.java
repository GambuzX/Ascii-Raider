package com.asciiraider.g710.model.level;

import com.asciiraider.g710.model.element.*;

import java.util.ArrayList;
import java.util.List;

public class Level {
    private Player player;
    private ExitDoor exitDoor;
    private List<Wall> walls = new ArrayList<>();
    private List<Boulder> boulders = new ArrayList<>();
    private List<StoneBlock> stoneBlocks = new ArrayList<>();
    private List<Sand> sandBlocks = new ArrayList<>();
    private List<LevelKey> keys = new ArrayList<>();
    private List<TNT> tnt = new ArrayList<>();
    private List<Enemy> enemies = new ArrayList<>();

    public Level() {

    }

    public void reset() {
        player = null;
        exitDoor = null;
        walls.clear();
        boulders.clear();
        stoneBlocks.clear();
        sandBlocks.clear();
        keys.clear();
        tnt.clear();
        enemies.clear();
    }

    public List<Element> getElements() {
        List<Element> elements = new ArrayList<>();
        elements.add(player);
        elements.add(exitDoor);
        elements.addAll(walls);
        elements.addAll(boulders);
        elements.addAll(stoneBlocks);
        elements.addAll(sandBlocks);
        elements.addAll(keys);
        elements.addAll(tnt);
        elements.addAll(enemies);
        return elements;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player p) {
        player = p;
    }

    public ExitDoor getExitDoor() {
        return exitDoor;
    }

    public void setExitDoor(ExitDoor exitDoor) {
        this.exitDoor = exitDoor;
    }

    public List<Wall> getWalls() {
        return walls;
    }

    public void addWall(Wall wall) {
        walls.add(wall);
    }

    public List<Boulder> getBoulders() {
        return boulders;
    }

    public void addBoulder(Boulder boulder) {
        boulders.add(boulder);
    }

    public List<StoneBlock> getStoneBlocks() {
        return stoneBlocks;
    }

    public void addStoneBlock(StoneBlock stoneBlock) {
        stoneBlocks.add(stoneBlock);
    }

    public List<Sand> getSandBlocks() {
        return sandBlocks;
    }

    public void addSandBlock(Sand sand) {
        sandBlocks.add(sand);
    }

    public List<TNT> getTNT() {
        return tnt;
    }

    public void addTNT(TNT tnt) {
        this.tnt.add(tnt);
    }

    public List<LevelKey> getKeys() {
        return keys;
    }

    public void addKey(LevelKey key) {
        keys.add(key);
    }

    public List<Enemy> getEnemies() {
        return enemies;
    }

    public void addEnemy(Enemy enemy) {
        enemies.add(enemy);
    }
}
