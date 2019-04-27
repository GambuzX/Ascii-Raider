package com.asciiraider.g710.model.level;

import java.util.List;

// TODO: continuar a testar
public class LevelManager {

	private static LevelManager instance;
	private LevelBuilder lvlBuilder;
	private List<Level> levels;
	private int currentLevelIndex;
	private boolean finishedGame;

	public static LevelManager getInstance() {
		if (instance == null) {
			instance = new LevelManager();
		}
		return instance;
	}

	public void resetLevel() {
		currentLevelIndex = 0;
	}

	public void nextLevel() {
		if (currentLevelIndex >= levels.size()) finishedGame = true;
		currentLevelIndex++;
	}

	public int getCurrentLevelIndex() {
		return currentLevelIndex;
	}

	public Level getCurrentLevel() {
		return levels.get(currentLevelIndex % levels.size());
	}

	public boolean isGameFinished() {
		return finishedGame;
	}

	private LevelManager() {
		currentLevelIndex = 0;
		finishedGame = false;
		lvlBuilder = new LevelBuilder();
		levels = lvlBuilder.buildAllLevels();
	}

}
