package com.asciiraider.g710.model.element;

import com.asciiraider.g710.model.utilities.HexColorString;
import com.asciiraider.g710.model.utilities.Position;
import com.asciiraider.g710.model.utilities.Symbol;

public class ExitDoor extends Element{
    private static final Symbol exitDoorSymbol = new Symbol('U', new HexColorString("00ff00"));

    public ExitDoor(Position position) {
        super(position, exitDoorSymbol);
    }
}
