package com.asciiraider.g710.controller.element.movestrategy;

import com.asciiraider.g710.model.utilities.Position;

import java.util.List;

public interface MovementStrategy {
	List<Position> move(Position currentPosition, Position targetPosition);
}
