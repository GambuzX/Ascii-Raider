package com.asciiraider.g710.model.level;

import com.asciiraider.g710.controller.LevelKeyObserver;
import com.asciiraider.g710.controller.PlayerDeathObserver;
import com.asciiraider.g710.controller.level.LevelFacade;
import com.asciiraider.g710.model.infobar.LifeManager;

import java.security.InvalidParameterException;
import java.util.List;

public class LevelManager implements LevelKeyObserver, PlayerDeathObserver {

	private LevelBuilder lvlBuilder;
	private List<LevelModel> levelModels;
	private int currentLevelIndex;
	private boolean gameFinished;
	//private LevelFacade currentLevelFacade;
	private int currentLevelKeys;
	private LifeManager lifeManager;
	private LevelTimeAlarm timeAlarm;

	public LevelManager(LevelBuilder levelBuilder, LifeManager lifeManager) throws InvalidParameterException {
		this.lifeManager = lifeManager;

		currentLevelIndex = 0;
		gameFinished = false;
		lvlBuilder = levelBuilder;
		levelModels = lvlBuilder.buildAllLevels();
		timeAlarm = new LevelTimeAlarm(getCurrentLevel().getLevelTime());
		updateLevelVariables();
		timeAlarm.start();

	}

	public void resetLevels() {
		currentLevelIndex = 0;
		levelModels = lvlBuilder.buildAllLevels();
		updateLevelVariables();
	}

	public void resetLevel(int levelIndex) {
		levelModels.set(levelIndex, lvlBuilder.buildLevel(levelIndex+1));
		updateLevelVariables();
	}

	public void nextLevel() {
		currentLevelIndex++;
		updateLevelVariables();
		if( currentLevelIndex >= levelModels.size())
			gameFinished = true;
	}

	public void restartLevel() {
		this.resetLevel(currentLevelIndex);
	}

	private void updateLevelVariables() {
		currentLevelKeys = getCurrentLevel().getLevelKeys().size();
		timeAlarm.setTimer(getCurrentLevel().getLevelTime());
	}

	public int getCurrentLevelKeys() {
		return currentLevelKeys;
	}

	public int getCurrentLevelIndex() {
		return currentLevelIndex;
	}

	public LevelModel getCurrentLevel() {
		return levelModels.get(currentLevelIndex % levelModels.size());
	}

	public LevelFacade getCurrentLevelFacade() {
		return new LevelFacade(getCurrentLevel());
	}

	public void finishGame() {
		gameFinished = true;
	}

	@Override
	public void updateLevelKey() {
		currentLevelKeys--;
	}

	public LifeManager getLifeManager() {
		return lifeManager;
	}

	public LevelTimeAlarm getTimeAlarm() { return timeAlarm; }

	@Override
	public void updateDeath() {
		restartLevel();
		if(!lifeManager.hasLifes())
			finishGame();
	}

	public boolean isGameFinished() {
		return gameFinished;
	}
}
