package com.asciiraider.g710.model.element;

public class Player extends DestructibleElement implements Movable {
    private static final Symbol playerSymbol = new Symbol('P', "#ff00e5");

    public Player(Position position) {
        super(position, playerSymbol);
    }
}
