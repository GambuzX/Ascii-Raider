package com.asciiraider.g710.controller;

import com.asciiraider.g710.controller.level.LevelFacade;
import com.asciiraider.g710.model.element.*;
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
		Player player = levelManager.getCurrentLevelFacade().getPlayer();
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
			case EOF:
				levelManager.finishGame();
				return;
			case Q_KEY:
				levelManager.finishGame();
				return;
		}

		if (handlePlayerMovement(newPos, delimPos))
			moveElement(player, newPos);

		if (isPlayerCollidingEnemy()) {
			levelManager.finishGame();
		}

		if(levelFinished())
			levelManager.nextLevel();
	}

	// TODO Initially instead of Element the first parameter was a Movable, but boulders also need to be moved
	// TODO rethink elements hierarchy
	private void moveElement(Element movable, Position newPos) {
		LevelFacade levelFacade = levelManager.getCurrentLevelFacade();

		levelFacade.clearMatrixPosition(movable.getPosition());
		movable.setPosition(newPos);
		levelFacade.updateMatrixPosition(movable);
	}

	private boolean handlePlayerMovement(Position newPos, Position delimPos) {
		LevelFacade levelFacade = levelManager.getCurrentLevelFacade();

		if (newPos == null || !insideBounds(newPos)) return false;
		if (levelFacade.getExitDoor().getPosition().equals(newPos)) return false;
		if (levelFacade.findWall(newPos) != null) return false;
		if (levelFacade.findStoneBlock(newPos) != null) return false;
		if (levelFacade.getDoor() != null && levelFacade.getDoor().getPosition().equals(newPos)) return false;

		Sand sandBlock = levelFacade.findSandBlock(newPos);
		if (sandBlock != null) {
			levelFacade.removeSandBlock(newPos);
			return true;
		}

		LevelKey key = levelFacade.findLevelKey(newPos);
		if (key != null) {
			return handlePlayerPush(key, delimPos);
		}

		Boulder boulder = levelFacade.findBoulder(newPos);
		if (boulder != null) {
			return handlePlayerPush(boulder, delimPos);
		}

		TNT tnt = levelFacade.findTNT(newPos);
		if (tnt != null) {
			return handlePlayerPush(tnt, delimPos);
		}

		DoorKey doorKey = levelFacade.findDoorKey(newPos);
		if (doorKey != null) {
			catchDoorKey();
			return true;
		}

		Enemy enemy = levelFacade.findEnemy(newPos);
		if(enemy != null) {
			levelManager.finishGame();
			return true;
		}

		return true;
	}

	public void catchDoorKey() {
		LevelFacade levelFacade = levelManager.getCurrentLevelFacade();
		levelFacade.removeDoorKey();
		levelFacade.removeDoor();
	}

	// TODO: ver depois o sitio melhor
	public boolean handlePlayerPush(PhysicsElement element, Position delimPos){
		if (element.isFalling()) return false;
		LevelFacade levelFacade = levelManager.getCurrentLevelFacade();
		if (levelFacade.findElement(delimPos) != null) return false;
		moveElement(element, delimPos);
		handlePhysics();
		return true;
	}

	public synchronized void handlePhysics() {
		LevelFacade levelFacade = levelManager.getCurrentLevelFacade();
		for (PhysicsElement physicsElement : levelFacade.getPhysicsElements()) {
			Position below = physicsElement.getPosition().getBelow();
			Element belowEle = levelFacade.findElement(below);
			if (belowEle == null && !physicsElement.isFalling()) {
				physicsElement.setFalling(true);
			}
			else if (belowEle == null) {
				moveElement(physicsElement, below);
			}
			else if (physicsElement instanceof Explosive && physicsElement.isFalling()) {
				handleExplosion(physicsElement.getPosition());
			}
			else if (belowEle instanceof Explosive && physicsElement.isFalling()) {
				handleExplosion(below);
			}
			else if (physicsElement.isFalling()) {
				physicsElement.setFalling(false);
			}
		}
	}

	public void handleKeyProgress(){
		LevelFacade levelFacade = levelManager.getCurrentLevelFacade();
		Position aboveDoor = levelFacade.getExitDoor().getPosition().getAbove();
		levelFacade.removeLevelKey(aboveDoor);
	}

	public void handleExplosion(Position position) {
		LevelFacade levelFacade = levelManager.getCurrentLevelFacade();
		List<Position> inRange = new ArrayList<>();
		for (int i = -1; i <= 1; i++) {
			for (int j = -1; j <= 1; j++) {
				inRange.add(new Position(position.getX() + i, position.getY() + j));
			}
		}
		for (Position pos : inRange) {
			Element caught = levelFacade.findElement(pos);
			if (caught instanceof Player) {
				levelManager.finishGame();
			}
			else if (caught instanceof DestructibleElement) {
				levelFacade.removeDestructibleElement(pos);
			}
		}

	}

	public void moveEnemies() {
		LevelFacade levelFacade = levelManager.getCurrentLevelFacade();
		for (Enemy enemy : levelFacade.getEnemies()) {
			List<Position> adj = levelFacade.getAdjacentEmptyPositions(enemy.getPosition());
			for (Position pos : adj)
				if (!insideBounds(pos))
					adj.remove(pos);

			if (adj.size()==0) return;

			moveElement(enemy, adj.get(new Random().nextInt(adj.size())));
		}
	}

	// TODO: nao pode ser hardcoded
	private boolean insideBounds(Position pos) {
		return pos.getX() >= 0 && pos.getX() < 17 && pos.getY() >= 0 && pos.getY() < 12;
	}

	public boolean isPlayerCollidingEnemy() {
		LevelFacade levelFacade = levelManager.getCurrentLevelFacade();
		for (Enemy enemy : levelFacade.getEnemies())
			if (enemy.getPosition().equals(levelFacade.getPlayer().getPosition()))
				return true;

		return false;
	}

	// TODO: este e certo que n e aqui, vê se pelos comprimentos dos gets
	public boolean levelFinished(){
		LevelFacade levelFacade = levelManager.getCurrentLevelFacade();
		Position aboveDoor = levelFacade.getExitDoor().getPosition().getAbove();
		return levelFacade.getPlayer().getPosition().equals(aboveDoor) && levelFacade.getLevelKeys().size() == 0;
	}

}
