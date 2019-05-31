package com.asciiraider.g710.model.element;

import com.asciiraider.g710.controller.element.interaction.Interaction;
import com.asciiraider.g710.controller.level.LevelController;
import com.asciiraider.g710.model.utilities.Position;
import com.asciiraider.g710.model.utilities.Symbol;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.*;
import static org.mockito.Mockito.*;

public class ElementTest {
	List<Element> elementMocks;

	@Before
	public void setUp(){
		elementMocks = new ArrayList<>();
		Position positionMock = mock(Position.class);
		when(positionMock.getX()).thenReturn(1);
		when(positionMock.getY()).thenReturn(2);

		Symbol symbolMock = mock(Symbol.class);
		when(symbolMock.getAscii()).thenReturn('@');

		Element elementMock = new Element(positionMock, symbolMock) {
		};

		elementMocks.add(elementMock);

		Position positionMock2 = mock(Position.class);
		when(positionMock.getX()).thenReturn(2);
		when(positionMock.getY()).thenReturn(3);

		Symbol symbolMock2 = mock(Symbol.class);
		when(symbolMock.getAscii()).thenReturn('@');

		Element elementMock2 = new Element(positionMock2, symbolMock2) {
		};

		elementMocks.add(elementMock2);

		Position positionMock3 = mock(Position.class);
		when(positionMock.getX()).thenReturn(1);
		when(positionMock.getY()).thenReturn(2);

		Symbol symbolMock3 = mock(Symbol.class);
		when(symbolMock.getAscii()).thenReturn('£');

		Element elementMock3 = new Element(positionMock3, symbolMock3) {
		};

		elementMocks.add(elementMock3);

		Element elementMock4 = new Element(positionMock, symbolMock) {
		};

		elementMocks.add(elementMock4);


	}

	@Test
	public void getPosition(){
		Position positionMock = mock(Position.class);
		when(positionMock.getX()).thenReturn(2);
		when(positionMock.getY()).thenReturn(3);

		elementMocks.get(0).setPosition(positionMock);

		assertEquals(2, elementMocks.get(0).getPosition().getX());
	}

	@Test
	public void equals1(){
		assertTrue(elementMocks.get(1).equals(elementMocks.get(1)));
	}

	@Test
	public void equals2(){
		Position positionMock = mock(Position.class);
		when(positionMock.getX()).thenReturn(2);
		when(positionMock.getY()).thenReturn(3);
		assertFalse(elementMocks.get(2).equals(positionMock));
	}

	@Test
	public void equals3(){
		assertFalse(elementMocks.get(0).equals(elementMocks.get(1)));
	}

	@Test
	public void equals4(){
		assertFalse(elementMocks.get(0).equals(elementMocks.get(2)));
	}

	@Test
	public void equals5(){
		assertTrue(elementMocks.get(0).equals(elementMocks.get(3)));
	}

	@Test(expected = IllegalAccessError.class)
	public void interaction(){
		LevelController levelControllerMock = mock(LevelController.class);
		Position positionMock = mock(Position.class);

		Interaction interactionMock = mock(Interaction.class);
		doThrow(new IllegalAccessError()).when(interactionMock).interact(levelControllerMock, positionMock);

		elementMocks.get(0).setPlayerInteraction(interactionMock);

		elementMocks.get(0).getPlayerInteraction().interact(levelControllerMock, positionMock);
	}
}
