package com.asciiraider.g710.controller.element;

import com.asciiraider.g710.controller.level.LevelFacade;
import com.asciiraider.g710.model.element.Enemy;
import com.asciiraider.g710.model.element.Player;
import com.asciiraider.g710.model.utilities.Position;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class EnemyControllerTest {
	private EnemyController enemyController;
	private Enemy enemyMock;
	private LevelFacade levelFacadeMock;
	private Player playerMock;
	private Position playerPosMock;

	@Before
	public void setUp(){
		playerPosMock = mock(Position.class);
		playerMock = mock(Player.class);
		when(playerMock.getPosition()).thenReturn(playerPosMock);
		enemyMock = mock(Enemy.class);
		levelFacadeMock = mock(LevelFacade.class);
		when(levelFacadeMock.getPlayer()).thenReturn(playerMock);

		enemyController = new EnemyController(enemyMock);
	}

	@Test
	public void test1(){
		when(enemyMock.move(playerPosMock)).thenReturn(null);
		doThrow(new IllegalArgumentException()).when(levelFacadeMock).insideBounds(any());
		enemyController.handle(levelFacadeMock);
	}

	@Test
	public void test2(){
		List<Position> mockPos = new ArrayList<>();
		Position positionMock = mock(Position.class);
		mockPos.add(playerPosMock);
		mockPos.add(positionMock);

		when(enemyMock.move(playerPosMock)).thenReturn(mockPos);

		when(levelFacadeMock.insideBounds(mockPos.get(0))).thenReturn(false);
		when(levelFacadeMock.insideBounds(mockPos.get(1))).thenReturn(true);

		when(levelFacadeMock.canEnemyMoveTo(mockPos.get(1))).thenReturn(false);

		doThrow(new IllegalArgumentException()).when(levelFacadeMock).setElementPosition(any(), any());
		enemyController.handle(levelFacadeMock);
	}

	@Test(expected = IllegalArgumentException.class)
	public void test3(){
		List<Position> mockPos = new ArrayList<>();
		Position positionMock = mock(Position.class);
		mockPos.add(playerPosMock);
		mockPos.add(positionMock);

		when(enemyMock.move(playerPosMock)).thenReturn(mockPos);

		when(levelFacadeMock.insideBounds(mockPos.get(0))).thenReturn(false);
		when(levelFacadeMock.insideBounds(mockPos.get(1))).thenReturn(true);

		when(levelFacadeMock.canEnemyMoveTo(mockPos.get(1))).thenReturn(true);

		doThrow(new IllegalArgumentException()).when(levelFacadeMock).setElementPosition(enemyMock, mockPos.get(1));
		enemyController.handle(levelFacadeMock);

	}
}
