package com.asciiraider.g710.model.element;

import com.asciiraider.g710.GlobalConfigs;
import com.asciiraider.g710.model.utilities.Position;
import com.asciiraider.g710.model.utilities.Symbol;

public abstract class PhysicsElement extends MovableElement {

    private boolean falling;
    private final int gravity = GlobalConfigs.GRAVITY;
    private int frameCounter;

    public PhysicsElement(Position position, Symbol symbol) {
        super(position, symbol);
        falling = false;
        frameCounter = 0;
    }

    @Override
    public Position moveDown(){
        if(frameCounter < this.gravity){
            frameCounter++;
            return getPosition();
        }
        frameCounter = 0;
       if(isFalling())
           return getPosition().getBelow();
        else
          return getPosition();
    }

    public void setFalling(boolean falling) {
        this.falling = falling;
    }

    public boolean isFalling() {
        return falling;
    }

}
