package com.asciiraider.g710.controller.gameover;

import com.asciiraider.g710.controller.command.RestartCommand;
import com.asciiraider.g710.model.gameover.GameOverModel;
import com.asciiraider.g710.model.utilities.Button;
import com.asciiraider.g710.view.event.Event;
import org.junit.Before;
import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class GameOverControllerTest {
	private GameOverController gameOverController;
	private GameOverModel gameOverModelMock;

	@Before
	public void setUp(){
		gameOverModelMock = mock(GameOverModel.class);

		gameOverController = new GameOverController(gameOverModelMock);
	}

	@Test
	public void constructor(){
		assertFalse(gameOverController.isClose());
	}

	@Test
	public void handleKeyPress1(){
		gameOverController.handleKeyPress(null);
		assertFalse(gameOverController.isClose());
	}

	@Test
	public void handleKeyPress2(){
		gameOverController.handleKeyPress(Event.EOF);
		doThrow(new IllegalArgumentException()).when(gameOverModelMock).getRestartButton();
		assertTrue(gameOverController.isClose());
	}

	@Test
	public void handleKeyPress3(){

		final int[] counter = new int[1];

		Answer<Boolean> answer = new Answer<Boolean>() {
			@Override
			public Boolean answer(InvocationOnMock invocation) throws Throwable {
				counter[0]++;
				return true;
			}
		};

		RestartCommand restartCommand = mock(RestartCommand.class);
		doAnswer(answer).when(restartCommand).execute();

		Button buttonMock = mock(Button.class);
		when(buttonMock.getAction()).thenReturn(restartCommand);

		when(gameOverModelMock.getRestartButton()).thenReturn(buttonMock);

		gameOverController.handleKeyPress(Event.ENTER_KEY);

		assertEquals(1, counter[0]);
		assertTrue(gameOverController.isClose());
	}

	@Test
	public void handleKeyPress4(){

		final int[] counter = new int[1];

		Answer<Boolean> answer = new Answer<Boolean>() {
			@Override
			public Boolean answer(InvocationOnMock invocation) throws Throwable {
				counter[0]++;
				return true;
			}
		};

		RestartCommand restartCommand = mock(RestartCommand.class);
		doAnswer(answer).when(restartCommand).execute();

		Button buttonMock = mock(Button.class);
		when(buttonMock.getAction()).thenReturn(restartCommand);

		when(gameOverModelMock.getRestartButton()).thenReturn(buttonMock);

		gameOverController.handleKeyPress(Event.Q_KEY);

		assertEquals(1, counter[0]);
		assertTrue(gameOverController.isClose());
	}


}
