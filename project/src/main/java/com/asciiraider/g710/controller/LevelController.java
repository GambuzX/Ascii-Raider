package com.asciiraider.g710.controller;

import com.asciiraider.g710.model.element.*;
import com.asciiraider.g710.model.level.LevelModel;
import com.asciiraider.g710.model.level.LevelManager;
import com.asciiraider.g710.model.utilities.Position;
import com.asciiraider.g710.view.Event;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LevelController {

	private LevelManager levelManager;

	public LevelController(LevelManager levelManager) {
		this.levelManager = levelManager;
	}

	public void handleKeyPress(Event event) {
		Player player = getCurrentLevel().getPlayer();
		Position newPos = null;
		Position delimPos = null;
		switch (event){
			case UP_KEY:
				newPos = player.moveUp();
				delimPos = new Position(newPos);
				break;
			case DOWN_KEY:
				newPos = player.moveDown();
				delimPos = newPos.getBelow();
				break;
			case RIGHT_KEY:
				newPos = player.moveRight();
				delimPos = newPos.getRightSide();
				break;
			case LEFT_KEY:
				newPos = player.moveLeft();
				if (newPos.getX() > 0) delimPos = newPos.getLeftSide();
				else delimPos = newPos;
				break;
		}

		if (canMovePlayerTo(newPos, delimPos))
			player.setPosition(newPos);

		if (isPlayerCollidingEnemy()) {
			levelManager.finishGame();
		}

		if(levelFinished())
			levelManager.nextLevel();
	}

	private boolean canMovePlayerTo(Position newPos, Position delimPos) {
		LevelModel levelModel = getCurrentLevel();

		if (newPos == null || !insideBounds(newPos)) return false;
		if (levelModel.getExitDoor().getPosition().equals(newPos)) return false;
		if (levelModel.findWall(newPos) != null) return false;
		if (levelModel.findStoneBlock(newPos) != null) return false;

		LevelKey key = levelModel.findKey(newPos);
		if (key != null) {
			return playerPhysicsElement(key, delimPos);
		}

		Boulder boulder = levelModel.findBoulder(newPos);
		if (boulder != null) {
			return playerPhysicsElement(boulder, delimPos);
		}

		Sand sandBlock = levelModel.findSandBlock(newPos);
		if (sandBlock != null) {
			levelModel.removeSandBlock(newPos);
			return true;
		}

		return true;
	}

	private LevelModel getCurrentLevel() {
		return levelManager.getCurrentLevel();
	}

	// TODO: ver depois o sitio melhor
	public boolean playerPhysicsElement(PhysicsElement element, Position delimPos){
		LevelModel levelModel = getCurrentLevel();
		if (levelModel.findElement(delimPos) != null) return false;
		element.setPosition(delimPos);
		handlePhysics();
		return true;
	}

	public synchronized void handlePhysics() {
		LevelModel levelModel = getCurrentLevel();
		for (PhysicsElement physicsElement : levelModel.getPhysicsElements()) {
			Position below = physicsElement.getPosition().getBelow();
			if (levelModel.findElement(below) == null) {
				physicsElement.drop();
			}
		}
	}

	public void handleKeyProgress(){
		Position aboveDoor = getCurrentLevel().getExitDoor().getPosition().getAbove();
		getCurrentLevel().removeKey(aboveDoor);
	}

	public void moveEnemies() {
		LevelModel levelModel = getCurrentLevel();
		for (Enemy enemy : levelModel.getEnemies()) {
			List<Position> adj = getAdjacentEmptyPositions(enemy.getPosition());
			for (Position pos : adj) {
				if (!insideBounds(pos)) {
					adj.remove(pos);
				}
			}
			if (adj.size()==0) return;

			enemy.move(adj.get(new Random().nextInt(adj.size())));
		}
	}

	public List<Position> getAdjacentEmptyPositions(Position pos) {
		LevelModel levelModel = getCurrentLevel();
		List<Position> adj = new ArrayList<>();
		Player player = levelModel.getPlayer();

		Element ele;
		ele = levelModel.findElement(pos.getAbove());
		if (ele == null || ele.equals(player)) adj.add(pos.getAbove());

		ele = levelModel.findElement(pos.getBelow());
		if (ele == null || ele.equals(player)) adj.add(pos.getBelow());

		ele = levelModel.findElement(pos.getLeftSide());
		if (ele == null || ele.equals(player)) adj.add(pos.getLeftSide());

		ele = levelModel.findElement(pos.getRightSide());
		if (ele == null || ele.equals(player)) adj.add(pos.getRightSide());

		return adj;
	}

	private boolean insideBounds(Position pos) {
		return pos.getX() >= 0 && pos.getX() < 17 && pos.getY() >= 0 && pos.getY() < 12;
	}

	public boolean isPlayerCollidingEnemy() {
		LevelModel levelModel = getCurrentLevel();
		for (Enemy enemy : levelModel.getEnemies()) {
			if (enemy.getPosition().equals(levelModel.getPlayer().getPosition())) {
				return true;
			}
		}
		return false;
	}

	// TODO: este e certo que n e aqui, vê se pelos comprimentos dos gets
	public boolean levelFinished(){
		Position aboveDoor = getCurrentLevel().getExitDoor().getPosition().getAbove();
		return getCurrentLevel().getPlayer().getPosition().equals(aboveDoor) && getCurrentLevel().getKeys().size() == 0;
	}
}
