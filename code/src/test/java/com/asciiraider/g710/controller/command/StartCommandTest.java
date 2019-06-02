package com.asciiraider.g710.controller.command;

import com.asciiraider.g710.controller.Game;
import com.asciiraider.g710.controller.state.PlayState;
import com.asciiraider.g710.view.ViewFactory;
import com.asciiraider.g710.view.lanterna.game.LanternaLevelGroupView;
import org.junit.Test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class StartCommandTest {
	@Test
	public void test1(){
		LanternaLevelGroupView mockLLGV = mock(LanternaLevelGroupView.class);
		ViewFactory mockViewFactory = mock(ViewFactory.class);
		when(mockViewFactory.createLevelView()).thenReturn(mockLLGV);
		Game game = mock(Game.class);
		when(game.getViewFactory()).thenReturn(mockViewFactory);
		StartCommand startCommand = new StartCommand(game);
		startCommand.execute();
		verify(game, times(1)).changeState(any(PlayState.class));
	}
}
