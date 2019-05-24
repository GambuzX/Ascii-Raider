package com.asciiraider.g710.controller.state;

import com.asciiraider.g710.controller.level.LevelControllerGroup;
import com.asciiraider.g710.model.level.LevelModelGroup;
import com.asciiraider.g710.view.lanterna.LanternaView;

import java.io.IOException;

public class GameState implements State {
	private LevelControllerGroup levelControllerGroup;
	private LevelModelGroup levelModelGroup;
	private LanternaView lanternaView;

	public GameState(int fps, int hp) throws IOException {
		levelModelGroup = new LevelModelGroup(fps, hp);
		levelControllerGroup = new LevelControllerGroup(levelModelGroup);

		int level_width = levelModelGroup.getLevelManager().getCurrentLevelFacade().getWidth();
		int level_height = levelModelGroup.getLevelManager().getCurrentLevelFacade().getHeight();

		lanternaView = new LanternaView(level_width, level_height);
	}

	@Override
	public LevelModelGroup getStateModel() {
		return this.levelModelGroup;
	}

	@Override
	public LanternaView getStateView() {
		return this.lanternaView;
	}

	@Override
	public LevelControllerGroup getStateController() {
		return this.levelControllerGroup;
	}
}
