package com.asciiraider.g710.model.element;

import com.asciiraider.g710.model.utilities.HexColorString;
import com.asciiraider.g710.model.utilities.Position;
import com.asciiraider.g710.model.utilities.Symbol;

public class StoneBlock extends DestructibleElement implements Barrier {
    private static final Symbol stoneBlockSymbol = new Symbol(' ', new HexColorString("9e9e9e"), new HexColorString("9e9e9e"));

    public StoneBlock(Position position) {
        super(position, stoneBlockSymbol);
    }
}
