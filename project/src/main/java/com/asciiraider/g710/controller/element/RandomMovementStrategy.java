package com.asciiraider.g710.controller.element;

import com.asciiraider.g710.model.utilities.Position;

import java.util.Collections;
import java.util.List;

public class RandomMovementStrategy implements MovementStrategy {

	@Override
	public List<Position> move(Position currentPosition, Position targetPosition) {
		List<Position> order = currentPosition.getAdjacent();

		Collections.shuffle(order);

		return order;
	}
}
