package com.asciiraider.g710.controller.command;

import com.asciiraider.g710.controller.Game;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class ExitCommandTest {
	@Test
	public void test1(){
		Game game = mock(Game.class);
		ExitCommand exitCommand = new ExitCommand(game);
		exitCommand.execute();
		verify(game, times(1)).exit();
	}

}
