package com.asciiraider.g710.model.element;

import com.asciiraider.g710.model.utilities.Position;
import com.asciiraider.g710.model.utilities.Symbol;

public abstract class PhysicsElement extends DestructibleElement {

    private boolean falling;

    public PhysicsElement(Position position, Symbol symbol) {
        super(position, symbol);
        falling = false;
    }

    public void setFalling(boolean falling) {
        this.falling = falling;
    }

    public boolean isFalling() {
        return falling;
    }


}
