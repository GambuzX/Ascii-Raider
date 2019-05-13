package com.asciiraider.g710.model.element;

import com.asciiraider.g710.model.utilities.HexColorString;
import com.asciiraider.g710.model.utilities.Position;
import com.asciiraider.g710.model.utilities.Symbol;

public class Boulder extends PhysicsElement{
	private static final Symbol boulderSymbol = new Symbol('⌾', new HexColorString("4a7c45"));

	public Boulder(Position position) {
		super(position, boulderSymbol);
	}
}
