package com.asciiraider.g710.controller.level;

import com.asciiraider.g710.controller.EventSubject;
import com.asciiraider.g710.controller.LevelCompletedObserver;
import com.asciiraider.g710.model.level.LevelManager;
import com.asciiraider.g710.model.utilities.Position;

import java.util.ArrayList;
import java.util.List;

public class LevelProgressionController implements EventSubject<LevelCompletedObserver> {
	private List<LevelCompletedObserver> levelCompletedObservers = new ArrayList<>();
	private int userPontuation;


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
		for(LevelCompletedObserver levelCompletedObserver : levelCompletedObservers)
			levelCompletedObserver.updateNextLevel(userPontuation);
	}

	public void handle(LevelManager levelManager) {

		LevelFacade levelFacade = levelManager.getCurrentLevelFacade();
		Position aboveDoor = levelFacade.getExitDoor().getPosition().getAbove();
		if(levelFacade.getPlayer().getPosition().equals(aboveDoor) && levelManager.getCurrentLevelKeys() == 0) {
			userPontuation = levelManager.getTimeAlarm().getCurrentTime();
			levelManager.nextLevel();
			notifyObservers();
		}
	}
}
