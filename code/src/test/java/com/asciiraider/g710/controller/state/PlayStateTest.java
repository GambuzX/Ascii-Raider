package com.asciiraider.g710.controller.state;

import com.asciiraider.g710.controller.Game;
import com.asciiraider.g710.controller.infobar.InfoBarController;
import com.asciiraider.g710.controller.level.LevelController;
import com.asciiraider.g710.controller.level.LevelControllerGroup;
import com.asciiraider.g710.controller.life.LifeController;
import com.asciiraider.g710.model.infobar.InfoBarModel;
import com.asciiraider.g710.model.level.LevelManager;
import com.asciiraider.g710.model.level.LevelModelGroup;
import com.asciiraider.g710.model.level.LevelTimeAlarm;
import com.asciiraider.g710.view.ViewFactory;
import com.asciiraider.g710.view.lanterna.game.LanternaLevelGroupView;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import static junit.framework.TestCase.assertTrue;
import static org.mockito.Mockito.*;

public class PlayStateTest {
	private Game game;
	private PlayState playState;
	private ViewFactory viewFactory;
	private LevelModelGroup levelModelGroup;

	@Before
	public void setUp(){
		LanternaLevelGroupView lanternaLevelGroupView = mock(LanternaLevelGroupView.class);

		viewFactory = mock(ViewFactory.class);
		when(viewFactory.createLevelView()).thenReturn(lanternaLevelGroupView);

		game = mock(Game.class);
		when(game.getViewFactory()).thenReturn(viewFactory);

		LevelManager levelManager = mock(LevelManager.class);

		levelModelGroup = mock(LevelModelGroup.class);
		when(levelModelGroup.getLevelManager()).thenReturn(levelManager);

		playState = new PlayState(game, levelModelGroup);
	}

	@Test
	public void getStateModel(){
		assertTrue(playState.getStateModel() instanceof LevelModelGroup);
	}

	@Test
	public void getStateController(){
		assertTrue(playState.getStateController() instanceof LevelControllerGroup);
	}

	@Test
	public void getStateView(){
		assertTrue(playState.getStateView() instanceof LanternaLevelGroupView);
	}


	@Test
	public void run1(){
		LanternaLevelGroupView lanternaLevelGroupView = mock(LanternaLevelGroupView.class);

		viewFactory = mock(ViewFactory.class);
		when(viewFactory.createLevelView()).thenReturn(lanternaLevelGroupView);

		game = mock(Game.class);
		when(game.getViewFactory()).thenReturn(viewFactory);
		ArgumentCaptor<State> argument = ArgumentCaptor.forClass(State.class);

		LevelManager levelManager = mock(LevelManager.class);
		when(levelManager.isGameFinished()).thenReturn(false, true);

		InfoBarModel infoBarModel = mock(InfoBarModel.class);

		levelModelGroup = mock(LevelModelGroup.class);
		when(levelModelGroup.getLevelManager()).thenReturn(levelManager);
		when(levelModelGroup.getInfoBarModel()).thenReturn(infoBarModel);

		PlayState playStateSpy = spy(new PlayState(game, levelModelGroup));

		LevelController myController = mock(LevelController.class);
		when(myController.isPlayerCollidingEnemy()).thenReturn(false);

		LevelControllerGroup myGroupController = mock(LevelControllerGroup.class);
		when(myGroupController.getLevelController()).thenReturn(myController);

		when(playStateSpy.getStateController()).thenReturn(myGroupController);


		playStateSpy.run();


		verify(game, times(1)).changeState(argument.capture());

		verify(myController, times(1)).handlePhysics();
		verify(myController, times(1)).handleEnemies();
		verify(myController, times(1)).handleAnimations();
		verify(myController, times(1)).handleLevelKey();
		verify(myController, never()).getLifeController();
		verify(lanternaLevelGroupView, times(1)).draw(levelModelGroup);

		assertTrue(argument.getValue() instanceof GameOverState);
	}

	@Test
	public void run2(){
		LanternaLevelGroupView lanternaLevelGroupView = mock(LanternaLevelGroupView.class);

		viewFactory = mock(ViewFactory.class);
		when(viewFactory.createLevelView()).thenReturn(lanternaLevelGroupView);

		game = mock(Game.class);
		when(game.getViewFactory()).thenReturn(viewFactory);
		when(game.toExit()).thenReturn(true);
		ArgumentCaptor<State> argument = ArgumentCaptor.forClass(State.class);

		LevelManager levelManager = mock(LevelManager.class);
		when(levelManager.isGameFinished()).thenReturn(false, true);

		InfoBarModel infoBarModel = mock(InfoBarModel.class);

		levelModelGroup = mock(LevelModelGroup.class);
		when(levelModelGroup.getLevelManager()).thenReturn(levelManager);
		when(levelModelGroup.getInfoBarModel()).thenReturn(infoBarModel);

		PlayState playStateSpy = spy(new PlayState(game, levelModelGroup));

		LifeController lifeController = mock(LifeController.class);

		LevelController myController = mock(LevelController.class);
		when(myController.isPlayerCollidingEnemy()).thenReturn(true);
		when(myController.getLifeController()).thenReturn(lifeController);

		LevelControllerGroup myGroupController = mock(LevelControllerGroup.class);
		when(myGroupController.getLevelController()).thenReturn(myController);

		when(playStateSpy.getStateController()).thenReturn(myGroupController);


		playStateSpy.run();


		verify(game, times(1)).changeState(argument.capture());
		verify(myController, times(1)).getLifeController();
		verify(lifeController, times(1)).notifyObservers();

		verify(myController, times(1)).handlePhysics();
		verify(myController, times(1)).handleEnemies();
		verify(myController, times(1)).handleAnimations();
		verify(myController, times(1)).handleLevelKey();
		verify(lanternaLevelGroupView, times(1)).draw(levelModelGroup);

		assertTrue(argument.getValue() instanceof GameOverState);
	}

