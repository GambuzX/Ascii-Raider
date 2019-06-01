package com.asciiraider.g710.model.utilities;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class SymbolTest {
	private List<Symbol> symbols;

	@Before
	public void setUp(){
		symbols = new ArrayList<>();
		symbols.add(new Symbol('Q', new HexColorString("123")));
		symbols.add(new Symbol('W', new HexColorString("abc")));
		symbols.add(new Symbol('E', new HexColorString("456789"), new HexColorString("abcABC")));
	}

	@Test
	public void getAscii1(){
		assertEquals('Q', symbols.get(0).getAscii());
	}

	@Test
	public void getAscii2(){
		assertEquals('W', symbols.get(1).getAscii());
	}

	@Test
	public void getForeColor1(){
		HexColorString mockColor = mock(HexColorString.class);
		when(mockColor.toString()).thenReturn("#abc");
		Symbol sym = new Symbol('A', mockColor);
		assertEquals("#abc", sym.getForegroundColorString());
	}

	@Test
	public void getBackColor1(){
		HexColorString mockColor = mock(HexColorString.class);
		when(mockColor.toString()).thenReturn("#abc");
		Symbol sym = new Symbol('A', mockColor, mockColor);
		assertEquals("#abc", sym.getBackgroundColorString());
	}

	@Test
	public void setBackColor(){
		symbols.get(2).setBackgroundColor(new HexColorString("123"));
		assertEquals(symbols.get(0).getForegroundColorString(), symbols.get(2).getBackgroundColorString());
	}

	@Test
	public void setForeColor(){
		symbols.get(1).setForegroundColor(new HexColorString("456789"));
		assertEquals(symbols.get(2).getForegroundColorString(), symbols.get(1).getForegroundColorString());
	}

	@Test
	public void equals1(){
		HexColorString mockColor1 = mock(HexColorString.class);
		when(mockColor1.toString()).thenReturn("123");
		Symbol symbol = new Symbol('a', mockColor1, mockColor1);
		assertTrue(symbol.equals(symbol));
	}

	@Test
	public void equals2(){
		HexColorString mockColor1 = mock(HexColorString.class);
		when(mockColor1.toString()).thenReturn("123");
		Symbol symbol = new Symbol('a', mockColor1, mockColor1);

		HexColorString hexColorString = mock(HexColorString.class);
		assertFalse(symbol.equals(hexColorString));
	}

	@Test
	public void equals3(){
		Symbol symbol = mock(Symbol.class);
		when(symbol.getAscii()).thenReturn('a');

		Symbol symbol2 = mock(Symbol.class);
		when(symbol2.getAscii()).thenReturn('b');

		assertFalse(symbol.equals(symbol2));
	}

	@Test
	public void equals4(){
		Symbol symbol = mock(Symbol.class);
		when(symbol.getAscii()).thenReturn('a');
		when(symbol.getForegroundColorString()).thenReturn("1234");

		Symbol symbol2 = mock(Symbol.class);
		when(symbol2.getAscii()).thenReturn('a');
		when(symbol2.getForegroundColorString()).thenReturn("123");


		assertFalse(symbol.equals(symbol2));
	}

	@Test
	public void equals5(){
		Symbol symbol = mock(Symbol.class);
		when(symbol.getAscii()).thenReturn('a');
		when(symbol.getForegroundColorString()).thenReturn("123");
		when(symbol.getBackgroundColorString()).thenReturn("123");


		Symbol symbol2 = mock(Symbol.class);
		when(symbol2.getAscii()).thenReturn('a');
		when(symbol2.getForegroundColorString()).thenReturn("123");
		when(symbol2.getBackgroundColorString()).thenReturn("1234");

		assertFalse(symbol.equals(symbol2));
	}

	@Test
	public void equal6(){
		HexColorString mockColor1 = mock(HexColorString.class);
		when(mockColor1.toString()).thenReturn("123");
		Symbol symbol = new Symbol('a', mockColor1, mockColor1);
		Symbol symbol2 = new Symbol('a', mockColor1, mockColor1);


		assertTrue(symbol.equals(symbol2));
	}
}
