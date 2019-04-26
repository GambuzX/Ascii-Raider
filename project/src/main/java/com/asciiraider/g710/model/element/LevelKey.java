package com.asciiraider.g710.model.element;

import com.asciiraider.g710.model.utilities.HexColorString;
import com.asciiraider.g710.model.utilities.Position;
import com.asciiraider.g710.model.utilities.Symbol;

public class LevelKey extends PhysicsElement{
    private static final Symbol levelKeySymbol = new Symbol('O', new HexColorString("0000ff"));

    public LevelKey(Position position) {
        super(position, levelKeySymbol);
    }
}
