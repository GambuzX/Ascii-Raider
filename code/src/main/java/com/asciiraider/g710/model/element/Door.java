package com.asciiraider.g710.model.element;

import com.asciiraider.g710.model.utilities.HexColorString;
import com.asciiraider.g710.model.utilities.Position;
import com.asciiraider.g710.model.utilities.Symbol;

public class Door extends Element {
	private static final Symbol doorSymbol = new Symbol('⌻', new HexColorString("8B4513"));
	public Door(Position position) {
		super(position, doorSymbol);
	}
}
