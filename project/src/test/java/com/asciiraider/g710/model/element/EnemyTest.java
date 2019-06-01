package com.asciiraider.g710.model.element;

import com.asciiraider.g710.GlobalConfigs;
import com.asciiraider.g710.controller.element.FollowMovementStrategy;
import com.asciiraider.g710.controller.element.MovementStrategy;
import com.asciiraider.g710.controller.element.RandomMovementStrategy;
import com.asciiraider.g710.model.utilities.Position;
import com.asciiraider.g710.model.utilities.Symbol;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class EnemyTest {
	Enemy enemyMock;
	List<Position> positionsMock;

	@Before
	public void setUp(){
		positionsMock = new ArrayList<>();

		Position positionMock = mock(Position.class);
		when(positionMock.getX()).thenReturn(1);
		when(positionMock.getY()).thenReturn(2);

		positionsMock.add(positionMock);

		Position positionMock2 = mock(Position.class);
		when(positionMock2.getX()).thenReturn(2);
		when(positionMock2.getY()).thenReturn(3);

		positionsMock.add(positionMock2);

		Position positionMock3 = mock(Position.class);
		when(positionMock3.getX()).thenReturn(2);
		when(positionMock3.getY()).thenReturn(1);

		positionsMock.add(positionMock3);

		Symbol symbolMock = mock(Symbol.class);
		when(symbolMock.getAscii()).thenReturn('@');

		MovementStrategy movementStrategyMock = mock(MovementStrategy.class);
		when(movementStrategyMock.move(positionMock, positionMock2)).thenReturn(positionsMock);

		enemyMock = new Enemy(positionMock, symbolMock) {
			@Override
			protected MovementStrategy createMovementStrategy() {
				return movementStrategyMock;
			}
		};

	}

	@Test
	public void move1(){
		assertEquals(null, enemyMock.move(positionsMock.get(1)));
	}


	@Test
	public void move2(){
		for(int i = 0; i < GlobalConfigs.ENEMY_VELOCITY; i++)
			enemyMock.move(positionsMock.get(1));
		assertEquals(positionsMock.size(), enemyMock.move(positionsMock.get(1)).size());
	}


	@Test
	public void skullEnemyTest(){
		Position mockPosition = mock(Position.class);
		SkullEnemy skullEnemy = new SkullEnemy(mockPosition);
		assertTrue(skullEnemy.createMovementStrategy() instanceof RandomMovementStrategy);
	}

	@Test
	public void mummyEnemyTest(){
		Position mockPosition = mock(Position.class);
		MummyEnemy mummyEnemy = new MummyEnemy(mockPosition);
		assertTrue(mummyEnemy.createMovementStrategy() instanceof FollowMovementStrategy);
	}

}
