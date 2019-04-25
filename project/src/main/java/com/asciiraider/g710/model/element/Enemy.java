package com.asciiraider.g710.model.element;

import com.asciiraider.g710.model.utilities.HexColorString;
import com.asciiraider.g710.model.utilities.Position;
import com.asciiraider.g710.model.utilities.Symbol;

public class Enemy extends DestructibleElement implements Movable, Explosive{
    private static final Symbol enemySymbol = new Symbol('Y', new HexColorString("ff0000"));

    public Enemy(Position position) {
        super(position, enemySymbol);
    }
}
