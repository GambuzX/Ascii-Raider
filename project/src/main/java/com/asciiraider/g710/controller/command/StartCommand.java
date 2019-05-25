package com.asciiraider.g710.controller.command;

import com.asciiraider.g710.controller.Game;
import com.asciiraider.g710.controller.state.GameOverState;
import com.asciiraider.g710.controller.state.PlayState;
import com.googlecode.lanterna.screen.TerminalScreen;

import java.io.IOException;

public class StartCommand extends ButtonCommand {
	public StartCommand(Game game) {
		super(game);
	}

	// TODO: refactor aqui
	@Override
	public void execute() {
		try {
			game.changeState(new PlayState(20, 3, (TerminalScreen) game.getState().getStateView().getScreen(), game));
		} catch (IOException e) {
			e.printStackTrace();
			game.changeState(new GameOverState());
		}
		Thread t = new Thread(game.getState());
		t.start();
	}
}
