package com.asciiraider.g710.model.element;

import com.asciiraider.g710.GlobalConfigs;
import com.asciiraider.g710.model.utilities.Position;
import com.asciiraider.g710.model.utilities.Symbol;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PhysicsElementTest {
	PhysicsElement physicsElement;
	List<Position> positionMocks;

	@Before
	public void setUp(){
		positionMocks = new ArrayList<>();

		Position positionMock1 = mock(Position.class);
		when(positionMock1.getY()).thenReturn(2);

		Position positionMock2 = mock(Position.class);
		when(positionMock2.getY()).thenReturn(1);

		when(positionMock1.getBelow()).thenReturn(positionMock2);

		positionMocks.add(positionMock1);
		positionMocks.add(positionMock2);

		Symbol symbolMock = mock(Symbol.class);

		physicsElement = new PhysicsElement(positionMock1, symbolMock) {
		};
	}

	@Test
	public void constructor(){
		assertFalse(physicsElement.isFalling());
	}

	@Test
	public void setFalling(){
		physicsElement.setFalling(true);
		assertTrue(physicsElement.isFalling());
	}

	@Test
	public void moveDown1(){
		assertEquals(2, physicsElement.moveDown().getY());
	}

	@Test
	public void moveDown2(){
		physicsElement.setFalling(true);
		for(int i = 0; i < GlobalConfigs.GRAVITY; i++)
			physicsElement.moveDown();
		assertEquals(1, physicsElement.moveDown().getY());
	}

	@Test
	public void moveDown3(){
		for(int i = 0; i < GlobalConfigs.GRAVITY; i++)
			physicsElement.moveDown();
		assertEquals(2, physicsElement.moveDown().getY());
	}

	@Test
	public void moveDown4(){
		for(int i = 0; i < GlobalConfigs.GRAVITY - 2; i++)
			physicsElement.moveDown();
		assertEquals(2, physicsElement.moveDown().getY());
	}

	@Test
	public void moveDown5(){
		physicsElement.setFalling(true);
		for(int i = 0; i < GlobalConfigs.GRAVITY - 2; i++)
			physicsElement.moveDown();
		assertEquals(2, physicsElement.moveDown().getY());
	}
}
