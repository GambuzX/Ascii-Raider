package com.asciiraider.g710.model.element;

public class Boulder extends PhysicsElement{
    private static final Symbol boulderSymbol = new Symbol('O', "#7f3300");

    public Boulder(Position position) {
        super(position, boulderSymbol);
    }
}
