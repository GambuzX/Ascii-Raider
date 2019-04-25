package com.asciiraider.g710.model.element;

import com.asciiraider.g710.model.utilities.Position;
import com.asciiraider.g710.model.utilities.Symbol;

public abstract class DestructibleElement extends Element {
    public DestructibleElement(Position position, Symbol symbol) {
        super(position, symbol);
    }
}
