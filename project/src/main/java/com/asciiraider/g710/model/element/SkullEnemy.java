package com.asciiraider.g710.model.element;

import com.asciiraider.g710.controller.element.movestrategy.MovementStrategy;
import com.asciiraider.g710.controller.element.movestrategy.RandomMovementStrategy;
import com.asciiraider.g710.model.utilities.HexColorString;
import com.asciiraider.g710.model.utilities.Position;
import com.asciiraider.g710.model.utilities.Symbol;

public class SkullEnemy extends Enemy {
	private static final Symbol enemySymbol = new Symbol('☠', new HexColorString("ff0000"));

	public SkullEnemy(Position position) {
		super(position, enemySymbol);
	}

	@Override
	protected MovementStrategy createMovementStrategy() {
		return new RandomMovementStrategy();
	}
}
