package com.asciiraider.g710.model.element;

import com.asciiraider.g710.model.utilities.HexColorString;
import com.asciiraider.g710.model.utilities.Position;
import com.asciiraider.g710.model.utilities.Symbol;

public class ExitDoor extends Element implements Barrier{
    private static final Symbol exitDoorSymbol = new Symbol('⊍', new HexColorString("3de1ff"));

    public ExitDoor(Position position) {
        super(position, exitDoorSymbol);
    }
}
