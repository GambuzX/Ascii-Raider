package com.asciiraider.g710.controller.element;

import com.asciiraider.g710.model.utilities.Position;

import java.util.List;

// TODO: talvez passar para model??
public interface MovementStrategy {
	List<Position> move(Position currentPosition, Position targetPosition);
}
