package com.asciiraider.g710.controller.level;

import com.asciiraider.g710.controller.infobar.InfoBarController;
import com.asciiraider.g710.model.element.Player;
import com.asciiraider.g710.model.infobar.InfoBarModel;
import com.asciiraider.g710.model.level.LevelManager;
import com.asciiraider.g710.model.level.LevelModelGroup;
import com.asciiraider.g710.model.utilities.Position;
import com.asciiraider.g710.view.Event;
import org.junit.Before;
import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.*;

public class LevelControllerGroupTest {
	private LevelControllerGroup levelControllerGroup;
	private LevelManager levelManager;
	private LevelModelGroup levelModelGroup;

	@Before
	public void setUp(){
		levelManager = mock(LevelManager.class);
		InfoBarModel infoBarModel = mock(InfoBarModel.class);

		levelModelGroup = mock(LevelModelGroup.class);
		when(levelModelGroup.getLevelManager()).thenReturn(levelManager);
		when(levelModelGroup.getInfoBarModel()).thenReturn(infoBarModel);

		levelControllerGroup = new LevelControllerGroup(levelModelGroup);
	}

	@Test
	public void getLevelController(){
		assertTrue(levelControllerGroup.getLevelController() instanceof LevelController);
		assertTrue(levelControllerGroup.getLevelController() != null);
	}


	@Test
	public void getInfoBarController(){
		assertTrue(levelControllerGroup.getInfoBarController() instanceof InfoBarController);
		assertTrue(levelControllerGroup.getInfoBarController() != null);
	}

	@Test
	public void isClose(){
		when(levelManager.isGameFinished()).thenReturn(false);

		when(levelModelGroup.getLevelManager()).thenReturn(levelManager);

		levelControllerGroup = new LevelControllerGroup(levelModelGroup);

		assertFalse(levelControllerGroup.isClose());
	}

	@Test
	public void handler1(){
		levelControllerGroup.handleKeyPress(null);
		verify(levelModelGroup, times(1)).getLevelManager();
	}

	@Test
	public void handler2(){
		final int[] counter = new int[1];

		Answer<LevelProgressionController> answer = new Answer<LevelProgressionController>() {
			@Override
			public LevelProgressionController answer(InvocationOnMock invocation) throws Throwable {
				counter[0]++;
				return mock(LevelProgressionController.class);
			}
		};

		Position position = mock(Position.class);

		Player player = mock(Player.class);
		when(player.moveUp()).thenReturn(position);

		LevelFacade levelFacadeMock = mock(LevelFacade.class);
		when(levelFacadeMock.getPlayer()).thenReturn(player);

		when(levelManager.getCurrentLevelFacade()).thenReturn(levelFacadeMock);


		LevelControllerGroup controllerGroup = spy(new LevelControllerGroup(levelModelGroup));

		LevelController levelControllerMock = mock(LevelController.class);
		when(levelControllerMock.movePlayer(position, position, levelFacadeMock)).thenReturn(false);
		doAnswer(answer).when(levelControllerMock).getLevelProgressionController();

		when(controllerGroup.getLevelController()).thenReturn(levelControllerMock);

		controllerGroup.handleKeyPress(Event.UP_KEY);

		verify(player, times(1)).moveUp();
		assertEquals(1, counter[0]);
	}

	@Test
	public void handler3(){

		Position belowPos = mock(Position.class);
		Position position = mock(Position.class);
		when(position.getBelow()).thenReturn(belowPos);

		Player player = mock(Player.class);
		when(player.moveDown()).thenReturn(position);

		LevelFacade levelFacadeMock = mock(LevelFacade.class);
		when(levelFacadeMock.getPlayer()).thenReturn(player);

		when(levelManager.getCurrentLevelFacade()).thenReturn(levelFacadeMock);

		LevelProgressionController levelProgressionController = mock(LevelProgressionController.class);

		LevelController levelControllerMock = mock(LevelController.class);
		when(levelControllerMock.movePlayer(position, belowPos, levelFacadeMock)).thenReturn(true);
		when(levelControllerMock.getLevelProgressionController()).thenReturn(levelProgressionController);



		levelModelGroup = mock(LevelModelGroup.class);

		when(levelModelGroup.getLevelManager()).thenReturn(levelManager);

		LevelControllerGroup controllerGroup = spy(new LevelControllerGroup(levelModelGroup));


		when(controllerGroup.getLevelController()).thenReturn(levelControllerMock);

		controllerGroup.handleKeyPress(Event.DOWN_KEY);

		verify(levelProgressionController, times(1)).handler(levelManager);
		verify(player, times(1)).moveDown();
		verify(position, times(1)).getBelow();
		verify(levelFacadeMock, times(1)).setElementPosition(player, position);
		verify(levelControllerMock, times(1)).handleLevelKey();



	}

	@Test(expected = IllegalArgumentException.class)
	public void handler4(){
		Position position = mock(Position.class);

		Player player = mock(Player.class);
		when(player.moveRight()).thenReturn(position);

		LevelFacade levelFacadeMock = mock(LevelFacade.class);
		when(levelFacadeMock.getPlayer()).thenReturn(player);

		when(levelManager.getCurrentLevelFacade()).thenReturn(levelFacadeMock);

		LevelControllerGroup controllerGroup = spy(new LevelControllerGroup(levelModelGroup));

		doThrow(new IllegalArgumentException()).when(controllerGroup).getLevelController();

		controllerGroup.handleKeyPress(Event.RIGHT_KEY);

		verify(player, times(1)).moveRight();
		verify(position, times(1)).getRightSide();
	}

