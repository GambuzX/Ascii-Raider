package com.asciiraider.g710.controller;

import com.asciiraider.g710.model.element.*;
import com.asciiraider.g710.model.level.LevelModel;
import com.asciiraider.g710.model.level.LevelManager;
import com.asciiraider.g710.model.utilities.Position;
import com.asciiraider.g710.view.Event;

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
		if(levelFinished())
			levelManager.nextLevel();
	}

	private boolean canMovePlayerTo(Position newPos, Position delimPos) {
		LevelModel levelModel = getCurrentLevel();

		if (newPos == null || newPos.getX() > 17 || newPos.getY() > 11) return false;
		if (levelModel.getExitDoor().getPosition().equals(newPos)) return false;
		if (levelModel.findWall(newPos) != null) return false;

		LevelKey key = levelModel.findKey(newPos);
		if (key != null) {
			return playerPhysicsElemnt(key, delimPos);
		}

		Boulder boulder = levelModel.findBoulder(newPos);
		if (boulder != null) {
			return playerPhysicsElemnt(boulder, delimPos);
		}

		Sand sandBlock = levelModel.findSandBlock(newPos);
		if (sandBlock != null) {
			levelModel.removeSandBlock(newPos);
			return true;
		}

		return true;
	}

	public LevelModel getCurrentLevel() {
		return levelManager.getCurrentLevel();
	}

	// TODO: ver depois o sitio melhor
	public boolean playerPhysicsElemnt(PhysicsElement element, Position delimPos){
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

	// TODO: este e certo que n e aqui, vê se pelos comprimentos dos gets
	public boolean levelFinished(){
		Position aboveDoor = getCurrentLevel().getExitDoor().getPosition().getAbove();
		return getCurrentLevel().getPlayer().getPosition().equals(aboveDoor) && getCurrentLevel().getKeys().size() == 0;
	}
}
