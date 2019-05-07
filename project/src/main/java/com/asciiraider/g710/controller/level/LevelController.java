package com.asciiraider.g710.controller.level;

import com.asciiraider.g710.controller.element.LevelKeyController;
import com.asciiraider.g710.model.element.*;
import com.asciiraider.g710.model.level.LevelManager;
import com.asciiraider.g710.model.utilities.Position;
import com.asciiraider.g710.view.Event;

public class LevelController {
	private LevelManager levelManager;

	// TODO: ver sitio para se por este controller
	private LevelKeyController levelKeyController = new LevelKeyController();
	private PhysicsController physicsController = new PhysicsController(this);
	private ExplosionController explosionsController = new ExplosionController(this);
	private MovementController movementController = new MovementController(this);
	private AnimationController animationController = new AnimationController(this);

	public LevelController(LevelManager levelManager) {
		this.levelManager = levelManager;
		// TODO: depois adicionar-se-a a barra de progresso
		levelKeyController.addObserver(levelManager);
	}

	public void handleKeyPress(Event event) {

		if(event == null)
			return;
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
			case Q_KEY:
				levelManager.finishGame();
				return;
		}

		if (movementController.handlePlayerMovement(newPos, delimPos))
			levelManager.getCurrentLevelFacade().setElementPosition(player, newPos);

		if (isPlayerCollidingEnemy()) {
			levelManager.finishGame();
		}

		if(levelFinished())
			levelManager.nextLevel();

	}

	public LevelManager getLevelManager() {
		return levelManager;
	}

	public void triggerExplosion(Position pos) {
		explosionsController.handleExplosion(pos);
	}

	public void handlePhysics() {
		physicsController.handlePhysics();
	}

	public boolean handlePlayerPush(PhysicsElement element, Position delimPos) {
		return physicsController.handlePlayerPush(element, delimPos);
	}

	public void handleLevelKey(LevelFacade levelFacade) {
		levelKeyController.handler(levelFacade);
	}

	public void moveEnemies() {
		movementController.moveEnemies();
	}

	public void handleAnimations(int fps){
		animationController.handleAnimations(fps);
	}

	public boolean insideBounds(Position pos) {
		return pos.getX() < levelManager.getCurrentLevelFacade().getWidth() && pos.getY() < levelManager.getCurrentLevelFacade().getHeight();
	}

	public void catchDoorKey() {
		LevelFacade levelFacade = levelManager.getCurrentLevelFacade();
		levelFacade.removeDoorKey();
		levelFacade.removeDoor();
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
		return levelFacade.getPlayer().getPosition().equals(aboveDoor) && levelManager.getCurrentLevelKeys() == 0;
	}

}
