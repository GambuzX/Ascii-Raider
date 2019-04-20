package com.asciiraider.g710.model.level;

import com.asciiraider.g710.model.element.Element;
import com.asciiraider.g710.model.element.Position;
import com.asciiraider.g710.model.element.Wall;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class LevelBuilderTest {
	LevelBuilder level;

	@Before
	public void setUp() {
		level = new LevelOneBuilder();
	}

	@Test
	public void horizontalLine() throws CloneNotSupportedException {
		level.reset();
		level.createHorizontalLine(new Wall(new Position(23, 32), 'W'), 4, new Position(1, 2));
		List<Element> elementList = level.getResult().getElements();
		int xSum = 0;
		for (int i = 0; i < elementList.size(); i++) {
			xSum += elementList.get(i).getPosition().getX();
			assertEquals(Wall.class, elementList.get(i).getClass());
		}
		assertEquals(4, elementList.size());
		assertEquals(10, xSum);
	}

	@Test
	public void horizontalLineEdgeCase1() throws CloneNotSupportedException {
		level.reset();
		level.createHorizontalLine(new Wall(new Position(23, 32), 'W'), 0, new Position(1, 2));
		List<Element> elementList = level.getResult().getElements();
		assertEquals(0, elementList.size());
	}

	@Test (expected = IllegalArgumentException.class)
	public void horizontalLineEdgeCase2() throws CloneNotSupportedException {
		level.createHorizontalLine(null, 0, new Position(1, 2));
	}

	@Test
	public void verticalLine() throws CloneNotSupportedException {
		level.reset();
		level.createVerticalLine(new Wall(new Position(3, 4), 'W'), 3, new Position(1, 2));
		List<Element> elementList = level.getResult().getElements();
		int ySum = 0;
		for (int i = 0; i < elementList.size(); i++) {
			ySum += elementList.get(i).getPosition().getY();
			assertEquals(Wall.class, elementList.get(i).getClass());
		}
		assertEquals(3, elementList.size());
		assertEquals(9, ySum);
	}

	@Test
	public void verticalLineEdgeCase() throws CloneNotSupportedException {
		level.reset();
		level.createVerticalLine(new Wall(new Position(3, 4), 'W'), 0, new Position(1, 2));
		List<Element> elementList = level.getResult().getElements();
		assertEquals(0, elementList.size());
	}

	@Test (expected = IllegalArgumentException.class)
	public void verticalLineEdgeCase2() throws CloneNotSupportedException {
		level.createVerticalLine(null, 0, new Position(1, 2));
	}

	@Test
	public void rectangle() throws CloneNotSupportedException {
		level.reset();
		level.createRectangle(new Wall(new Position(3, 4), 'W'), 3, 2, new Position(1, 2));
		List<Element> elementList = level.getResult().getElements();
		int ySum = 0, xSum = 0;
		for (int i = 0; i < elementList.size(); i++) {
			ySum += elementList.get(i).getPosition().getY();
			xSum += elementList.get(i).getPosition().getX();
			assertEquals(Wall.class, elementList.get(i).getClass());
		}
		assertEquals(6, elementList.size());
		assertEquals(15, ySum);
		assertEquals(12, xSum);
	}


	@Test
	public void rectangleEdgeCase() throws CloneNotSupportedException {
		level.reset();
		level.createRectangle(new Wall(new Position(3, 4), 'W'), 0, 2, new Position(1, 2));
		List<Element> elementList = level.getResult().getElements();
		assertEquals(0, elementList.size());
	}

	@Test (expected = IllegalArgumentException.class)
	public void rectangleEdgeCase2() throws CloneNotSupportedException {
		level.reset();
		level.createRectangle(null, 0, 2, new Position(1, 2));
	}

	@Test
	public void reset() throws CloneNotSupportedException {
		level.reset();
		level.createHorizontalLine(new Wall(new Position(23, 32), 'W'), 5, new Position(1, 2));
		level.reset();
		List<Element> elementList = level.getResult().getElements();
		assertEquals(0, elementList.size());
	}
}
