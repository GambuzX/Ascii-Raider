package com.asciiraider.g710.model.level;

import java.util.List;

// TODO: continuar a testar
public class LevelManager {

	private LevelBuilder lvlBuilder;
	private List<LevelModel> levelModels;
	private int currentLevelIndex;
	private boolean finishedGame;

	public LevelManager() {
		currentLevelIndex = 0;
		finishedGame = false;
		lvlBuilder = new LevelBuilder();
		levelModels = lvlBuilder.buildAllLevels();
	}

	public void resetLevel() {
		currentLevelIndex = 0;
		levelModels = lvlBuilder.buildAllLevels();
	}

	public void nextLevel() {
		currentLevelIndex++;
		if (currentLevelIndex >= levelModels.size()) finishedGame = true;
	}

	public int getCurrentLevelIndex() {
		return currentLevelIndex;
	}

	public LevelModel getCurrentLevel() {
		return levelModels.get(currentLevelIndex % levelModels.size());
	}

	public boolean isGameFinished() {
		return finishedGame;
	}


}
