package com.asciiraider.g710.model.element;

public class Enemy extends DestructibleElement implements Movable, Explosive{
    private static final Symbol enemySymbol = new Symbol('Y', "#ff0000");

    public Enemy(Position position) {
        super(position, enemySymbol);
    }
}
