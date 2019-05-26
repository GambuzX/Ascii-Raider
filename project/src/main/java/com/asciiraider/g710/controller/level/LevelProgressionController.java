package com.asciiraider.g710.controller.level;

import com.asciiraider.g710.controller.EventSubject;
import com.asciiraider.g710.controller.LevelCompletedObserver;
import com.asciiraider.g710.model.level.LevelManager;
import com.asciiraider.g710.model.utilities.Position;

import java.util.ArrayList;
import java.util.List;

public class LevelProgressionController implements EventSubject<LevelCompletedObserver> {
	private List<LevelCompletedObserver> levelCompletedObservers = new ArrayList<>();
	private int userScore;
	private int numKeys;


	@Override
	public void addObserver(LevelCompletedObserver observer) {
		levelCompletedObservers.add(observer);
	}

	@Override
	public void removeObserver(LevelCompletedObserver observer) {
		levelCompletedObservers.remove(observer);

	}

	@Override
	public void notifyObservers() {
		for(LevelCompletedObserver levelCompletedObserver : levelCompletedObservers) {
			levelCompletedObserver.updateScore(userScore);
			levelCompletedObserver.updateNumKeys(numKeys);
		}
	}

	public boolean handle(LevelManager levelManager) {
		boolean ret = false;
		LevelFacade levelFacade = levelManager.getCurrentLevelFacade();
		Position aboveDoor = levelFacade.getExitDoor().getPosition().getAbove();
		if(levelFacade.getPlayer().getPosition().equals(aboveDoor) && levelManager.getCurrentLevelKeys() == 0) {
			userScore = levelManager.getTimeAlarm().getCurrentTime();
			ret = levelManager.nextLevel();
			numKeys = levelManager.getCurrentLevelKeys();
			notifyObservers();
		}
		return ret;
	}
}
