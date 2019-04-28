package com.asciiraider.g710.model.element;

import com.asciiraider.g710.model.utilities.Position;
import com.asciiraider.g710.model.utilities.Symbol;

public abstract class PhysicsElement extends DestructibleElement {
    public PhysicsElement(Position position, Symbol symbol) {
        super(position, symbol);
    }

    public void drop() {
        setPosition(this.getPosition().getBelow());
    }
}
