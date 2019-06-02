package com.asciiraider.g710.controller.state;

import com.asciiraider.g710.controller.Game;
import com.asciiraider.g710.controller.command.ButtonCommand;
import com.asciiraider.g710.controller.command.RestartCommand;
import com.asciiraider.g710.controller.gameover.GameOverController;
import com.asciiraider.g710.model.gameover.GameOverModel;
import com.asciiraider.g710.model.utilities.Button;
import com.asciiraider.g710.model.utilities.TimeAlarm;
import com.asciiraider.g710.view.ViewFactory;
import com.asciiraider.g710.view.lanterna.gameover.LanternaGameOverView;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import static junit.framework.TestCase.assertTrue;
import static org.mockito.Mockito.*;

public class GameOverStateTest {
	private Game game;
	private GameOverState gameOverState;
	private ViewFactory viewFactory;
	private GameOverModel gameOverModel;

	@Before
	public void setUp(){
		LanternaGameOverView lanternaGameOverView = mock(LanternaGameOverView.class);

		viewFactory = mock(ViewFactory.class);
		when(viewFactory.createGameOverView()).thenReturn(lanternaGameOverView);

		game = mock(Game.class);
		when(game.getViewFactory()).thenReturn(viewFactory);


		Button button = mock(Button.class);

		gameOverModel = mock(GameOverModel.class);
		when(gameOverModel.getRestartButton()).thenReturn(button);

		gameOverState = new GameOverState(game, gameOverModel);
	}

	@Test
	public void constructor(){
		Button b1 = mock(Button.class);

		gameOverModel = mock(GameOverModel.class);
		when(gameOverModel.getRestartButton()).thenReturn(b1);

		gameOverState = new GameOverState(game, gameOverModel);

		ArgumentCaptor<ButtonCommand> argument = ArgumentCaptor.forClass(ButtonCommand.class);

		verify(b1, times(1)).setAction(argument.capture());

		assertTrue(argument.getValue() instanceof RestartCommand);
	}

	@Test
	public void getStateModel(){
		assertTrue(gameOverState.getStateModel() instanceof GameOverModel);
	}

	@Test
	public void getStateController(){
		assertTrue(gameOverState.getStateController() instanceof GameOverController);
	}

	@Test
	public void getStateView(){
		assertTrue(gameOverState.getStateView() instanceof LanternaGameOverView);
	}

	@Test
	public void getTimeAlarm(){
		assertTrue(gameOverState.getAlarm() instanceof TimeAlarm);
	}

	@Test
	public void run1(){
		LanternaGameOverView lanternaGameOverView = mock(LanternaGameOverView.class);

		viewFactory = mock(ViewFactory.class);
		when(viewFactory.createGameOverView()).thenReturn(lanternaGameOverView);

		game = mock(Game.class);
		when(game.toExit()).thenReturn(false, false);
		when(game.getViewFactory()).thenReturn(viewFactory);


		Button button = mock(Button.class);

		gameOverModel = mock(GameOverModel.class);
		when(gameOverModel.getRestartButton()).thenReturn(button);


		GameOverState gameOverStateSpy = spy(new GameOverState(game, gameOverModel));

		GameOverController myController = mock(GameOverController.class);
		when(myController.isClose()).thenReturn(false, true);

		when(gameOverStateSpy.getStateController()).thenReturn(myController);

		gameOverStateSpy.run();

		verify(lanternaGameOverView, times(1)).draw(gameOverModel);
	}

	@Test
	public void run2(){
		LanternaGameOverView lanternaGameOverView = mock(LanternaGameOverView.class);

		viewFactory = mock(ViewFactory.class);
		when(viewFactory.createGameOverView()).thenReturn(lanternaGameOverView);

		game = mock(Game.class);
		when(game.toExit()).thenReturn(false, true);
		when(game.getViewFactory()).thenReturn(viewFactory);


		Button button = mock(Button.class);

		gameOverModel = mock(GameOverModel.class);
		when(gameOverModel.getRestartButton()).thenReturn(button);


		GameOverState gameOverStateSpy = spy(new GameOverState(game, gameOverModel));

		GameOverController myController = mock(GameOverController.class);
		when(myController.isClose()).thenReturn(false, false);

		when(gameOverStateSpy.getStateController()).thenReturn(myController);

		gameOverStateSpy.run();

		verify(lanternaGameOverView, times(1)).draw(gameOverModel);
	}

	@Test
	public void run3(){
		LanternaGameOverView lanternaGameOverView = mock(LanternaGameOverView.class);

		viewFactory = mock(ViewFactory.class);
		when(viewFactory.createGameOverView()).thenReturn(lanternaGameOverView);

		game = mock(Game.class);
		when(game.toExit()).thenReturn(true);
		when(game.getViewFactory()).thenReturn(viewFactory);


		Button button = mock(Button.class);

		gameOverModel = mock(GameOverModel.class);
		when(gameOverModel.getRestartButton()).thenReturn(button);


		GameOverState gameOverStateSpy = spy(new GameOverState(game, gameOverModel));

		GameOverController myController = mock(GameOverController.class);
		when(myController.isClose()).thenReturn(true);

		when(gameOverStateSpy.getStateController()).thenReturn(myController);

		gameOverStateSpy.run();

		verify(lanternaGameOverView, never()).draw(gameOverModel);
	}

	@Test
	public void testAlarmClosing(){
		LanternaGameOverView lanternaGameOverView = mock(LanternaGameOverView.class);

		viewFactory = mock(ViewFactory.class);
		when(viewFactory.createGameOverView()).thenReturn(lanternaGameOverView);

		game = mock(Game.class);
		when(game.toExit()).thenReturn(false);
		when(game.getViewFactory()).thenReturn(viewFactory);


		Button button = mock(Button.class);

		gameOverModel = mock(GameOverModel.class);
		when(gameOverModel.getRestartButton()).thenReturn(button);


		GameOverState gameOverStateSpy = spy(new GameOverState(game, gameOverModel));

		GameOverController myController = mock(GameOverController.class);
		when(myController.isClose()).thenReturn(false);

		when(gameOverStateSpy.getStateController()).thenReturn(myController);

		TimeAlarm myAlarm = mock(TimeAlarm.class);
		when(myAlarm.getCurrentTime()).thenReturn(1, 0);


		Answer<Boolean> answer = new Answer<Boolean>() {
			@Override
			public Boolean answer(InvocationOnMock invocation) throws Throwable {
				when(game.toExit()).thenReturn(true);
				return true;
			}
		};

		doAnswer(answer).when(game).exit();

		when(gameOverStateSpy.getAlarm()).thenReturn(myAlarm);

		gameOverStateSpy.run();

		verify(myAlarm, times(1)).start();
		verify(myAlarm, times(1)).decTimer();
		verify(game, times(1)).exit();
	}
}
