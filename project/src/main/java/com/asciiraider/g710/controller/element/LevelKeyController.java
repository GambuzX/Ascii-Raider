package com.asciiraider.g710.controller.element;

import com.asciiraider.g710.controller.EventSubject;
import com.asciiraider.g710.controller.LevelKeyObserver;
import com.asciiraider.g710.controller.level.LevelFacade;
import com.asciiraider.g710.model.utilities.Position;

import java.util.ArrayList;
import java.util.List;

public class LevelKeyController implements EventSubject<LevelKeyObserver> {
	private List<LevelKeyObserver> levelKeyObservers = new ArrayList<>();


	public void handler(LevelFacade levelFacade){
		Position aboveDoor = levelFacade.getExitDoor().getPosition().getAbove();
		if(levelFacade.removeLevelKey(aboveDoor))
			this.notifyObservers();
	}

	@Override
	public void addObserver(LevelKeyObserver observer) {
		levelKeyObservers.add(observer);
	}

	@Override
	public void removeObserver(LevelKeyObserver observer) {
		levelKeyObservers.remove(observer);
	}

	@Override
	public void notifyObservers() {
		for(LevelKeyObserver levelKeyObserver : levelKeyObservers)
			levelKeyObserver.updateLevelKey();
	}
}
