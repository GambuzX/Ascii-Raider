package com.asciiraider.g710.controller.level;

import com.asciiraider.g710.model.element.*;
import com.asciiraider.g710.model.level.LevelModel;
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

	public ExitDoor getExitDoor() {
		return levelModel.getExitDoor();
	}

	public Door getDoor() {
		return levelModel.getDoor();
	}

	public DoorKey getDoorKey() {
		return levelModel.getDoorKey();
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

	public List<PhysicsElement> getPhysicsElements() {
		List<PhysicsElement> physicsElements = new ArrayList<>();
		physicsElements.addAll(levelModel.getBoulders());
		physicsElements.addAll(levelModel.getKeys());
		physicsElements.addAll(levelModel.getTNT());
		if(levelModel.getDoorKey() != null)
			physicsElements.add(levelModel.getDoorKey());
		return physicsElements;
	}

	public List<Position> getAdjacentEmptyPositions(Position pos) {
		List<Position> adj = new ArrayList<>();
		Player player = getPlayer();

		Element ele;
		ele = findElement(pos.getAbove());
		if (ele == null || ele.equals(player)) adj.add(pos.getAbove());

		ele = findElement(pos.getBelow());
		if (ele == null || ele.equals(player)) adj.add(pos.getBelow());

		ele = findElement(pos.getLeftSide());
		if (ele == null || ele.equals(player)) adj.add(pos.getLeftSide());

		ele = findElement(pos.getRightSide());
		if (ele == null || ele.equals(player)) adj.add(pos.getRightSide());

		return adj;
	}

	public Element findElement(Position pos) {
		return levelModel.getElementsMatrix()[pos.getX()][pos.getY()];
	}

	public Wall findWall(Position pos) {
		Element element = findElement(pos);
		if(element instanceof Wall)
			return (Wall) element;
		return null;
	}

	public Boulder findBoulder(Position pos) {
		Element element = findElement(pos);
		if(element instanceof Boulder)
			return (Boulder) element;
		return null;
	}

	public LevelKey findKey(Position pos) {
		Element element = findElement(pos);
		if(element instanceof LevelKey)
			return (LevelKey) element;
		return null;
	}

	public Sand findSandBlock(Position pos) {
		Element element = findElement(pos);
		if(element instanceof Sand)
			return (Sand) element;
		return null;
	}

	public StoneBlock findStoneBlock(Position pos) {
		Element element = findElement(pos);
		if(element instanceof StoneBlock)
			return (StoneBlock) element;
		return null;
	}

	public void removeKey(Position pos) {
		Element element = findElement(pos);
		if(element instanceof LevelKey)
			levelModel.getKeys().remove(element);
	}

	public void removeSandBlock(Position pos) {
		Element element = findElement(pos);
		if(element instanceof Sand)
			levelModel.getSandBlocks().remove(element);
	}
}
