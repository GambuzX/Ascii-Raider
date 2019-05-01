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
		levelModels = lvlBuilder.getLevels();
	}

	public void resetLevels() {
		currentLevelIndex = 0;
		levelModels = lvlBuilder.getLevels();
	}

	public void resetLevel(int levelIndex) {
		levelModels.set(levelIndex, lvlBuilder.getLevel(levelIndex));
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
