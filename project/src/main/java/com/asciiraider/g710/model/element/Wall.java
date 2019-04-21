package com.asciiraider.g710.model.element;

public class Wall extends Element {
	private static final Symbol wallSymbol = new Symbol(' ', "#ffffff");

	public Wall(Position position) {
		super(position, wallSymbol);
	}
}
