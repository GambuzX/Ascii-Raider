package com.asciiraider.g710.model.element;

import com.asciiraider.g710.model.utilities.HexColorString;
import com.asciiraider.g710.model.utilities.Position;
import com.asciiraider.g710.model.utilities.Symbol;

import java.util.List;

public class Player extends MovableElement {
    private static final Symbol playerSymbol = new Symbol('☻', new HexColorString("ff007f"));

    public Player(Position position) {
        super(position, playerSymbol);
    }

    // TODO: refactor here. rethink the move and moveUp,Down,Left,Right
    @Override
    public List<Position> move(Position targetPosition) {
        return null;
    }
}
