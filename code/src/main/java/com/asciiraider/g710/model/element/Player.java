package com.asciiraider.g710.model.element;

import com.asciiraider.g710.controller.element.behaviour.Explosive;
import com.asciiraider.g710.model.utilities.HexColorString;
import com.asciiraider.g710.model.utilities.Position;
import com.asciiraider.g710.model.utilities.Symbol;

public class Player extends MovableElement implements Explosive {
    private static final Symbol playerSymbol = new Symbol('☻', new HexColorString("ff007f"));

    public Player(Position position) {
        super(position, playerSymbol);
    }
}
