package com.asciiraider.g710.controller.element.interaction;

import com.asciiraider.g710.controller.level.LevelController;
import com.asciiraider.g710.model.element.Element;
import com.asciiraider.g710.model.utilities.Position;

public abstract class Interaction<E extends Element> {
	protected E element;

	protected Interaction(E element){
		this.element = element;
	}

	public abstract boolean interact(LevelController levelController, Position delimPos);
}
