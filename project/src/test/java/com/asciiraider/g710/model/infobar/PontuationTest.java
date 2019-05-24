package com.asciiraider.g710.model.infobar;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class PontuationTest {
	private List<Pontuation> pontuations;

	@Before
	public void setUp(){
		pontuations = new ArrayList<>();
		pontuations.add(new Pontuation(1));
		pontuations.add(new Pontuation(12));
		pontuations.add(new Pontuation(123));
		pontuations.add(new Pontuation(1234));
		pontuations.add(new Pontuation(12345));
		pontuations.add(new Pontuation(123456));
	}

	@Test(expected = IllegalArgumentException.class)
	public void constructor(){
		Pontuation pontuation = new Pontuation(-1);
	}

	@Test
	public void getPontuation() {
		assertEquals(1, pontuations.get(0).getPoints());
	}

	@Test
	public void toArray1(){
		char[] solution =  {'0', '0', '1'};
		try {
			char[] result1 = pontuations.get(0).pointsToArray3();
			assertArrayEquals(solution, result1);
		} catch (IllegalConversionException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void toArray2(){
		char[] solution =  {'0', '1', '2'};
		try {
			char[] result1 = pontuations.get(1).pointsToArray3();
			assertArrayEquals(solution, result1);
		} catch (IllegalConversionException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void toArray3(){
		char[] solution =  {'1', '2', '3'};
		try {
			char[] result1 = pontuations.get(2).pointsToArray3();
			assertArrayEquals(solution, result1);
		} catch (IllegalConversionException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void toArray4(){
		char[] solution =  {'0', '1', 'M'};
		try {
			char[] result1 = pontuations.get(3).pointsToArray3();
			assertArrayEquals(solution, result1);
		} catch (IllegalConversionException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void toArray5(){
		char[] solution =  {'1', '2', 'M'};
		try {
			char[] result1 = pontuations.get(4).pointsToArray3();
			assertArrayEquals(solution, result1);
		} catch (IllegalConversionException e) {
			e.printStackTrace();
		}
	}

	@Test(expected = IllegalConversionException.class)
	public void toArray6() throws IllegalConversionException {
		char[] result1 = pontuations.get(5).pointsToArray3();
	}
}
