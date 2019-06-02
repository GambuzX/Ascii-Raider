package com.asciiraider.g710.controller.element.interaction;

import com.asciiraider.g710.controller.level.LevelController;
import com.asciiraider.g710.controller.level.LevelFacade;
import com.asciiraider.g710.model.element.Sand;
import com.asciiraider.g710.model.utilities.Position;

public class SandInteraction extends Interaction<Sand> {
	private LevelFacade levelFacade;

	public SandInteraction(Sand element, LevelFacade levelFacade) {
		super(element);
		this.levelFacade = levelFacade;
	}

	@Override
	public boolean interact(LevelController levelController, Position delimPos) {
		levelFacade.removeSandBlock(element.getPosition());
		return true;
	}
}
