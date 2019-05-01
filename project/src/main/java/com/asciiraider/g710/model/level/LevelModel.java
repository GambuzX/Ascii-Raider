package com.asciiraider.g710.model.level;

import com.asciiraider.g710.model.Model;
import com.asciiraider.g710.model.element.*;

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
	private List<LevelKey> keys = new ArrayList<>();
	private List<TNT> tnt = new ArrayList<>();
	private List<Enemy> enemies = new ArrayList<>();


	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public ExitDoor getExitDoor() {
		return exitDoor;
	}

	public void setExitDoor(ExitDoor exitDoor) {
		this.exitDoor = exitDoor;
	}

	public Door getDoor() {
		return door;
	}

	public void setDoor(Door door) {
		this.door = door;
	}

	public DoorKey getDoorKey() {
		return doorKey;
	}

	public void setDoorKey(DoorKey doorKey) {
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

	public List<LevelKey> getKeys() {
		return keys;
	}

	public List<Enemy> getEnemies() {
		return enemies;
	}
}
