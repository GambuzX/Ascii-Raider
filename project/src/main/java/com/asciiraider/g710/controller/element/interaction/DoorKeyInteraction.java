package com.asciiraider.g710.controller.element.interaction;

import com.asciiraider.g710.controller.level.LevelController;
import com.asciiraider.g710.controller.level.LevelFacade;
import com.asciiraider.g710.model.element.DoorKey;
import com.asciiraider.g710.model.level.LevelModel;
import com.asciiraider.g710.model.utilities.Position;

public class DoorKeyInteraction extends Interaction {
	private LevelFacade levelFacade;

	public DoorKeyInteraction(DoorKey element, LevelModel levelModel) {
		super(element);
		this.levelFacade = new LevelFacade(levelModel);
	}

	@Override
	public boolean interact(LevelController levelController, Position delimPos) {
		levelFacade.removeDoorKey();
		levelFacade.removeDoor();
		return true;
	}
}
