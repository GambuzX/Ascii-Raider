package com.asciiraider.g710.controller.level;

import com.asciiraider.g710.controller.ControllerState;
import com.asciiraider.g710.controller.infobar.InfoBarController;
import com.asciiraider.g710.model.element.Player;
import com.asciiraider.g710.model.level.LevelModelGroup;
import com.asciiraider.g710.model.utilities.Position;
import com.asciiraider.g710.view.event.Event;

public class LevelControllerGroup extends ControllerState<LevelModelGroup> {
	private LevelController levelController;
	private InfoBarController infoBarController;

	public LevelControllerGroup(LevelModelGroup levelModelGroup){
		super(levelModelGroup);
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
		Player player = model.getLevelManager().getCurrentLevelFacade().getPlayer();
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
				getLevelController().getLifeController().notifyObservers();
				return;
			case EOF:
			case Q_KEY:
				model.getLevelManager().finishGame();
				return;
		}

		if (getLevelController().movePlayer(newPos, delimPos, model.getLevelManager().getCurrentLevelFacade())) {
			model.getLevelManager().getCurrentLevelFacade().setElementPosition(player, newPos);
			getLevelController().handleLevelKey();
		}

		getLevelController().getLevelProgressionController().handler(model.getLevelManager());
	}

	@Override
	public boolean isClose() {
		return model.getLevelManager().isGameFinished();
	}
}
