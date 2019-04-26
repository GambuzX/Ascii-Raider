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
    public void moveUp() {
        Position newPos = this.getPosition();
        newPos.setY(newPos.getY()-1);
        this.setPosition(newPos);
    }

    @Override
    public void moveDown() {
        Position newPos = this.getPosition();
        newPos.setY(newPos.getY()+1);
        this.setPosition(newPos);
    }

    @Override
    public void moveLeft() {
        Position newPos = this.getPosition();
        newPos.setX(newPos.getX()-1);
        this.setPosition(newPos);
    }

    @Override
    public void moveRight() {
        Position newPos = this.getPosition();
        newPos.setX(newPos.getX()+1);
        this.setPosition(newPos);
    }
}
