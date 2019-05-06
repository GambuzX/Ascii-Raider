package com.asciiraider.g710.controller.element;

import com.asciiraider.g710.model.utilities.Position;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomMovementStrategy implements MovementStrategy {

	@Override
	public List<Position> move(Position currentPosition, Position targetPosition) {
		List<Position> order = new ArrayList<>();

		try {
			order.add(currentPosition.getAbove());
		}
		catch (Exception e) {}

		try {
			order.add(currentPosition.getLeftSide());
		}
		catch (Exception e){}

		order.add(currentPosition.getRightSide());
		order.add(currentPosition.getBelow());
		Collections.shuffle(order);

		return order;
	}
}
