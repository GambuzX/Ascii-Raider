package com.asciiraider.g710.model.level;

import com.asciiraider.g710.model.element.*;
import com.asciiraider.g710.model.utilities.Position;

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

    public Element findElement(Position pos) {

        for (Element element : getElements()) {
            if (element.getPosition().equals(pos)) {
                return element;
            }

        }
        return null;
    }

    public Wall findWall(Position pos) {
        for(Wall wall : walls) {
            if (wall.getPosition().equals(pos)) {
                return wall;
            }
        }
        return null;
    }

    public Boulder findBoulder(Position pos) {
        for(Boulder boulder : boulders) {
            if (boulder.getPosition().equals(pos)) {
                return boulder;
            }
        }
        return null;
    }

    public LevelKey findKey(Position pos) {
        for(LevelKey key : keys) {
            if (key.getPosition().equals(pos)) {
                return key;
            }
        }
        return null;
    }

    public Sand findSandBlock(Position pos) {
        for (Sand sand : sandBlocks) {
            if (sand.getPosition().equals(pos)) {
                return sand;
            }
        }
        return null;
    }

    public void removeSandBlock(Position pos) {
        for (Sand sandBlock : sandBlocks) {
            if (sandBlock.getPosition().equals(pos)){
                sandBlocks.remove(sandBlock);
                break;
            }
        }
    }

    public List<PhysicsElement> getPhysicsElements() {
        List<PhysicsElement> physicsElements = new ArrayList<>();
        physicsElements.addAll(boulders);
        physicsElements.addAll(keys);
        physicsElements.addAll(tnt);
        return physicsElements;
    }
}
