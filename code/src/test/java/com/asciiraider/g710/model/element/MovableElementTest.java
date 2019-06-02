package com.asciiraider.g710.model.element;

import com.asciiraider.g710.model.utilities.Position;
import com.asciiraider.g710.model.utilities.Symbol;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MovableElementTest {
	MovableElement movableElement;
	List<Position> mockPostions;
	MovableElement movableElement2;

	@Before
	public void sestUp(){
		mockPostions = new ArrayList<>();
		Position upMock = mock(Position.class);
		when(upMock.getY()).thenReturn(2);
		Position downMock = mock(Position.class);
		when(downMock.getY()).thenReturn(0);
		when(downMock.getX()).thenReturn(1);
		Position rightMock = mock(Position.class);
		when(rightMock.getX()).thenReturn(2);
		Position leftMock = mock(Position.class);
		when(leftMock.getX()).thenReturn(0);

		Position initialPosition = mock(Position.class);
		when(initialPosition.getAbove()).thenReturn(upMock);
		when(initialPosition.getBelow()).thenReturn(downMock);
		when(initialPosition.getLeftSide()).thenReturn(leftMock);
		when(initialPosition.getRightSide()).thenReturn(rightMock);

		mockPostions.add(initialPosition);
		mockPostions.add(upMock);
		mockPostions.add(downMock);
		mockPostions.add(leftMock);
		mockPostions.add(rightMock);

		when(downMock.getAbove()).thenThrow(new IllegalArgumentException());
		when(downMock.getLeftSide()).thenThrow(new IllegalArgumentException());

		Symbol mockSymbol = mock(Symbol.class);

		movableElement = new MovableElement(mockPostions.get(0), mockSymbol) {
		};

		movableElement2 = new MovableElement(downMock, mockSymbol) {
		};

	}

	@Test
	public void moveUp(){
		assertEquals(2, movableElement.moveUp().getY());
	}

	@Test
	public void moveUp2(){
		assertEquals(0, movableElement2.moveUp().getY());
	}

	@Test
	public void moveDown(){
		assertEquals(0, movableElement.moveDown().getY());
	}

	@Test
	public void moveLeft(){
		assertEquals(0, movableElement.moveLeft().getX());
	}

	@Test
	public void moveLeft2(){
		assertEquals(1, movableElement2.moveLeft().getX());
	}

	@Test
	public void moveRight(){
		assertEquals(2, movableElement.moveRight().getX());
	}
}
