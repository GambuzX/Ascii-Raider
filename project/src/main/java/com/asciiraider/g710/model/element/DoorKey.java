package com.asciiraider.g710.model.element;

import com.asciiraider.g710.model.utilities.HexColorString;
import com.asciiraider.g710.model.utilities.Position;
import com.asciiraider.g710.model.utilities.Symbol;

public class DoorKey extends PhysicsElement {
	private static final Symbol doorKeySymbol = new Symbol('⚷', new HexColorString("F0FF14"));

	public DoorKey(Position position) {
		super(position, doorKeySymbol);
	}
}