package com.asciiraider.g710.controller.element.interaction;

import com.asciiraider.g710.controller.level.LevelController;
import com.asciiraider.g710.controller.life.LifeController;
import com.asciiraider.g710.model.element.Element;
import com.asciiraider.g710.model.utilities.Position;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.*;

public class DeathInteractionTest {
	@Test
	public void test1(){
		Element mockElement = mock(Element.class);
		DeathInteraction deathInteraction = new DeathInteraction(mockElement);
		LifeController lifeControllerMock = mock(LifeController.class);
		LevelController lcMock = mock(LevelController.class);
		when(lcMock.getLifeController()).thenReturn(lifeControllerMock);
		Position positionMock = mock(Position.class);
		assertFalse(deathInteraction.interact(lcMock, positionMock));
		verify(lifeControllerMock, times(1)).notifyObservers();
	}
}
