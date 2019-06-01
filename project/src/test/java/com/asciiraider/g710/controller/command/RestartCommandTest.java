package com.asciiraider.g710.controller.command;

import com.asciiraider.g710.controller.Game;
import com.asciiraider.g710.controller.state.MenuState;
import com.asciiraider.g710.view.ViewFactory;
import com.asciiraider.g710.view.lanterna.menu.LanternaMenuView;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class RestartCommandTest {
	@Test
	public void test1(){
		LanternaMenuView mockMenuView = mock(LanternaMenuView.class);
		ViewFactory mockViewFactory = mock(ViewFactory.class);
		when(mockViewFactory.createMenuView()).thenReturn(mockMenuView);
		Game game = mock(Game.class);
		when(game.getViewFactory()).thenReturn(mockViewFactory);
		RestartCommand restartCommand = new RestartCommand(game);
		restartCommand.execute();
		verify(game, times(1)).changeState(any(MenuState.class));
	}
}
