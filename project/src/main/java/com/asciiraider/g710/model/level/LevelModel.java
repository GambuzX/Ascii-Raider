package com.asciiraider.g710.model.level;

import com.asciiraider.g710.model.Model;
import com.asciiraider.g710.model.element.*;
import com.asciiraider.g710.model.utilities.Position;

import java.util.ArrayList;
import java.util.List;

public class LevelModel extends Model {
	private Player player;
	private ExitDoor exitDoor;
	private Door door;
	private DoorKey doorKey;
	private List<Wall> walls = new ArrayList<>();
	private List<Boulder> boulders = new ArrayList<>();
	private List<StoneBlock> stoneBlocks = new ArrayList<>();
	private List<Sand> sandBlocks = new ArrayList<>();
	private List<LevelKey> levelKeys = new ArrayList<>();
	private List<TNT> tnt = new ArrayList<>();
	private List<Enemy> enemies = new ArrayList<>();

	// TODO: n pode ser hardcoded
	private Element[][] elementsMatrix = new Element[18][12];


	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.elementsMatrix[player.getPosition().getX()][player.getPosition().getY()] = player;
		this.player = player;
	}

	public ExitDoor getExitDoor() {
		return exitDoor;
	}

	public void setExitDoor(ExitDoor exitDoor) {
		this.elementsMatrix[exitDoor.getPosition().getX()][exitDoor.getPosition().getY()] = exitDoor;
		this.exitDoor = exitDoor;
	}

	public Door getDoor() {
		return door;
	}

	public void setDoor(Door door) {
		this.elementsMatrix[door.getPosition().getX()][door.getPosition().getY()] = door;
		this.door = door;
	}

	public DoorKey getDoorKey() {
		return doorKey;
	}

	public void setDoorKey(DoorKey doorKey) {
		this.elementsMatrix[doorKey.getPosition().getX()][doorKey.getPosition().getY()] = doorKey;
		this.doorKey = doorKey;
	}

	public List<Wall> getWalls() {
		return walls;
	}

	public List<Boulder> getBoulders() {
		return boulders;
	}

	public List<StoneBlock> getStoneBlocks() {
		return stoneBlocks;
	}

	public List<Sand> getSandBlocks() {
		return sandBlocks;
	}

	public List<TNT> getTNT() {
		return tnt;
	}

	public List<LevelKey> getLevelKeys() {
		return levelKeys;
	}

	public List<Enemy> getEnemies() {
		return enemies;
	}

	// TODO: ver se nao ha aqui um factory a ser feito
	public void addWall(Wall wall) {
		this.elementsMatrix[wall.getPosition().getX()][wall.getPosition().getY()] = wall;
		this.getWalls().add(wall);
	}

	public void addBoulder(Boulder boulder) {
		this.elementsMatrix[boulder.getPosition().getX()][boulder.getPosition().getY()] = boulder;
		this.getBoulders().add(boulder);
	}

	public void addStoneBlock(StoneBlock stoneBlock) {
		this.elementsMatrix[stoneBlock.getPosition().getX()][stoneBlock.getPosition().getY()] = stoneBlock;
		this.getStoneBlocks().add(stoneBlock);
	}

	public void addSandBlock(Sand sand) {
		this.elementsMatrix[sand.getPosition().getX()][sand.getPosition().getY()] = sand;
		this.getSandBlocks().add(sand);
	}

	public void addTNT(TNT tnt) {
		this.elementsMatrix[tnt.getPosition().getX()][tnt.getPosition().getY()] = tnt;
		this.getTNT().add(tnt);
	}

	public void addLevelKey(LevelKey key) {
		this.elementsMatrix[key.getPosition().getX()][key.getPosition().getY()] = key;
		this.getLevelKeys().add(key);
	}

	public void addEnemy(Enemy enemy) {
		this.elementsMatrix[enemy.getPosition().getX()][enemy.getPosition().getY()] = enemy;
		this.getEnemies().add(enemy);
	}

	public Element[][] getElementsMatrix() {
		return elementsMatrix;
	}

	public void clearMatrixPosition(Position position) {
		elementsMatrix[position.getX()][position.getY()] = null;
	}

	public void updateMatrixPosition(Element ele) {
		elementsMatrix[ele.getPosition().getX()][ele.getPosition().getY()] = ele;
	}

}
