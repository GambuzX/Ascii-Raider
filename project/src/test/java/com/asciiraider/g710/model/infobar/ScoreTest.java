package com.asciiraider.g710.model.infobar;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class ScoreTest {
	private List<Score> scores;

	@Before
	public void setUp(){
		scores = new ArrayList<>();
		scores.add(new Score(1));
		scores.add(new Score(12));
		scores.add(new Score(123));
		scores.add(new Score(1234));
		scores.add(new Score(12345));
		scores.add(new Score(123456));
	}

	@Test(expected = IllegalArgumentException.class)
	public void constructor(){
		Score score = new Score(-1);
	}

	@Test
	public void constructor1(){
		Score score = new Score(0);
		assertEquals("0", score.toString());
	}


	@Test
	public void getPontuation() {
		assertEquals(1, scores.get(0).getPoints());
	}

	@Test
	public void toArray1(){
		char[] solution =  {'0', '0', '1'};
		try {
			char[] result1 = scores.get(0).pointsToArray3();
			assertArrayEquals(solution, result1);
		} catch (IllegalConversionException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void toArray2(){
		char[] solution =  {'0', '1', '2'};
		try {
			char[] result1 = scores.get(1).pointsToArray3();
			assertArrayEquals(solution, result1);
		} catch (IllegalConversionException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void toArray3(){
		char[] solution =  {'1', '2', '3'};
		try {
			char[] result1 = scores.get(2).pointsToArray3();
			assertArrayEquals(solution, result1);
		} catch (IllegalConversionException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void toArray4(){
		char[] solution =  {'0', '1', 'M'};
		try {
			char[] result1 = scores.get(3).pointsToArray3();
			assertArrayEquals(solution, result1);
		} catch (IllegalConversionException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void toArray5(){
		char[] solution =  {'1', '2', 'M'};
		try {
			char[] result1 = scores.get(4).pointsToArray3();
			assertArrayEquals(solution, result1);
		} catch (IllegalConversionException e) {
			e.printStackTrace();
		}
	}

	@Test(expected = IllegalConversionException.class)
	public void toArray6() throws IllegalConversionException {
		char[] result1 = scores.get(5).pointsToArray3();
	}
}