	@Test
	public void handler5(){
		final int[] counter = new int[1];

		Answer<LevelProgressionController> answer = new Answer<LevelProgressionController>() {
			@Override
			public LevelProgressionController answer(InvocationOnMock invocation) throws Throwable {
				counter[0]++;
				return mock(LevelProgressionController.class);
			}
		};

		Position position = mock(Position.class);
		when(position.getX()).thenReturn(0);

		Player player = mock(Player.class);
		when(player.moveLeft()).thenReturn(position);

		LevelFacade levelFacadeMock = mock(LevelFacade.class);
		when(levelFacadeMock.getPlayer()).thenReturn(player);

		when(levelManager.getCurrentLevelFacade()).thenReturn(levelFacadeMock);

		LevelControllerGroup controllerGroup = spy(new LevelControllerGroup(levelModelGroup));

		LevelController levelControllerMock = mock(LevelController.class);



		when(levelControllerMock.movePlayer(position, position, levelFacadeMock)).thenReturn(false);
		doAnswer(answer).when(levelControllerMock).getLevelProgressionController();

		when(controllerGroup.getLevelController()).thenReturn(levelControllerMock);

		controllerGroup.handleKeyPress(Event.LEFT_KEY);

		verify(player, times(1)).moveLeft();
		verify(position, never()).getLeftSide();
		assertEquals(1, counter[0]);
	}

	@Test
	public void handler6(){
		final int[] counter = new int[1];

		Answer<LevelProgressionController> answer = new Answer<LevelProgressionController>() {
			@Override
			public LevelProgressionController answer(InvocationOnMock invocation) throws Throwable {
				counter[0]++;
				return mock(LevelProgressionController.class);
			}
		};

		Position position = mock(Position.class);
		when(position.getX()).thenReturn(1);

		Player player = mock(Player.class);
		when(player.moveLeft()).thenReturn(position);

		LevelFacade levelFacadeMock = mock(LevelFacade.class);
		when(levelFacadeMock.getPlayer()).thenReturn(player);

		when(levelManager.getCurrentLevelFacade()).thenReturn(levelFacadeMock);

		LevelControllerGroup controllerGroup = spy(new LevelControllerGroup(levelModelGroup));

		LevelController levelControllerMock = mock(LevelController.class);



		when(levelControllerMock.movePlayer(position, position, levelFacadeMock)).thenReturn(false);
		doAnswer(answer).when(levelControllerMock).getLevelProgressionController();

		when(controllerGroup.getLevelController()).thenReturn(levelControllerMock);

		controllerGroup.handleKeyPress(Event.LEFT_KEY);

		verify(player, times(1)).moveLeft();
		verify(position, times(1)).getLeftSide();
		assertEquals(1, counter[0]);
	}

	@Test
	public void handler7(){
		Player player = mock(Player.class);

		LevelFacade levelFacadeMock = mock(LevelFacade.class);
		when(levelFacadeMock.getPlayer()).thenReturn(player);

		when(levelManager.getCurrentLevelFacade()).thenReturn(levelFacadeMock);

		LevelControllerGroup controllerGroup = spy(new LevelControllerGroup(levelModelGroup));

		final int[] counter = new int[1];

		Answer<Boolean> answer = new Answer<Boolean>() {
			@Override
			public Boolean answer(InvocationOnMock invocation) throws Throwable {
				counter[0]++;
				return true;
			}
		};

		LifeController lifeControllerMock = mock(LifeController.class);
		doAnswer(answer).when(lifeControllerMock).notifyObservers();

		LevelController levelControllerMock = mock(LevelController.class);
		when(levelControllerMock.getLifeController()).thenReturn(lifeControllerMock);

		doReturn(levelControllerMock).when(controllerGroup).getLevelController();

		controllerGroup.handleKeyPress(Event.R_KEY);

		assertEquals(1, counter[0]);
	}

	@Test
	public void handler8(){
		Player player = mock(Player.class);

		LevelFacade levelFacadeMock = mock(LevelFacade.class);
		when(levelFacadeMock.getPlayer()).thenReturn(player);

		when(levelManager.getCurrentLevelFacade()).thenReturn(levelFacadeMock);
		LevelControllerGroup controllerGroup = spy(new LevelControllerGroup(levelModelGroup));

		controllerGroup.handleKeyPress(Event.Q_KEY);

		verify(levelManager, times(1)).finishGame();
	}

	@Test
	public void handler9(){
		Player player = mock(Player.class);

		LevelFacade levelFacadeMock = mock(LevelFacade.class);
		when(levelFacadeMock.getPlayer()).thenReturn(player);

		when(levelManager.getCurrentLevelFacade()).thenReturn(levelFacadeMock);
		LevelControllerGroup controllerGroup = spy(new LevelControllerGroup(levelModelGroup));

		controllerGroup.handleKeyPress(Event.EOF);

		verify(levelManager, times(1)).finishGame();
	}

}
