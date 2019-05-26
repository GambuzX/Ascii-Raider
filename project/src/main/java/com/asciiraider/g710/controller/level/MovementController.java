package com.asciiraider.g710.controller.level;

import com.asciiraider.g710.model.element.*;
import com.asciiraider.g710.model.utilities.Position;

public class MovementController {

    private LevelController levelController;

    public MovementController(LevelController levelController) {
        this.levelController = levelController;
    }


    public boolean handlePlayerMovement(Position newPos, Position delimPos, LevelFacade levelFacade) {

        if (newPos == null || !levelFacade.insideBounds(newPos)) return false;
        Element element = levelFacade.findElement(newPos);
        if(element instanceof Barrier) return false;

        Sand sandBlock = levelFacade.findSandBlock(newPos);
        if (sandBlock != null) {
            levelFacade.removeSandBlock(newPos);
            return true;
        }

        PhysicsElement physicsElement = levelFacade.findPhysicsElement(newPos);
        if (physicsElement != null) {
            return levelController.handlePlayerPush(physicsElement, delimPos);
        }

        DoorKey doorKey = levelFacade.findDoorKey(newPos);
        if (doorKey != null) {
            levelController.catchDoorKey();
            return true;
        }

        if(null != levelFacade.findEnemy(newPos) || null != levelFacade.findExplosion(newPos)) {
            levelController.handleLife();
            return true;
        }

        return true;
    }
}
