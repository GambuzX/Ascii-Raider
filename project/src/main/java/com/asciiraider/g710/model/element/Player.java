package com.asciiraider.g710.model.element;

import com.asciiraider.g710.model.utilities.HexColorString;
import com.asciiraider.g710.model.utilities.Position;
import com.asciiraider.g710.model.utilities.Symbol;

public class Player extends DestructibleElement implements Movable {
    private static final Symbol playerSymbol = new Symbol('☻', new HexColorString("ff00e5"));

    public Player(Position position) {
        super(position, playerSymbol);
    }

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
