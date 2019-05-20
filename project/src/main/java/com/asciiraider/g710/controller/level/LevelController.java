package com.asciiraider.g710.controller.level;

import com.asciiraider.g710.controller.element.LevelKeyController;
import com.asciiraider.g710.model.element.*;
import com.asciiraider.g710.model.infobar.InfoBarModel;
import com.asciiraider.g710.model.level.LevelManager;
import com.asciiraider.g710.model.utilities.Position;
import com.asciiraider.g710.view.Event;

public class LevelController {
	private LevelManager levelManager;

	// TODO: ver sitio para se por este controller
	private LifeController lifeController = new LifeController();
	private LevelKeyController levelKeyController = new LevelKeyController();
	private PhysicsController physicsController = new PhysicsController(this);
	private ExplosionController explosionsController = new ExplosionController(this);
	private MovementController movementController = new MovementController(this);
	private AnimationController animationController = new AnimationController(this);

	public LevelController(LevelManager levelManager) {
		this.levelManager = levelManager;
		// TODO: depois adicionar-se-a a barra de progresso
		levelKeyController.addObserver(levelManager);
		lifeController.addObserver(levelManager.getLifeManager());
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
			case R_KEY:
				handleLife();
				levelManager.restartLevel();
				return;
			case EOF:
			case Q_KEY:
				levelManager.finishGame();
				return;
		}

		if (movementController.handlePlayerMovement(newPos, delimPos, levelManager.getCurrentLevelFacade()))
			levelManager.getCurrentLevelFacade().setElementPosition(player, newPos);

		if (isPlayerCollidingEnemy())
			handleLife();

		if(levelFinished())
			levelManager.nextLevel();

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

	public void moveEnemies() {
		movementController.moveEnemies(levelManager.getCurrentLevelFacade());
	}

	public void handleAnimations(int fps){
		animationController.handleAnimations(fps, levelManager.getCurrentLevelFacade());
	}

	public boolean insideBounds(Position pos) {
		return pos.getX() < levelManager.getCurrentLevelFacade().getWidth() && pos.getY() < levelManager.getCurrentLevelFacade().getHeight();
	}

	public void handleLife() {
		lifeController.notifyObservers();
		levelManager.restartLevel();
		levelManager.getCurrentLevel().getTimeAlarm().resetTimer();
		levelManager.getCurrentLevel().getTimeAlarm().start();
		if(!levelManager.getLifeManager().hasLifes())
			levelManager.finishGame();
	}

	public int getFps() {
		return levelManager.getFps();
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

	public void updateInfoBarModel(InfoBarModel infoBarModel) {
		LevelFacade levelFacade = levelManager.getCurrentLevelFacade();
		infoBarModel.setCurrentLevel(levelManager.getCurrentLevelIndex()+1);
		infoBarModel.setKeys(levelFacade.getLevelKeys().size());
		infoBarModel.setLives(levelManager.getLifeManager().getCurrentLife());
	}
}
