package com.asciiraider.g710.controller.level;

import com.asciiraider.g710.model.element.Element;
import com.asciiraider.g710.model.element.Explosive;
import com.asciiraider.g710.model.element.PhysicsElement;
import com.asciiraider.g710.model.level.LevelManager;
import com.asciiraider.g710.model.utilities.Position;

public class PhysicsController {

    private LevelController levelController;

    public PhysicsController(LevelController levelController) {
        this.levelController = levelController;
    }

    public void handlePhysics() {
        LevelFacade levelFacade = levelController.getLevelManager().getCurrentLevelFacade();
        for (PhysicsElement physicsElement : levelFacade.getPhysicsElements()) {
            handleElementPhysics(physicsElement);
        }
    }

    public void handleElementPhysics(PhysicsElement physicsElement) {
        LevelFacade levelFacade = levelController.getLevelManager().getCurrentLevelFacade();
        Position nextPosition = physicsElement.moveDown();
        Element belowEle = levelFacade.findElement(nextPosition);
        if (belowEle == null && !physicsElement.isFalling()) {
            physicsElement.setFalling(true);
        }
        else if (belowEle == null) {
            levelFacade.setElementPosition(physicsElement, nextPosition);
        }
        else if (physicsElement instanceof Explosive && physicsElement.isFalling()) {
            levelController.handleExplosion(physicsElement.getPosition());
        }
        else if (belowEle instanceof Explosive && physicsElement.isFalling()) {
            levelController.handleExplosion(nextPosition);
        }
        else if (physicsElement.isFalling()) {
            physicsElement.setFalling(false);
            levelController.handleLevelKey(levelFacade);
        }
    }

    public boolean handlePlayerPush(PhysicsElement element, Position delimPos){
        LevelManager levelManager = levelController.getLevelManager();

        if (element.isFalling()) return false;

        LevelFacade levelFacade = levelManager.getCurrentLevelFacade();
        if (levelFacade.findElement(delimPos) != null) return false;
        levelFacade.setElementPosition(element, delimPos);
        handleElementPhysics(element);
        levelController.handleLevelKey(levelFacade);
        return true;
    }
}
