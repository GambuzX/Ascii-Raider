package com.asciiraider.g710.model.element;

public class Sand extends DestructibleElement {
    private static final Symbol sandSymbol = new Symbol(' ', "#b9c600", "#b9c600");

    public Sand(Position position) {
        super(position, sandSymbol);
    }
}
