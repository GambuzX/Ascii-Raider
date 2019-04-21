package com.asciiraider.g710.model.element;

public class LevelKey extends PhysicsElement{
    private static final Symbol levelKeySymbol = new Symbol('O', "#0000ff");

    public LevelKey(Position position) {
        super(position, levelKeySymbol);
    }
}
