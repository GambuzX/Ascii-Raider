package com.asciiraider.g710.controller.element.interaction;

import com.asciiraider.g710.controller.level.LevelController;
import com.asciiraider.g710.model.element.Element;
import com.asciiraider.g710.model.utilities.Position;

public class BarrierInteraction extends Interaction {
	public BarrierInteraction(Element element) {
		super(element);
	}

	@Override
	public boolean interact(LevelController levelController, Position delimPos) {
		return false;
	}
}
