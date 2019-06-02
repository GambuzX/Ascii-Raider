package com.asciiraider.g710.controller.element.movestrategy;

import com.asciiraider.g710.model.utilities.Position;

import java.util.List;

public class FollowMovementStrategy implements MovementStrategy {
	@Override
	public List<Position> move(Position currentPosition, Position targetPosition) {
		List<Position> order = currentPosition.getAdjacent();
		order.sort(Position.createComparator(targetPosition));
		return order;
	}
}
