package com.asciiraider.g710.controller.level;

import com.asciiraider.g710.controller.element.EnemyController;
import com.asciiraider.g710.controller.element.LevelKeyController;
import com.asciiraider.g710.controller.element.PhysicsElementController;
import com.asciiraider.g710.model.element.*;
import com.asciiraider.g710.model.level.LevelManager;
import com.asciiraider.g710.model.utilities.Position;

import java.util.List;

public class LevelController {

	private LevelManager levelManager;

	private LifeController lifeController = new LifeController();
	private LevelKeyController levelKeyController = new LevelKeyController();
	private LevelProgressionController levelProgressionController = new LevelProgressionController();

	public LevelController(LevelManager levelManager) {
		this.levelManager = levelManager;

		levelKeyController.addObserver(levelManager);

		lifeController.addObserver(levelManager.getLifeManager());
		lifeController.addObserver(levelManager.getTimeAlarm());
		lifeController.addObserver(levelManager);

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
		LevelFacade levelFacade = levelManager.getCurrentLevelFacade();
		List<Position> inRange = pos.getMatrix();
		inRange.add(pos);

		for (Position position : inRange) {
			Element caught = levelFacade.findElement(position);
			if (caught instanceof Player){
				lifeController.notifyObservers();
				return;
			}

			else if (caught == null || caught instanceof DestructibleElement) {
				if(caught != null)
					levelFacade.removeDestructibleElement(position);

				levelFacade.addExplosion(position);

				if (caught instanceof Explosive)
					triggerExplosion(position);
			}
		}
	}

	//// -------------------------------------------------------------------------------------------------------- /////

	public void handlePhysics() {
		PhysicsElementController pec;
		for (PhysicsElement physicsElement : levelManager.getCurrentLevelFacade().getPhysicsElements()){
			 pec = new PhysicsElementController(physicsElement);
			 pec.handleElementPhysics(this, levelManager.getCurrentLevelFacade());
		}
	}

	public void handleEnemies() {
		EnemyController ec;
		for (Enemy enemy : levelManager.getCurrentLevelFacade().getEnemies()){
			ec = new EnemyController(enemy);
			ec.handle(levelManager.getCurrentLevelFacade());
		}
	}

	public void handleAnimations(){
		for(AnimatedElement animated : levelManager.getCurrentLevelFacade().getAnimatedElements())
			if (!animated.updateAnimation())
				levelManager.getCurrentLevelFacade().removeAnimation(animated);
	}

	//// -------------------------------------------------------------------------------------------------------- /////


	public void handleLevelKey() {
		levelKeyController.handler(levelManager.getCurrentLevelFacade());
	}

	public boolean movePlayer(Position newPos, Position delimPos, LevelFacade levelFacade) {
		if (newPos == null || !levelFacade.insideBounds(newPos)) return false;
		Element element = levelFacade.findElement(newPos);
		if(element == null) return true;

		return element.getPlayerInteraction().interact(this, delimPos);
	}

	public boolean isPlayerCollidingEnemy() {
		LevelFacade levelFacade = levelManager.getCurrentLevelFacade();
		Enemy enemy = levelFacade.findEnemy(levelFacade.getPlayer().getPosition());
		if(enemy == null)
			return false;
		return true;
	}
}
