package com.asciiraider.g710.controller.element.interaction;

import com.asciiraider.g710.controller.level.LevelController;
import com.asciiraider.g710.controller.level.LevelFacade;
import com.asciiraider.g710.model.element.DoorKey;
import com.asciiraider.g710.model.element.PhysicsElement;
import com.asciiraider.g710.model.utilities.Position;
import org.junit.Before;
import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class PushInteractionTest {
	private Position positionMock;
	private PhysicsElement mockElement;
	private LevelFacade levelFacadeMock;
	private PushInteraction pushInteraction;
	private LevelController lcMock;

	@Before
	public void setUp(){
		positionMock = mock(Position.class);
		mockElement = mock(DoorKey.class);
		when(mockElement.getPosition()).thenReturn(positionMock);
		levelFacadeMock = mock(LevelFacade.class);
		pushInteraction = new PushInteraction(mockElement, levelFacadeMock);
		lcMock = mock(LevelController.class);
	}

	@Test
	public void test1(){
		when(mockElement.isFalling()).thenReturn(true);

		assertFalse(pushInteraction.interact(lcMock, positionMock));

	}

	@Test
	public void test2(){
		when(mockElement.isFalling()).thenReturn(false);
		when(levelFacadeMock.findElement(positionMock)).thenReturn(mockElement);

		assertFalse(pushInteraction.interact(lcMock, positionMock));
	}

	@Test
	public void test3(){
		when(mockElement.isFalling()).thenReturn(false);
		when(levelFacadeMock.findElement(positionMock)).thenReturn(null);

		final int[] counter = new int[1];

		Answer<Integer> answer = new Answer<Integer>() {
			@Override
			public Integer answer(InvocationOnMock invocation) throws Throwable {
				counter[0]++;
				return 1;
			}
		};

		doAnswer(answer).when(levelFacadeMock).setElementPosition(mockElement, positionMock);

		assertTrue(pushInteraction.interact(lcMock, positionMock));
		assertEquals(1, counter[0]);

	}

	@Test
	public void test4(){
		when(mockElement.isFalling()).thenReturn(false);
		when(levelFacadeMock.findElement(positionMock)).thenReturn(null);

		when(mockElement.moveDown()).thenReturn(positionMock);

		assertTrue(pushInteraction.interact(lcMock, positionMock));
		verify(mockElement, times(1)).moveDown();

	}
}
