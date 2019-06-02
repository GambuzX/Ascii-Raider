package com.asciiraider.g710.model.element;

import com.asciiraider.g710.model.utilities.Position;
import com.asciiraider.g710.model.utilities.Symbol;

public abstract class MovableElement extends DestructibleElement{
    public MovableElement(Position position, Symbol symbol) {
        super(position, symbol);
    }

    public Position moveUp() {
        try{
            return this.getPosition().getAbove();
        }
        catch (IllegalArgumentException e){
            return  this.getPosition();
        }
    }

    public Position moveDown() {
        return this.getPosition().getBelow();
    }

    public Position moveLeft() {
        try{
            return this.getPosition().getLeftSide();
        }
        catch (IllegalArgumentException e){
            return  this.getPosition();
        }
    }

    public Position moveRight() {
        return this.getPosition().getRightSide();
    }

}
