package com.asciiraider.g710.model.element;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;


public class PositionTest {
	List<Position> positions;

	@Before
	public void setup(){
		positions = new ArrayList<>();
		positions.add(new Position(1, 2));
		positions.add(new Position(2, 4));
		positions.add(new Position(43, 12));
	}

	@Test(expected = IllegalArgumentException.class)
	public void position1() throws IllegalArgumentException {
		Position p1 = new Position(0, -2);
	}

	@Test(expected = IllegalArgumentException.class)
	public void position2() throws IllegalArgumentException {
		Position p1 = new Position(-5, 1);
	}

	@Test
	public void position3() throws IllegalArgumentException {
		Position p1 = new Position(0, 0);
	}

	@Test
	public void position4() {
		Position p1 = new Position(positions.get(1));
		assertEquals(positions.get(1), p1);
	}

	@Test
	public void positionGet1() {
		assertEquals(1, positions.get(0).getX());
		assertEquals(2, positions.get(0).getY());
	}

	@Test
	public void positionGet2() {
		assertEquals(43, positions.get(2).getX());
		assertEquals(12, positions.get(2).getY());
	}

	@Test
	public void positionSet1() throws IllegalArgumentException {
		positions.get(1).setX(23);
		positions.get(1).setY(33);
		assertEquals(23, positions.get(1).getX());
		assertEquals(33, positions.get(1).getY());
	}

	@Test(expected = IllegalArgumentException.class)
	public void positionSet2() throws IllegalArgumentException {
		positions.get(1).setX(-2);
	}

	@Test(expected = IllegalArgumentException.class)
	public void positionSet3() throws IllegalArgumentException {
		positions.get(1).setY(-6);
	}

	@Test
	public void positionSet4() throws IllegalArgumentException {
		positions.get(1).setX(0);
		positions.get(1).setY(0);
		assertEquals(0, positions.get(1).getX());
		assertEquals(0, positions.get(1).getY());
	}

	@Test
	public void positionEquals1() {
		positions.get(1).setX(1);
		positions.get(1).setY(2);
		assertTrue(positions.get(1).equals(positions.get(0)));
	}

	@Test
	public void positionEquals2() {
		positions.get(1).setX(1);
		positions.get(1).setY(2);
		assertTrue(positions.get(0).equals(positions.get(0)));
	}

	@Test
	public void positionEquals3() {
		positions.get(1).setX(1);
		positions.get(1).setY(2);
		assertFalse(positions.get(0).equals(4));
	}
}
