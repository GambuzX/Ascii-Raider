package com.asciiraider.g710.model.element;

public class TNT extends PhysicsElement implements Explosive{
    private static final Symbol tntSymbol = new Symbol('X', "#db0000");

    public TNT(Position position) {
        super(position, tntSymbol);
    }
}
