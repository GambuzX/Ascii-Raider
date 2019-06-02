package com.asciiraider.g710.controller.element.movestrategy;

import com.asciiraider.g710.controller.element.movestrategy.FollowMovementStrategy;
import com.asciiraider.g710.model.utilities.Position;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FollowMovementStrategyTest {
	@Test
	public void test1(){
		Position positionMock1 = mock(Position.class);
		Position targetPos = mock(Position.class);

		List<Position> mockPos = new ArrayList<>();
		Position pos1 = mock(Position.class);
		when(pos1.distance(targetPos)).thenReturn(2.1);
		when(pos1.getX()).thenReturn(1);

		Position pos2 = mock(Position.class);
		when(pos2.distance(targetPos)).thenReturn(3.5);
		when(pos2.getX()).thenReturn(2);

		Position pos3 = mock(Position.class);
		when(pos3.distance(targetPos)).thenReturn(1.5);
		when(pos3.getX()).thenReturn(3);
		mockPos.add(pos1);
		mockPos.add(pos2);
		mockPos.add(pos3);

		when(positionMock1.getAdjacent()).thenReturn(mockPos);

		FollowMovementStrategy followMovementStrategy = new FollowMovementStrategy();

		List<Position> positions =  followMovementStrategy.move(positionMock1, targetPos);

		assertEquals(3, positions.get(0).getX());
		assertEquals(1, positions.get(1).getX());
		assertEquals(2, positions.get(2).getX());
	}
}
