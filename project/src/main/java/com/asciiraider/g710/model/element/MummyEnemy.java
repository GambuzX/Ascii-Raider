package com.asciiraider.g710.model.element;

import com.asciiraider.g710.controller.element.FollowMovementStrategy;
import com.asciiraider.g710.controller.element.MovementStrategy;
import com.asciiraider.g710.model.utilities.HexColorString;
import com.asciiraider.g710.model.utilities.Position;
import com.asciiraider.g710.model.utilities.Symbol;

public class MummyEnemy extends Enemy {
	private static final Symbol enemySymbol = new Symbol('☠', new HexColorString("ff00ff"));

	public MummyEnemy(Position position) {
		super(position, enemySymbol);
	}

	@Override
	protected MovementStrategy createMovementStrategy() {
		return new FollowMovementStrategy();
	}
}
