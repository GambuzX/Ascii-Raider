package com.asciiraider.g710.controller.element.interaction;

import com.asciiraider.g710.controller.level.LevelController;
import com.asciiraider.g710.model.element.Element;
import com.asciiraider.g710.model.utilities.Position;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.mock;

public class BarrierInteractionTest {
	@Test
	public void test1(){
		Element mockElement = mock(Element.class);
		BarrierInteraction barrierInteraction = new BarrierInteraction(mockElement);
		LevelController lcMock = mock(LevelController.class);
		Position positionMock = mock(Position.class);
		assertFalse(barrierInteraction.interact(lcMock, positionMock));
	}
}
