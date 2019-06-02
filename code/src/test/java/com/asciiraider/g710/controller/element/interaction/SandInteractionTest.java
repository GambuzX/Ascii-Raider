package com.asciiraider.g710.controller.element.interaction;

import com.asciiraider.g710.controller.level.LevelController;
import com.asciiraider.g710.controller.level.LevelFacade;
import com.asciiraider.g710.model.element.Sand;
import com.asciiraider.g710.model.utilities.Position;
import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.mockito.Mockito.*;

public class SandInteractionTest {
	@Test
	public void test1(){
		Position positionMock = mock(Position.class);
		when(positionMock.getX()).thenReturn(0);
		when(positionMock.getY()).thenReturn(0);


		Sand mockElement = mock(Sand.class);
		when(mockElement.getPosition()).thenReturn(positionMock);

		LevelFacade levelFacadeMock = mock(LevelFacade.class);


		final int[] counter = new int[1];

		Answer<Boolean> answer = new Answer<Boolean>() {
			@Override
			public Boolean answer(InvocationOnMock invocation) throws Throwable {
				counter[0]++;
				return true;
			}
		};


		SandInteraction sandInteraction= new SandInteraction(mockElement, levelFacadeMock);

		doAnswer(answer).when(levelFacadeMock).removeSandBlock(positionMock);

		LevelController lcMock = mock(LevelController.class);

		assertTrue(sandInteraction.interact(lcMock, positionMock));
		assertEquals(1, counter[0]);

	}
}
