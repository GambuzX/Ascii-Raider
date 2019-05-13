package com.asciiraider.g710.controller.level;

import com.asciiraider.g710.model.element.DestructibleElement;
import com.asciiraider.g710.model.element.Element;
import com.asciiraider.g710.model.element.Explosive;
import com.asciiraider.g710.model.element.Player;
import com.asciiraider.g710.model.utilities.Position;

import java.util.ArrayList;
import java.util.List;

public class ExplosionController {

    private LevelController levelController;

    public ExplosionController(LevelController levelController) {
        this.levelController = levelController;
    }

    public void handleExplosion(Position position, LevelFacade levelFacade) {
        List<Position> inRange = new ArrayList<>();
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                inRange.add(new Position(position.getX() + i, position.getY() + j));
            }
        }
        for (Position pos : inRange) {
            Element caught = levelFacade.findElement(pos);
            if (caught instanceof Player)
                levelController.handleLife();

            else if (caught == null || caught instanceof DestructibleElement) {
                if(caught != null)
                    levelFacade.removeDestructibleElement(pos);

                levelFacade.addExplosion(pos, levelController.getFps());

                if (caught instanceof Explosive)
                    handleExplosion(pos, levelFacade);
            }
        }

    }
}
