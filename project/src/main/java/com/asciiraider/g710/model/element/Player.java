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
        Position newPos = new Position(this.getPosition());
        newPos.setY(newPos.getY()-1);
        return newPos;
    }

    @Override
    public Position moveDown() {
        Position newPos = new Position(this.getPosition());
        newPos.setY(newPos.getY()+1);
        return newPos;
    }

    @Override
    public Position moveLeft() {
        Position newPos = new Position(this.getPosition());
        newPos.setX(newPos.getX()-1);
        return newPos;
    }

    @Override
    public Position moveRight() {
        Position newPos = new Position(this.getPosition());
        newPos.setX(newPos.getX()+1);
        return newPos;
    }
}
