package com.asciiraider.g710.model.element;

import com.asciiraider.g710.model.utilities.HexColorString;
import com.asciiraider.g710.model.utilities.Position;
import com.asciiraider.g710.model.utilities.Symbol;

public class Sand extends DestructibleElement {
    private static final Symbol sandSymbol = new Symbol(' ', new HexColorString("b9c600"), new HexColorString("b9c600"));

    public Sand(Position position) {
        super(position, sandSymbol);
    }
}
