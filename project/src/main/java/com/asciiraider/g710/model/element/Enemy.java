package com.asciiraider.g710.model.element;

import com.asciiraider.g710.GlobalConfigs;
import com.asciiraider.g710.controller.element.MovementStrategy;
import com.asciiraider.g710.model.utilities.Position;
import com.asciiraider.g710.model.utilities.Symbol;

import java.util.List;

public abstract class Enemy extends MovableElement implements Explosive{
    private MovementStrategy movementStrategy;
    private int velocity = GlobalConfigs.ENEMY_VELOCITY;
    private int frameCounter;

    public Enemy(Position position, Symbol symbol) {
        super(position, symbol);
        this.movementStrategy = createMovementStrategy();
        this.frameCounter = 0;
    }

    public List<Position> move(Position targetPosition){
        if(frameCounter < this.velocity){
            frameCounter++;
            return null;
        }
        frameCounter = 0;
        return movementStrategy.move(this.getPosition(), targetPosition);
    }

    protected abstract MovementStrategy createMovementStrategy();
}
