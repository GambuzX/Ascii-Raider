package com.asciiraider.g710.model.level;

import com.asciiraider.g710.controller.level.LevelFacade;

import java.util.List;

// TODO: continuar a testar
public class LevelManager {

	private LevelBuilder lvlBuilder;
	private List<LevelModel> levelModels;
	private int currentLevelIndex;
	private boolean gameFinished;
	private LevelFacade currentLevelFacade;
	private int currentLevelKeys;

	private int fps;

	public LevelManager(int fps) {
		this.fps = fps;

		currentLevelIndex = 2;
		gameFinished = false;
		lvlBuilder = new LevelBuilder();
		levelModels = lvlBuilder.getLevels();
		updateLevelVariables();
	}

	public void resetLevels() {
		currentLevelIndex = 0;
		levelModels = lvlBuilder.getLevels();
		updateLevelVariables();
	}

	public void resetLevel(int levelIndex) {
		levelModels.set(levelIndex, lvlBuilder.getLevel(levelIndex));
		updateLevelVariables();
	}

	public void nextLevel() {
		currentLevelIndex++;
		updateLevelVariables();
		if (currentLevelIndex >= levelModels.size()) {
			gameFinished = true;
		}
	}

	private void updateLevelVariables() {
		currentLevelFacade = new LevelFacade(getCurrentLevel());
		currentLevelKeys = currentLevelFacade.getLevelKeys().size();
	}

	public int getCurrentLevelKeys() {
		return currentLevelKeys;
	}

	public void decreaseLevelKeyCount() {
		currentLevelKeys--;
	}

	public int getCurrentLevelIndex() {
		return currentLevelIndex;
	}

	public LevelModel getCurrentLevel() {
		return levelModels.get(currentLevelIndex % levelModels.size());
	}

	public LevelFacade getCurrentLevelFacade() {
		return currentLevelFacade;
	}

	public boolean isGameFinished() {
		return gameFinished;
	}

	public void finishGame() {
		gameFinished = true;
	}

	public boolean wonGame() {
		return currentLevelIndex >= levelModels.size();
	}


	public int getFps() {
		return fps;
	}
}
