package com.asciiraider.g710.controller.command;

import com.asciiraider.g710.controller.Game;

public class ExitCommand extends ButtonCommand {
	public ExitCommand(Game game) {
		super(game);
	}

	@Override
	public void execute() {
		game.exit();
	}
}
