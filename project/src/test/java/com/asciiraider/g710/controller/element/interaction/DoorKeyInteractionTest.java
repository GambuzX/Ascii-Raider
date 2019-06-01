package com.asciiraider.g710.controller.element.interaction;

import com.asciiraider.g710.controller.level.LevelController;
import com.asciiraider.g710.controller.level.LevelFacade;
import com.asciiraider.g710.model.element.DoorKey;
import com.asciiraider.g710.model.utilities.Position;
import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.mockito.Mockito.*;

public class DoorKeyInteractionTest {
	@Test
	public void test1(){
		Position positionMock = mock(Position.class);

		DoorKey mockElement = mock(DoorKey.class);
		when(mockElement.getPosition()).thenReturn(positionMock);

		LevelFacade levelFacadeMock = mock(LevelFacade.class);


		final int[] counter = new int[1];

		Answer<Integer> answer = new Answer<Integer>() {
			@Override
			public Integer answer(InvocationOnMock invocation) throws Throwable {
				counter[0]++;
				return 1;
			}
		};

		doAnswer(answer).when(levelFacadeMock).removeDoorKey();
		doAnswer(answer).when(levelFacadeMock).removeDoor();

		DoorKeyInteraction doorKeyInteraction = new DoorKeyInteraction(mockElement, levelFacadeMock);

		LevelController lcMock = mock(LevelController.class);

		assertTrue(doorKeyInteraction.interact(lcMock, positionMock));
		assertEquals(2, counter[0]);

	}
}
