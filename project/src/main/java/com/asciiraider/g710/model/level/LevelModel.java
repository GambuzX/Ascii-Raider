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
		this.player = player;
		updateMatrixPosition(player);
	}

	public ExitDoor getExitDoor() {
		return exitDoor;
	}

	public void setExitDoor(ExitDoor exitDoor) {
		this.exitDoor = exitDoor;
		updateMatrixPosition(exitDoor);
	}

	public Door getDoor() {
		return door;
	}

	public void setDoor(Door door) {
		this.door = door;
		updateMatrixPosition(door);
	}

	public DoorKey getDoorKey() {
		return doorKey;
	}

	public void setDoorKey(DoorKey doorKey) {
		this.doorKey = doorKey;
		updateMatrixPosition(doorKey);
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
		this.getWalls().add(wall);
		updateMatrixPosition(wall);
	}

	public void addBoulder(Boulder boulder) {
		this.getBoulders().add(boulder);
		updateMatrixPosition(boulder);
	}

	public void addStoneBlock(StoneBlock stoneBlock) {
		this.getStoneBlocks().add(stoneBlock);
		updateMatrixPosition(stoneBlock);
	}

	public void addSandBlock(Sand sand) {
		this.getSandBlocks().add(sand);
		updateMatrixPosition(sand);
	}

	public void addTNT(TNT tnt) {
		this.getTNT().add(tnt);
		updateMatrixPosition(tnt);
	}

	public void addLevelKey(LevelKey key) {
		this.getLevelKeys().add(key);
		updateMatrixPosition(key);
	}

	public void addEnemy(Enemy enemy) {
		this.getEnemies().add(enemy);
		updateMatrixPosition(enemy);
	}

	public Element[][] getElementsMatrix() {
		return elementsMatrix;
	}

	public void clearMatrixPosition(Position position) {
		elementsMatrix[position.getX()][position.getY()] = null;
	}

	public void updateMatrixPosition(Element ele) {
		if (ele != null)
			elementsMatrix[ele.getPosition().getX()][ele.getPosition().getY()] = ele;
	}

	public Element findElement(Position pos) {
		return elementsMatrix[pos.getX()][pos.getY()];
	}

}
