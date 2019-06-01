package com.asciiraider.g710.controller.element;

import com.asciiraider.g710.model.utilities.Position;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class RandomMovementStrategyTest {
	@Test
	public void test1(){
		Position posArgMock = mock(Position.class);
		List<Position> mockPos = new ArrayList<>();
		Position pos1 = mock(Position.class);
		when(pos1.getX()).thenReturn(1);

		Position pos2 = mock(Position.class);
		when(pos2.getX()).thenReturn(2);

		Position pos3 = mock(Position.class);
		when(pos3.getX()).thenReturn(3);
		mockPos.add(pos1);
		mockPos.add(pos2);
		mockPos.add(pos3);

		when(posArgMock.getAdjacent()).thenReturn(mockPos);

		RandomMovementStrategy randomMovementStrategy = new RandomMovementStrategy();

		assertEquals(3, randomMovementStrategy.move(posArgMock, posArgMock).size());

	}
}
