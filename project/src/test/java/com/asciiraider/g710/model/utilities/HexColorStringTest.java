package com.asciiraider.g710.model.utilities;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

public class HexColorStringTest {
	private List<HexColorString> hexColors;

	@Before
	public void setup(){
		hexColors = new ArrayList<>();
		hexColors.add(new HexColorString());
		hexColors.add(new HexColorString("123456"));
		hexColors.add(new HexColorString("Abc"));
	}

	@Test
	public void isValidHexColor1(){
		assertTrue(hexColors.get(0).isValidHexColor("1"));
	}

	@Test
	public void isValidHexColor2(){
		assertFalse(hexColors.get(0).isValidHexColor(""));
	}

	@Test
	public void isValidHexColor3(){
		assertFalse(hexColors.get(0).isValidHexColor("1234567"));
	}

	@Test
	public void isValidHexColor4(){
		assertFalse(hexColors.get(0).isValidHexColor("abcqwe"));
	}

	@Test
	public void isValidHexColor5(){
		assertTrue(hexColors.get(0).isValidHexColor("ABCDEF"));
	}

	@Test
	public void isValidHexColor6(){
		assertTrue(hexColors.get(0).isValidHexColor("abcdef"));
	}

	@Test
	public void isValidHexColor7(){
		assertTrue(hexColors.get(0).isValidHexColor("09afAF"));
	}

	@Test
	public void toString1(){
		assertEquals("#Abc", hexColors.get(2).toString());
	}

	@Test
	public void getColor1(){
		assertEquals("123456", hexColors.get(1).getColor());
	}

	@Test
	public void getColor2(){
		assertEquals("0", hexColors.get(0).getColor());
	}

	@Test(expected = IllegalArgumentException.class)
	public void setHexColors1(){
		HexColorString mockColor = spy(HexColorString.class);
		when(mockColor.isValidHexColor(anyString())).thenReturn(false);
		mockColor.setColor("123");
	}

	@Test
	public void setHexColors2(){
		HexColorString mockColor = spy(HexColorString.class);
		when(mockColor.isValidHexColor(anyString())).thenReturn(true);
		mockColor.setColor("nao deveria funcionar");
		assertEquals("nao deveria funcionar", mockColor.getColor());
	}


	// TODO: ainda nao esta independente de isValidHexColor
	@Test(expected = IllegalArgumentException.class)
	public void hexColor1(){
		HexColorString color = new HexColorString("qwe");
	}
}