	@Test
	public void testClockNotFinish(){
		LanternaLevelGroupView lanternaLevelGroupView = mock(LanternaLevelGroupView.class);

		viewFactory = mock(ViewFactory.class);
		when(viewFactory.createLevelView()).thenReturn(lanternaLevelGroupView);

		game = mock(Game.class);
		when(game.getViewFactory()).thenReturn(viewFactory);




		LevelTimeAlarm levelTimeAlarm = mock(LevelTimeAlarm.class);
		when(levelTimeAlarm.getCurrentTime()).thenReturn(5, 4);

		LevelManager levelManager = mock(LevelManager.class);
		when(levelManager.isGameFinished()).thenReturn(false);
		when(levelManager.getTimeAlarm()).thenReturn(levelTimeAlarm);

		Answer<Boolean> answer = new Answer<Boolean>() {
			@Override
			public Boolean answer(InvocationOnMock invocation) throws Throwable {
				when(levelManager.isGameFinished()).thenReturn(true);
				return true;
			}
		};
		doAnswer(answer).when(game).toExit();


		InfoBarModel infoBarModel = mock(InfoBarModel.class);

		levelModelGroup = mock(LevelModelGroup.class);
		when(levelModelGroup.getLevelManager()).thenReturn(levelManager);
		when(levelModelGroup.getInfoBarModel()).thenReturn(infoBarModel);

		PlayState playStateSpy = spy(new PlayState(game, levelModelGroup));


		LevelController myController = mock(LevelController.class);
		when(myController.isPlayerCollidingEnemy()).thenReturn(false);

		InfoBarController myInfoController = mock(InfoBarController.class);

		LevelControllerGroup myGroupController = mock(LevelControllerGroup.class);
		when(myGroupController.getLevelController()).thenReturn(myController);
		when(myGroupController.getInfoBarController()).thenReturn(myInfoController);

		when(playStateSpy.getStateController()).thenReturn(myGroupController);

		playStateSpy.run();

		verify(myInfoController, times(1)).handler(levelTimeAlarm);
		verify(levelTimeAlarm, times(1)).decTimer();
		verify(myController, never()).getLifeController();
		verify(game, times(2)).toExit();

	}

	@Test
	public void testClockNotFinish2(){
		LanternaLevelGroupView lanternaLevelGroupView = mock(LanternaLevelGroupView.class);

		viewFactory = mock(ViewFactory.class);
		when(viewFactory.createLevelView()).thenReturn(lanternaLevelGroupView);

		game = mock(Game.class);
		when(game.getViewFactory()).thenReturn(viewFactory);

		LevelTimeAlarm levelTimeAlarm = mock(LevelTimeAlarm.class);
		when(levelTimeAlarm.getCurrentTime()).thenReturn(1, 0);

		LevelManager levelManager = mock(LevelManager.class);
		when(levelManager.isGameFinished()).thenReturn(false);
		when(levelManager.getTimeAlarm()).thenReturn(levelTimeAlarm);

		Answer<Boolean> answer = new Answer<Boolean>() {
			@Override
			public Boolean answer(InvocationOnMock invocation) throws Throwable {
				when(levelManager.isGameFinished()).thenReturn(true);
				return false;
			}
		};
		doAnswer(answer).when(game).toExit();


		InfoBarModel infoBarModel = mock(InfoBarModel.class);

		levelModelGroup = mock(LevelModelGroup.class);
		when(levelModelGroup.getLevelManager()).thenReturn(levelManager);
		when(levelModelGroup.getInfoBarModel()).thenReturn(infoBarModel);

		PlayState playStateSpy = spy(new PlayState(game, levelModelGroup));

		LifeController lifeController = mock(LifeController.class);

		LevelController myController = mock(LevelController.class);
		when(myController.isPlayerCollidingEnemy()).thenReturn(false);
		when(myController.getLifeController()).thenReturn(lifeController);

		InfoBarController myInfoController = mock(InfoBarController.class);

		LevelControllerGroup myGroupController = mock(LevelControllerGroup.class);
		when(myGroupController.getLevelController()).thenReturn(myController);
		when(myGroupController.getInfoBarController()).thenReturn(myInfoController);

		when(playStateSpy.getStateController()).thenReturn(myGroupController);

		playStateSpy.run();

		verify(myInfoController, times(1)).handler(levelTimeAlarm);
		verify(levelTimeAlarm, times(1)).decTimer();
		verify(lifeController, times(1)).notifyObservers();
		verify(game, times(2)).toExit();

	}

}
