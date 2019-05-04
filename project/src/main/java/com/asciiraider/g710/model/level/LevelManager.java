package com.asciiraider.g710.model.level;

import com.asciiraider.g710.controller.level.LevelFacade;
import com.asciiraider.g710.view.LevelView;

import java.util.List;

// TODO: continuar a testar
public class LevelManager {

	private LevelBuilder lvlBuilder;
	private List<LevelModel> levelModels;
	private int currentLevelIndex;
	private boolean gameFinished;
	private LevelFacade currentLevelFacade;

	public LevelManager() {
		currentLevelIndex = 0;
		gameFinished = false;
		lvlBuilder = new LevelBuilder();
		levelModels = lvlBuilder.getLevels();
		currentLevelFacade = new LevelFacade(getCurrentLevel());
	}

	public void resetLevels() {
		currentLevelIndex = 0;
		levelModels = lvlBuilder.getLevels();
		currentLevelFacade = new LevelFacade(getCurrentLevel());
	}

	public void resetLevel(int levelIndex) {
		levelModels.set(levelIndex, lvlBuilder.getLevel(levelIndex));
		currentLevelFacade = new LevelFacade(getCurrentLevel());
	}

	public void nextLevel() {
		currentLevelIndex++;
		currentLevelFacade = new LevelFacade(getCurrentLevel());
		if (currentLevelIndex >= levelModels.size()) {
			gameFinished = true;
		}
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


}
