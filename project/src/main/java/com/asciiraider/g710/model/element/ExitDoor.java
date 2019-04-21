package com.asciiraider.g710.model.element;

public class ExitDoor extends Element{
    private static final Symbol exitDoorSymbol = new Symbol('U', "#00ff00");

    public ExitDoor(Position position) {
        super(position, exitDoorSymbol);
    }
}
