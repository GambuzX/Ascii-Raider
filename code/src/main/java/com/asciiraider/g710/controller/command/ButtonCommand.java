package com.asciiraider.g710.controller.command;

import com.asciiraider.g710.controller.Game;

public abstract class ButtonCommand {
	Game game;

	protected ButtonCommand(Game game) {
		this.game = game;
	}


	public abstract void execute();
}
