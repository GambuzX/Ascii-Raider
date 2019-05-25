package com.asciiraider.g710.controller.level;

import com.asciiraider.g710.controller.element.LevelKeyController;
import com.asciiraider.g710.model.element.Enemy;
import com.asciiraider.g710.model.element.PhysicsElement;
import com.asciiraider.g710.model.level.LevelManager;
import com.asciiraider.g710.model.utilities.Position;

public class LevelController {

	private LevelManager levelManager;

	// TODO: ver sitio para se por este controller
	private LifeController lifeController = new LifeController();
	private LevelKeyController levelKeyController = new LevelKeyController();
	private LevelProgressionController levelProgressionController = new LevelProgressionController();
	private PhysicsController physicsController = new PhysicsController(this);
	private ExplosionController explosionsController = new ExplosionController(this);
	private MovementController movementController = new MovementController(this);
	private AnimationController animationController = new AnimationController(this);

	public LevelController(LevelManager levelManager) {
		this.levelManager = levelManager;
		levelKeyController.addObserver(levelManager);

		lifeController.addObserver(levelManager.getLifeManager());
		lifeController.addObserver(levelManager.getTimeAlarm());

		levelProgressionController.addObserver(levelManager.getTimeAlarm());
	}

	public LifeController getLifeController(){
		return  this.lifeController;
	}

	public LevelKeyController getLevelKeyController(){
		return this.levelKeyController;
	}

	public LevelProgressionController getLevelProgressionController(){
		return  this.levelProgressionController;
	}

	public void triggerExplosion(Position pos) {
		explosionsController.handleExplosion(pos, levelManager.getCurrentLevelFacade());
	}

	public void handlePhysics() {
		physicsController.handlePhysics(levelManager.getCurrentLevelFacade());
	}

	public boolean handlePlayerPush(PhysicsElement element, Position delimPos) {
		return physicsController.handlePlayerPush(element, delimPos, levelManager.getCurrentLevelFacade());
	}

	public void handleLevelKey() {
		levelKeyController.handler(levelManager.getCurrentLevelFacade());
	}

	public boolean movePlayer(Position newPos, Position delimPos, LevelFacade levelFacade) {
		return movementController.handlePlayerMovement(newPos, delimPos, levelFacade);
	}

	public void moveEnemies() {
		movementController.moveEnemies(levelManager.getCurrentLevelFacade());
	}

	public void handleAnimations(){
		animationController.handleAnimations(levelManager.getCurrentLevelFacade());
	}

	public boolean insideBounds(Position pos) {
		return pos.getX() < levelManager.getCurrentLevelFacade().getWidth() && pos.getY() < levelManager.getCurrentLevelFacade().getHeight();
	}

	public void handleLife() {
		lifeController.notifyObservers();
		levelManager.restartLevel();
		if(!levelManager.getLifeManager().hasLifes())
			levelManager.finishGame();
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
}
