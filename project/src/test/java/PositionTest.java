import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

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
	public void positionGet1() {
		assertEquals(positions.get(0).getX(), 1);
		assertEquals(positions.get(0).getY(), 2);
	}

	@Test
	public void positionGet2() {
		assertEquals(positions.get(2).getX(), 43);
		assertEquals(positions.get(2).getY(), 12);
	}

	@Test
	public void positionSet1() throws IllegalArgumentException {
		positions.get(1).setX(23);
		positions.get(1).setY(33);
		assertEquals(positions.get(1).getX(), 23);
		assertEquals(positions.get(1).getY(), 33);
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
	public void positionEquals() {
		positions.get(1).setX(1);
		positions.get(1).setY(2);
		assertTrue(positions.get(1).equals(positions.get(0)));
	}
}
