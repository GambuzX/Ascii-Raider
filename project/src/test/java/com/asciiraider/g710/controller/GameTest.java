package com.asciiraider.g710.controller;

import com.asciiraider.g710.controller.state.MenuState;
import com.asciiraider.g710.controller.state.PlayState;
import com.asciiraider.g710.view.ViewFactory;
import com.asciiraider.g710.view.lanterna.LanternaStateView;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;
import static org.mockito.Mockito.*;

public class GameTest {
	private Game game;
	private ViewFactory viewFactoryMock;

	@Before
	public void setUp(){
		viewFactoryMock = mock(ViewFactory.class);
		game = new Game(viewFactoryMock);
	}

	@Test
	public void constructor(){
		assertTrue(game.getState() instanceof MenuState);
	}

	@Test
	public void constructor2(){
		assertFalse(game.toExit());
	}

	@Test
	public void changeState(){
		PlayState state = mock(PlayState.class);
		game.changeState(state);

		assertTrue(game.getState() instanceof PlayState);
	}

	@Test
	public void getFactory(){
		assertTrue(game.getViewFactory() instanceof ViewFactory);
	}

	@Test
	public void exit(){
		LanternaStateView lsvMock = mock(LanternaStateView.class);

		PlayState state = mock(PlayState.class);
		when(state.getStateView()).thenReturn(lsvMock);
		game.changeState(state);

		game.exit();

		verify(lsvMock, times(1)).exit();
		assertTrue(game.toExit());
	}
}
