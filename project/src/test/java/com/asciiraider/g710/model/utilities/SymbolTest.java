package com.asciiraider.g710.model.utilities;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
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

	// TODO: sera preciso separa get e set em testes
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
}
