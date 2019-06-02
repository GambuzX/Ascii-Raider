package com.asciiraider.g710.controller.level;

import com.asciiraider.g710.controller.observer.LevelCompletedObserver;
import com.asciiraider.g710.model.element.ExitDoor;
import com.asciiraider.g710.model.element.Player;
import com.asciiraider.g710.model.level.LevelManager;
import com.asciiraider.g710.model.level.LevelTimeAlarm;
import com.asciiraider.g710.model.utilities.Position;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class LevelProgressionControllerTest {
	private LevelProgressionController levelProgressionController;
	private LevelCompletedObserver levelCompletedObserver;

	@Before
	public void setUp(){
		levelProgressionController = new LevelProgressionController();
		levelCompletedObserver = mock(LevelCompletedObserver.class);
	}

	@Test
	public void add1(){

		levelProgressionController.addObserver(levelCompletedObserver);
		levelProgressionController.notifyObservers();

		verify(levelCompletedObserver, times(1)).updateScore(0);
		verify(levelCompletedObserver, times(1)).updateNumKeys(0);

	}

	@Test
	public void remove1(){
		levelProgressionController.addObserver(levelCompletedObserver);
		levelProgressionController.removeObserver(levelCompletedObserver);
		levelProgressionController.notifyObservers();

		verify(levelCompletedObserver, never()).updateScore(0);
		verify(levelCompletedObserver, never()).updateNumKeys(0);
	}

	@Test
	public void handler1(){
		Position position = mock(Position.class);
		when(position.getAbove()).thenReturn(position);

		ExitDoor exitDoor = mock(ExitDoor.class);
		when(exitDoor.getPosition()).thenReturn(position);

		Position playerPosition = mock(Position.class);

		Player player = mock(Player.class);
		when(player.getPosition()).thenReturn(playerPosition);

		LevelFacade levelFacadeMock = mock(LevelFacade.class);
		when(levelFacadeMock.getExitDoor()).thenReturn(exitDoor);
		when(levelFacadeMock.getPlayer()).thenReturn(player);

		LevelManager levelManager = mock(LevelManager.class);
		when(levelManager.getCurrentLevelFacade()).thenReturn(levelFacadeMock);

		levelProgressionController.handler(levelManager);

		verify(levelManager, never()).nextLevel();
	}

	@Test
	public void handler2(){
		Position position = mock(Position.class);
		when(position.getAbove()).thenReturn(position);

		ExitDoor exitDoor = mock(ExitDoor.class);
		when(exitDoor.getPosition()).thenReturn(position);

		Position playerPosition = mock(Position.class);

		Player player = mock(Player.class);
		when(player.getPosition()).thenReturn(position);

		LevelFacade levelFacadeMock = mock(LevelFacade.class);
		when(levelFacadeMock.getExitDoor()).thenReturn(exitDoor);
		when(levelFacadeMock.getPlayer()).thenReturn(player);

		LevelManager levelManager = mock(LevelManager.class);
		when(levelManager.getCurrentLevelFacade()).thenReturn(levelFacadeMock);
		when(levelManager.getCurrentLevelKeys()).thenReturn(1);

		levelProgressionController.handler(levelManager);

		verify(levelManager, never()).nextLevel();
	}

	@Test
	public void handler3(){
		Position position = mock(Position.class);
		when(position.getAbove()).thenReturn(position);

		ExitDoor exitDoor = mock(ExitDoor.class);
		when(exitDoor.getPosition()).thenReturn(position);

		Player player = mock(Player.class);
		when(player.getPosition()).thenReturn(position);

		LevelFacade levelFacadeMock = mock(LevelFacade.class);
		when(levelFacadeMock.getExitDoor()).thenReturn(exitDoor);
		when(levelFacadeMock.getPlayer()).thenReturn(player);

		LevelTimeAlarm levelTimeAlarm = mock(LevelTimeAlarm.class);
		when(levelTimeAlarm.getCurrentTime()).thenReturn(123);

		LevelManager levelManager = mock(LevelManager.class);
		when(levelManager.getCurrentLevelFacade()).thenReturn(levelFacadeMock);
		when(levelManager.getCurrentLevelKeys()).thenReturn(0);
		when(levelManager.getTimeAlarm()).thenReturn(levelTimeAlarm);

		levelProgressionController.addObserver(levelCompletedObserver);

		levelProgressionController.handler(levelManager);

		verify(levelTimeAlarm, times(1)).getCurrentTime();
		verify(levelManager, times(1)).nextLevel();
		verify(levelManager, times(2)).getCurrentLevelKeys();


		verify(levelCompletedObserver, times(1)).updateScore(123);
		verify(levelCompletedObserver, times(1)).updateNumKeys(0);


	}
}
