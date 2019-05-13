package com.asciiraider.g710.controller.level;

import com.asciiraider.g710.model.element.DoorKey;
import com.asciiraider.g710.model.element.Enemy;
import com.asciiraider.g710.model.element.PhysicsElement;
import com.asciiraider.g710.model.element.Sand;
import com.asciiraider.g710.model.utilities.Position;

import java.util.List;

public class MovementController {

    private LevelController levelController;

    public MovementController(LevelController levelController) {
        this.levelController = levelController;
    }

    public void moveEnemies(LevelFacade levelFacade) {
        for (Enemy enemy : levelFacade.getEnemies()) {
            List<Position> adj = enemy.move(levelFacade.getPlayer().getPosition());
            for (Position pos : adj)
                if (levelController.insideBounds(pos) && levelFacade.isEmptyPosition(pos)) {
                    levelFacade.setElementPosition(enemy, pos);
                    break;
                }
        }
    }

    public boolean handlePlayerMovement(Position newPos, Position delimPos, LevelFacade levelFacade) {

        if (newPos == null || !levelController.insideBounds(newPos)) return false;
        if (levelFacade.getExitDoor().getPosition().equals(newPos)) return false;
        if (levelFacade.findWall(newPos) != null) return false;
        if (levelFacade.findStoneBlock(newPos) != null) return false;
        if (levelFacade.getDoor() != null && levelFacade.getDoor().getPosition().equals(newPos)) return false;

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
