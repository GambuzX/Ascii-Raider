package com.asciiraider.g710.controller.element;

import com.asciiraider.g710.model.utilities.Position;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// TODO: improve algorithm
public class FollowMovementStrategy implements MovementStrategy {
	@Override
	public List<Position> move(Position currentPosition, Position targetPosition) {
		List<Position> order = currentPosition.getAdjacent();
		Collections.sort(order, createComparator(targetPosition));
		return order;
	}

	// TODO: aqui ou numa classe fora
	private static Comparator<Position> createComparator(Position centralPosition)
	{
		final Position centerPosition =  centralPosition;
		return (p1, p2) -> {
			double d1 = (p1.distance(centerPosition));
			double d2 = (p2.distance(centerPosition));
			return Double.compare(d1, d2);
		};
	}
}
