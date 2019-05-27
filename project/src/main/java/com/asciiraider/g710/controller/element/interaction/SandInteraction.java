package com.asciiraider.g710.controller.element.interaction;

import com.asciiraider.g710.controller.level.LevelController;
import com.asciiraider.g710.controller.level.LevelFacade;
import com.asciiraider.g710.model.element.Element;
import com.asciiraider.g710.model.level.LevelModel;
import com.asciiraider.g710.model.utilities.Position;

public class SandInteraction extends Interaction {
	private LevelFacade levelFacade;

	public SandInteraction(Element element, LevelModel levelModel) {
		super(element);
		this.levelFacade = new LevelFacade(levelModel);
	}

	@Override
	public boolean interact(LevelController levelController, Position delimPos) {
		levelFacade.removeSandBlock(element.getPosition());
		return true;
	}
}
