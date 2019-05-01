package com.asciiraider.g710.model.element;

import com.asciiraider.g710.model.utilities.Position;
import com.asciiraider.g710.model.utilities.Symbol;

public abstract class MovableElement extends DestructibleElement{
    public MovableElement(Position position, Symbol symbol) {
        super(position, symbol);
    }

    public Position moveUp() {
        return this.getPosition().getAbove();
    }

    public Position moveDown() {
        return this.getPosition().getBelow();
    }

    public Position moveLeft() {
        return this.getPosition().getLeftSide();
    }

    public Position moveRight() {
        return this.getPosition().getRightSide();
    }

    public void move(Position pos) {
        this.setPosition(pos);
    }
}
