package com.asciiraider.g710.controller.element.interaction;

import com.asciiraider.g710.controller.level.LevelController;
import com.asciiraider.g710.controller.level.LevelFacade;
import com.asciiraider.g710.model.element.DoorKey;
import com.asciiraider.g710.model.utilities.Position;

public class DoorKeyInteraction extends Interaction<DoorKey> {
	private LevelFacade levelFacade;

	public DoorKeyInteraction(DoorKey element, LevelFacade levelFacade) {
		super(element);
		this.levelFacade = levelFacade;
	}

	@Override
	public boolean interact(LevelController levelController, Position delimPos) {
		levelFacade.removeDoorKey();
		levelFacade.removeDoor();
		return true;
	}
}
