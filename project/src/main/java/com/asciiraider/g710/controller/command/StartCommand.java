package com.asciiraider.g710.controller.command;

import com.asciiraider.g710.controller.Game;
import com.asciiraider.g710.controller.state.PlayState;
import com.asciiraider.g710.model.level.LevelModelGroup;

public class StartCommand extends ButtonCommand {
	public StartCommand(Game game) {
		super(game);
	}

	@Override
	public void execute() {
		game.changeState(new PlayState(game, new LevelModelGroup()));
	}
}
