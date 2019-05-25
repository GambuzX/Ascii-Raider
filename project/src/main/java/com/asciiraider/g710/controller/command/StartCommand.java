package com.asciiraider.g710.controller.command;

import com.asciiraider.g710.controller.Game;
import com.asciiraider.g710.controller.state.PlayState;

public class StartCommand extends ButtonCommand {
	public StartCommand(Game game) {
		super(game);
	}

	// TODO: refactor aqui
	@Override
	public void execute() {
		game.changeState(new PlayState(game));
		Thread t = new Thread(game.getState());
		t.start();
	}
}
