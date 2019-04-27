package com.asciiraider.g710.controller;

import com.asciiraider.g710.model.element.*;
import com.asciiraider.g710.model.level.Level;
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
				//if (delimPos.getY() > 0) delimPos.setY(delimPos.getY()-1);
				break;
			case DOWN_KEY:
				newPos = player.moveDown();
				delimPos = new Position(newPos);
				delimPos.setY(delimPos.getY()+1);
				break;
			case RIGHT_KEY:
				newPos = player.moveRight();
				delimPos = new Position(newPos);
				delimPos.setX(delimPos.getX()+1);
				break;
			case LEFT_KEY:
				newPos = player.moveLeft();
				delimPos = new Position(newPos);
				if (delimPos.getX() > 0) delimPos.setX(delimPos.getX()-1);
				break;
		}

		if (canMovePlayerTo(newPos, delimPos))
			player.setPosition(newPos);
		if(levelFinished())
			levelManager.nextLevel();
	}

	private boolean canMovePlayerTo(Position newPos, Position delimPos) {
		Level level = getCurrentLevel();

		if (newPos == null || newPos.getX() > 17 || newPos.getY() > 11) return false;
		if (level.getExitDoor().getPosition().equals(newPos)) return false;
		if (level.findWall(newPos) != null) return false;

		LevelKey key = level.findKey(newPos);
		if (key != null) {
			return playerPhysicsElemnt(key, delimPos);
		}

		Boulder boulder = level.findBoulder(newPos);
		if (boulder != null) {
			return playerPhysicsElemnt(boulder, delimPos);
		}

		Sand sandBlock = level.findSandBlock(newPos);
		if (sandBlock != null) {
			level.removeSandBlock(newPos);
			return true;
		}

		return true;
	}

	public Level getCurrentLevel() {
		return levelManager.getCurrentLevel();
	}

	// TODO: ver depois o sitio melhor
	public boolean playerPhysicsElemnt(PhysicsElement element, Position delimPos){
		Level level = getCurrentLevel();
		if (level.findElement(delimPos) != null) return false;
		element.setPosition(delimPos);
		handlePhysics();
		return true;
	}

	public void handlePhysics() {
		Level level = getCurrentLevel();
		for (PhysicsElement physicsElement : level.getPhysicsElements()) {
			Position below = new Position(physicsElement.getPosition().getX(), physicsElement.getPosition().getY()+1);
			if (level.findElement(below) == null) {
				physicsElement.drop();
			}
		}
	}

	public void handleKeyProgress(){
		getCurrentLevel().removeKey();
	}

	// TODO: este e certo que n e aqui, vê se pelos comprimentos dos gets
	public boolean levelFinished(){
		Position aboveDoor = new Position(getCurrentLevel().getExitDoor().getPosition().getX(), getCurrentLevel().getExitDoor().getPosition().getY() - 1);
		return getCurrentLevel().getPlayer().getPosition().equals(aboveDoor) && getCurrentLevel().getKeys().size() == 0;
	}
}