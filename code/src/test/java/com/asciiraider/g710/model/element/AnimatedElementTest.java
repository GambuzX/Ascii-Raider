package com.asciiraider.g710.model.element;

import com.asciiraider.g710.model.utilities.Animation;
import com.asciiraider.g710.model.utilities.Position;
import com.asciiraider.g710.model.utilities.Symbol;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AnimatedElementTest {
	List<AnimatedElement> animatedElements;

	@Before
	public void	setUp(){
		animatedElements = new ArrayList<>();

		Symbol symbolMock = mock(Symbol.class);
		when(symbolMock.getAscii()).thenReturn('q');

		Symbol symbolMock2 = mock(Symbol.class);
		when(symbolMock2.getAscii()).thenReturn('e');

		Animation animationMock = mock(Animation.class);
		when(animationMock.getNextSymbol()).thenReturn(null);

		Position positionMock = mock(Position.class);
		when(positionMock.getX()).thenReturn(2);
		when(positionMock.getY()).thenReturn(3);

		animatedElements.add(new AnimatedElement(positionMock, animationMock));


		Animation animationMock2 = mock(Animation.class);
		when(animationMock2.getNextSymbol()).thenReturn(symbolMock, symbolMock2);

		animatedElements.add(new AnimatedElement(positionMock, animationMock2));
	}

	@Test
	public void updateAnimation1(){
		assertFalse(animatedElements.get(0).updateAnimation());
	}


	@Test
	public void updateAnimation2(){
		assertTrue(animatedElements.get(1).updateAnimation());
	}

	@Test
	public void updateAnimation3(){
		animatedElements.get(1).updateAnimation();

		assertEquals('e', animatedElements.get(1).getSymbol().getAscii());
	}
}
