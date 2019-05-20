package com.asciiraider.g710.controller.level;

import com.asciiraider.g710.controller.EventSubject;
import com.asciiraider.g710.controller.PlayerDeathObserver;

import java.util.ArrayList;
import java.util.List;

public class LifeController implements EventSubject<PlayerDeathObserver> {
	private List<PlayerDeathObserver> playerDeathObservers = new ArrayList<>();

	@Override
	public void addObserver(PlayerDeathObserver observer) {
		playerDeathObservers.add(observer);
	}

	@Override
	public void removeObserver(PlayerDeathObserver observer) {
		playerDeathObservers.remove(observer);

	}

	@Override
	public void notifyObservers() {
		for(PlayerDeathObserver playerDeathObserver : playerDeathObservers)
			playerDeathObserver.updateDeath();
	}
}
