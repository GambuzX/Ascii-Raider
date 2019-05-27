package com.asciiraider.g710.controller.level;

import com.asciiraider.g710.controller.element.EnemyController;
import com.asciiraider.g710.controller.element.LevelKeyController;
import com.asciiraider.g710.controller.element.PhysicsElementController;
import com.asciiraider.g710.model.element.AnimatedElement;
import com.asciiraider.g710.model.element.Element;
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
		if(explosionsController.handleExplosion(pos, levelManager.getCurrentLevelFacade()))
			lifeController.notifyObservers();
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


	public void handleLevelKey() {
		levelKeyController.handler(levelManager.getCurrentLevelFacade());
	}

	public boolean movePlayer(Position newPos, Position delimPos, LevelFacade levelFacade) {
		if (newPos == null || !levelFacade.insideBounds(newPos)) return false;
		Element element = levelFacade.findElement(newPos);
		if(element == null) return true;

		// TODO: ver porque e que as interactions dao load mal as vezes
		if(element.getInteraction() == null) {
			System.out.println("Interaction error: reloading level");
			levelManager.restartLevel();
			return false;
		}

		return element.getInteraction().interact(this, delimPos);
	}

	// TODO: classe à parte talvez no Group Controller??
	public void handleAnimations(){
		for(AnimatedElement animated : levelManager.getCurrentLevelFacade().getAnimatedElements())
			if(!animated.updateAnimation())
				levelManager.getCurrentLevelFacade().removeAnimation(animated.getPosition());
	}

	public boolean isPlayerCollidingEnemy() {
		LevelFacade levelFacade = levelManager.getCurrentLevelFacade();
		Enemy enemy = levelFacade.findEnemy(levelFacade.getPlayer().getPosition());
		if(enemy == null)
			return false;
		return true;
	}

	public boolean isGameOver(){
		return levelManager.isGameFinished();
	}
}
