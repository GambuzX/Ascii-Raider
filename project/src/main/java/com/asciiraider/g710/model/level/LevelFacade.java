package com.asciiraider.g710.model.level;

import com.asciiraider.g710.model.element.*;
import com.asciiraider.g710.model.utilities.Position;

import java.util.ArrayList;
import java.util.List;

public class LevelFacade {
	private LevelModel levelModel;

	public LevelFacade(LevelModel levelModel) {
		this.levelModel = levelModel;
	}

	// TODO: deixar o repetido ??


	public Player getPlayer() {
		return levelModel.getPlayer();
	}

	public void setPlayer(Player player) {
		levelModel.setPlayer(player);
	}

	public ExitDoor getExitDoor() {
		return levelModel.getExitDoor();
	}

	public void setExitDoor(ExitDoor exitDoor) {
		levelModel.setExitDoor(exitDoor);
	}

	public Door getDoor() {
		return levelModel.getDoor();
	}

	public void setDoor(Door door) {
		levelModel.setDoor(door);
	}

	public DoorKey getDoorKey() {
		return levelModel.getDoorKey();
	}

	public void setDoorKey(DoorKey doorKey) {
		levelModel.setDoorKey(doorKey);
	}

	public List<LevelKey> getKeys() {
		return levelModel.getKeys();
	}

	public List<Enemy> getEnemies() {
		return levelModel.getEnemies();
	}

	// Acaba aqui //


	public List<Element> getElements() {
		List<Element> elements = new ArrayList<>();
		elements.add(levelModel.getPlayer());
		elements.add(levelModel.getExitDoor());
		elements.addAll(levelModel.getWalls());
		elements.addAll(levelModel.getBoulders());
		elements.addAll(levelModel.getStoneBlocks());
		elements.addAll(levelModel.getSandBlocks());
		elements.addAll(levelModel.getKeys());
		elements.addAll(levelModel.getTNT());
		elements.addAll(levelModel.getEnemies());
		if(levelModel.getDoor() != null){
			elements.add(levelModel.getDoor());
			elements.add(levelModel.getDoorKey());
		}
		return elements;
	}

	public void addWall(Wall wall) {
		levelModel.getWalls().add(wall);
	}

	public void addBoulder(Boulder boulder) {
		levelModel.getBoulders().add(boulder);
	}

	public void addStoneBlock(StoneBlock stoneBlock) {
		levelModel.getStoneBlocks().add(stoneBlock);
	}

	public void addSandBlock(Sand sand) {
		levelModel.getSandBlocks().add(sand);
	}

	public void addTNT(TNT tnt) {
		levelModel.getTNT().add(tnt);
	}

	public void addKey(LevelKey key) {
		levelModel.getKeys().add(key);
	}

	public void addEnemy(Enemy enemy) {
		levelModel.getEnemies().add(enemy);
	}

	public Element findElement(Position pos) {
		for (Element element : getElements())
			if (element.getPosition().equals(pos))
				return element;
		return null;
	}

	public Wall findWall(Position pos) {
		for(Wall wall : levelModel.getWalls())
			if (wall.getPosition().equals(pos))
				return wall;
		return null;
	}

	public Boulder findBoulder(Position pos) {
		for(Boulder boulder : levelModel.getBoulders())
			if (boulder.getPosition().equals(pos))
				return boulder;
		return null;
	}

	public LevelKey findKey(Position pos) {
		for(LevelKey key : levelModel.getKeys())
			if (key.getPosition().equals(pos))
				return key;
		return null;
	}

	public void removeKey(Position pos) {
		for (LevelKey levelKey : levelModel.getKeys())
			if (levelKey.getPosition().equals(pos)){
				levelModel.getKeys().remove(levelKey);
				break;
			}
	}

	public Sand findSandBlock(Position pos) {
		for (Sand sand : levelModel.getSandBlocks())
			if (sand.getPosition().equals(pos))
				return sand;
		return null;
	}

	public void removeSandBlock(Position pos) {
		for (Sand sandBlock : levelModel.getSandBlocks())
			if (sandBlock.getPosition().equals(pos)){
				levelModel.getSandBlocks().remove(sandBlock);
				break;
			}
	}

	public List<PhysicsElement> getPhysicsElements() {
		List<PhysicsElement> physicsElements = new ArrayList<>();
		physicsElements.addAll(levelModel.getBoulders());
		physicsElements.addAll(levelModel.getKeys());
		physicsElements.addAll(levelModel.getTNT());
		if(levelModel.getDoorKey() != null)
			physicsElements.add(levelModel.getDoorKey());
		return physicsElements;
	}

	public StoneBlock findStoneBlock(Position pos) {
		for (StoneBlock stone : levelModel.getStoneBlocks())
			if (stone.getPosition().equals(pos))
				return stone;
		return null;
	}

	public List<Position> getAdjacentEmptyPositions(Position pos) {
		List<Position> adj = new ArrayList<>();

		if (findElement(pos.getAbove()) == null) adj.add(pos.getAbove());
		if (findElement(pos.getBelow()) == null) adj.add(pos.getBelow());
		if (findElement(pos.getLeftSide()) == null) adj.add(pos.getLeftSide());
		if (findElement(pos.getRightSide()) == null) adj.add(pos.getRightSide());

		return adj;
	}
}
