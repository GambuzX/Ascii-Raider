package com.asciiraider.g710.model.element;

import com.asciiraider.g710.model.utilities.HexColorString;
import com.asciiraider.g710.model.utilities.Position;
import com.asciiraider.g710.model.utilities.Symbol;

public class Wall extends Element implements Barrier{
	private static final Symbol wallSymbol = new Symbol('⎕', new HexColorString("ffffff"),  new HexColorString("ffffff"));

	public Wall(Position position) {
		super(position, wallSymbol);
	}
}
