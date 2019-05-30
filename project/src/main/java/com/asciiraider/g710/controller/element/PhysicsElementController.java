package com.asciiraider.g710.controller.element;

import com.asciiraider.g710.controller.level.LevelController;
import com.asciiraider.g710.controller.level.LevelFacade;
import com.asciiraider.g710.model.element.Element;
import com.asciiraider.g710.model.element.Explosive;
import com.asciiraider.g710.model.element.PhysicsElement;
import com.asciiraider.g710.model.utilities.Position;

public class PhysicsElementController {
	private PhysicsElement physicsElement;

	public PhysicsElementController(PhysicsElement physicsElement) {
		this.physicsElement = physicsElement;
	}


	public void handleElementPhysics(LevelController levelController, LevelFacade levelFacade) {
		Position nextPosition = physicsElement.moveDown();
		levelFacade.setElementPosition(physicsElement, nextPosition);


		Element belowEle = levelFacade.findElement(physicsElement.getPosition().getBelow());

		if (belowEle == null ) {
			if(!physicsElement.isFalling())
				physicsElement.setFalling(true);
		}
		// TODO: tirar isto para fora
		else if (physicsElement instanceof Explosive && physicsElement.isFalling()) {
			levelController.triggerExplosion(physicsElement.getPosition());
		}
		else if (belowEle instanceof Explosive && physicsElement.isFalling()) {
			levelController.triggerExplosion(belowEle.getPosition());
		}
		else if (physicsElement.isFalling()) {
			physicsElement.setFalling(false);
			levelController.handleLevelKey();
		}
	}
}
