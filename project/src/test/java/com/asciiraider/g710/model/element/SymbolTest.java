package com.asciiraider.g710.model.element;

import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

// @RunWith(PowerMockRunner.class)
// @PrepareForTest(Symbol.class)
public class SymbolTest {
	//private Symbol mockSymbol;
	private List<Symbol> symbols;

	@Before
	public void setUp(){
		symbols = new ArrayList<>();
		symbols.add(new Symbol('A', "#000000"));
		symbols.add(new Symbol('B', "#ffffff"));
		symbols.add(new Symbol('C', "#abcdef"));
	}

	@Test
	public void isHexChar1(){
		Method method;
		try {
			method = Symbol.class.getDeclaredMethod("isHexChar", char.class);
			method.setAccessible(true);
			assertEquals(true, method.invoke(symbols.get(0), '0'));
		} catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void isHexChar2(){
		Method method;
		try {
			method = Symbol.class.getDeclaredMethod("isHexChar", char.class);
			method.setAccessible(true);
			assertEquals(true, method.invoke(symbols.get(0), '9'));
		} catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void isHexChar3(){
		Method method;
		try {
			method = Symbol.class.getDeclaredMethod("isHexChar", char.class);
			method.setAccessible(true);
			assertEquals(true, method.invoke(symbols.get(0), 'a'));
		} catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void isHexChar4(){
		Method method;
		try {
			method = Symbol.class.getDeclaredMethod("isHexChar", char.class);
			method.setAccessible(true);
			assertEquals(true, method.invoke(symbols.get(0), 'f'));
		} catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void isHexChar5(){
		Method method;
		try {
			method = Symbol.class.getDeclaredMethod("isHexChar", char.class);
			method.setAccessible(true);
			assertEquals(true, method.invoke(symbols.get(0), 'A'));
		} catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void isHexChar6(){
		Method method;
		try {
			method = Symbol.class.getDeclaredMethod("isHexChar", char.class);
			method.setAccessible(true);
			assertEquals(true, method.invoke(symbols.get(0), 'F'));
		} catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void isHexChar7(){
		Method method;
		try {
			method = Symbol.class.getDeclaredMethod("isHexChar", char.class);
			method.setAccessible(true);
			assertEquals(false, method.invoke(symbols.get(0), 'p'));
		} catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	/*@Test
	public void validHexColor1() {
		mockSymbol = PowerMockito.spy(new Symbol('A', "#1"));
		try {
			PowerMockito.when(mockSymbol, "validHexColor", "#qwer").thenReturn(true);
			mockSymbol.setHexColor("#qwer");
			assertEquals("#qwer", mockSymbol.getHexColor());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}*/
}
