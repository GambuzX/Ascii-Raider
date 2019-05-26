package com.asciiraider.g710.controller.level;

import com.asciiraider.g710.controller.element.EnemyController;
import com.asciiraider.g710.controller.element.LevelKeyController;
import com.asciiraider.g710.controller.element.PhysicsElementController;
import com.asciiraider.g710.model.element.AnimatedElement;
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

	private ExplosionController explosionsController = new ExplosionController();
	private MovementController movementController = new MovementController(this);

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
		if(explosionsController.handleExplosion(pos, levelManager.getCurrentLevelFacade()))
			handleLife();
	}

	//// -------------------------------------------------------------------------------------------------------- /////

	public void handlePhysics() {
		PhysicsElementController pec;
		for (PhysicsElement physicsElement : levelManager.getCurrentLevelFacade().getPhysicsElements()){
			 pec = new PhysicsElementController(physicsElement);
			 pec.handleElementPhysics(this, levelManager.getCurrentLevelFacade());
		}
	}

	public void moveEnemies() {
		EnemyController ec;
		for (Enemy enemy : levelManager.getCurrentLevelFacade().getEnemies()){
			ec = new EnemyController(enemy);
			ec.handle(levelManager.getCurrentLevelFacade());
		}
	}
	//// -------------------------------------------------------------------------------------------------------- /////

	public boolean handlePlayerPush(PhysicsElement element, Position delimPos) {
		PhysicsElementController pec = new PhysicsElementController(element);
		if(pec.handlePlayerPush(delimPos, levelManager.getCurrentLevelFacade())){
			pec.handleElementPhysics(this, levelManager.getCurrentLevelFacade());
			handleLevelKey();
			return true;
		}
		return false;
	}

	public void handleLevelKey() {
		levelKeyController.handler(levelManager.getCurrentLevelFacade());
	}

	public boolean movePlayer(Position newPos, Position delimPos, LevelFacade levelFacade) {
		return movementController.handlePlayerMovement(newPos, delimPos, levelFacade);
	}

	// TODO: classe à parte talvez no Group Controller??
	public void handleAnimations(){
		for(AnimatedElement animated : levelManager.getCurrentLevelFacade().getAnimatedElements())
			if(!animated.updateAnimation())
				levelManager.getCurrentLevelFacade().removeAnimation(animated.getPosition());
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
