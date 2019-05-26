package com.asciiraider.g710.controller.level;

import com.asciiraider.g710.controller.ControllerState;
import com.asciiraider.g710.controller.infobar.InfoBarController;
import com.asciiraider.g710.model.element.Player;
import com.asciiraider.g710.model.level.LevelModelGroup;
import com.asciiraider.g710.model.utilities.Position;
import com.asciiraider.g710.view.Event;

public class LevelControllerGroup extends ControllerState {
	private LevelController levelController;
	private InfoBarController infoBarController;
	private LevelModelGroup levelModelGroup;

	public LevelControllerGroup(LevelModelGroup levelModelGroup){
		this.levelModelGroup = levelModelGroup;
		this.levelController = new LevelController(levelModelGroup.getLevelManager());
		this.infoBarController = new InfoBarController(levelController, levelModelGroup.getInfoBarModel());
	}

	public LevelController getLevelController() {
		return levelController;
	}


	public InfoBarController getInfoBarController() {
		return infoBarController;
	}

	@Override
	public void handleKeyPress(Event event) {

		if(event == null)
			return;
		Player player = levelModelGroup.getLevelManager().getCurrentLevelFacade().getPlayer();
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
				levelController.handleLife();
				return;
			case EOF:
			case Q_KEY:
				System.out.println("anjk");
				levelModelGroup.getLevelManager().finishGame();
				return;
		}

		if (levelController.movePlayer(newPos, delimPos, levelModelGroup.getLevelManager().getCurrentLevelFacade()))
			levelModelGroup.getLevelManager().getCurrentLevelFacade().setElementPosition(player, newPos);

		if (levelController.isPlayerCollidingEnemy())
			levelController.handleLife();

		levelController.getLevelProgressionController().handle(levelModelGroup.getLevelManager());
	}
}
