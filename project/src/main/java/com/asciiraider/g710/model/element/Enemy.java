package com.asciiraider.g710.model.element;

import com.asciiraider.g710.model.utilities.HexColorString;
import com.asciiraider.g710.model.utilities.Position;
import com.asciiraider.g710.model.utilities.Symbol;

public class Enemy extends DestructibleElement implements Movable, Explosive{
    private static final Symbol enemySymbol = new Symbol('Y', new HexColorString("ff0000"));

    public Enemy(Position position) {
        super(position, enemySymbol);
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
