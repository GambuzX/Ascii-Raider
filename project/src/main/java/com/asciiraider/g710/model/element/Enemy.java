package com.asciiraider.g710.model.element;

import com.asciiraider.g710.model.utilities.HexColorString;
import com.asciiraider.g710.model.utilities.Position;
import com.asciiraider.g710.model.utilities.Symbol;

public class Enemy extends DestructibleElement implements Movable, Explosive{
    private static final Symbol enemySymbol = new Symbol('Y', new HexColorString("ff0000"));

    public Enemy(Position position) {
        super(position, enemySymbol);
    }

    // TODO: esta um pouco repetido com o do player...
    @Override
    public Position moveUp() {
        return this.getPosition().getAbove();
    }

    @Override
    public Position moveDown() {
        return this.getPosition().getBelow();
    }

    @Override
    public Position moveLeft() {
        return this.getPosition().getLeftSide();
    }

    @Override
    public Position moveRight() {
        return this.getPosition().getRightSide();
    }
}
