package com.asciiraider.g710.model.element;

public class StoneBlock extends DestructibleElement {
    private static final Symbol stoneBlockSymbol = new Symbol(' ', "#9e9e9e", "#9e9e9e");

    public StoneBlock(Position position) {
        super(position, stoneBlockSymbol);
    }
}
