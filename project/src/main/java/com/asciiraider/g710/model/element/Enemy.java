package com.asciiraider.g710.model.element;

import com.asciiraider.g710.controller.element.MovementStrategy;
import com.asciiraider.g710.model.utilities.Position;
import com.asciiraider.g710.model.utilities.Symbol;

import java.util.List;

public abstract class Enemy extends MovableElement implements Explosive{
    private MovementStrategy movementStrategy;

    public Enemy(Position position, Symbol symbol) {
        super(position, symbol);
        this.movementStrategy = createMovementStrategy();
    }

    @Override
    public List<Position> move(Position targetPosition){
        return movementStrategy.move(this.getPosition(), targetPosition);
    }

    protected abstract MovementStrategy createMovementStrategy();
}
