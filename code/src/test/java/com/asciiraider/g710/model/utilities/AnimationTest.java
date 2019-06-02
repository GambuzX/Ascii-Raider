package com.asciiraider.g710.model.utilities;

import com.asciiraider.g710.GlobalConfigs;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AnimationTest {

	@Test
	public void addSymbol(){
		Animation animation = new Animation(2, true);

		Symbol mockSymbol = mock(Symbol.class);
		when(mockSymbol.getAscii()).thenReturn('#');

		animation.addSymbol(mockSymbol);

		assertEquals('#', animation.getNextSymbol().getAscii());
	}

	@Test
	public void test1(){
		Animation animation = new Animation( 0.1, false);

		Symbol mockSymbol = mock(Symbol.class);
		when(mockSymbol.getAscii()).thenReturn('#');

		Symbol mockSymbol2 = mock(Symbol.class);
		when(mockSymbol2.getAscii()).thenReturn('&');

		animation.addSymbol(mockSymbol);
		animation.addSymbol(mockSymbol2);

		for(int i = 0; i < (0.1 / 2 * GlobalConfigs.FPS); i++)
			animation.getNextSymbol();

		assertEquals('&', animation.getNextSymbol().getAscii());
	}

	@Test
	public void test2(){
		Animation animation = new Animation( 0.1, false);

		Symbol mockSymbol = mock(Symbol.class);
		when(mockSymbol.getAscii()).thenReturn('#');

		Symbol mockSymbol2 = mock(Symbol.class);
		when(mockSymbol2.getAscii()).thenReturn('&');

		animation.addSymbol(mockSymbol);
		animation.addSymbol(mockSymbol2);

		for(int i = 0; i <= (0.1 / 2 * GlobalConfigs.FPS) * 2; i++)
			animation.getNextSymbol();

		assertEquals(null, animation.getNextSymbol());
	}

	@Test
	public void test3(){
		Animation animation = new Animation( 0.1, true);

		Symbol mockSymbol = mock(Symbol.class);
		when(mockSymbol.getAscii()).thenReturn('#');

		Symbol mockSymbol2 = mock(Symbol.class);
		when(mockSymbol2.getAscii()).thenReturn('&');

		animation.addSymbol(mockSymbol);
		animation.addSymbol(mockSymbol2);

		for(int i = 0; i <= (0.1 / 2 * GlobalConfigs.FPS) * 2; i++)
			animation.getNextSymbol();

		assertEquals('#', animation.getNextSymbol().getAscii());
	}
}
