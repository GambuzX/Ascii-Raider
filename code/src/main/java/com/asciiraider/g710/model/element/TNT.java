package com.asciiraider.g710.model.element;

import com.asciiraider.g710.controller.element.behaviour.Explosive;
import com.asciiraider.g710.model.utilities.HexColorString;
import com.asciiraider.g710.model.utilities.Position;
import com.asciiraider.g710.model.utilities.Symbol;

public class TNT extends PhysicsElement implements Explosive {
    private static final Symbol tntSymbol = new Symbol('X', new HexColorString("db0000"));

    public TNT(Position position) {
        super(position, tntSymbol);
    }
}
