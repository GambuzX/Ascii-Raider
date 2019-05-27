package com.asciiraider.g710.controller.level;

import com.asciiraider.g710.model.element.DestructibleElement;
import com.asciiraider.g710.model.element.Element;
import com.asciiraider.g710.model.element.Explosive;
import com.asciiraider.g710.model.element.Player;
import com.asciiraider.g710.model.utilities.Position;

import java.util.List;

public class ExplosionController {


    public boolean handleExplosion(Position position, LevelFacade levelFacade) {
        List<Position> inRange = position.getMatrix();
        inRange.add(position);

        for (Position pos : inRange) {
            Element caught = levelFacade.findElement(pos);
            if (caught instanceof Player)
                return true;

            else if (caught == null || caught instanceof DestructibleElement) {
                if(caught != null)
                    levelFacade.removeDestructibleElement(pos);

                levelFacade.addExplosion(pos);

                if (caught instanceof Explosive)
                    if(handleExplosion(pos, levelFacade))
                        return true;
            }
        }
        return  false;
    }
}
