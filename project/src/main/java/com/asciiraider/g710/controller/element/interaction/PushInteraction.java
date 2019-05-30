package com.asciiraider.g710.controller.element.interaction;

import com.asciiraider.g710.controller.element.PhysicsElementController;
import com.asciiraider.g710.controller.level.LevelController;
import com.asciiraider.g710.controller.level.LevelFacade;
import com.asciiraider.g710.model.element.PhysicsElement;
import com.asciiraider.g710.model.level.LevelModel;
import com.asciiraider.g710.model.utilities.Position;

public class PushInteraction extends Interaction<PhysicsElement> {
	private LevelFacade levelFacade;

	public PushInteraction(PhysicsElement element, LevelModel levelModel) {
		super(element);
		this.levelFacade = new LevelFacade(levelModel);
	}

	@Override
	public boolean interact(LevelController levelController, Position delimPos) {
		PhysicsElementController pec = new PhysicsElementController(element);

		if (element.isFalling()) return false;
		if (levelFacade.findElement(delimPos) != null) return false;
		levelFacade.setElementPosition(element, delimPos);

		pec.handleElementPhysics(levelController, levelFacade);
		return true;
	}
}
