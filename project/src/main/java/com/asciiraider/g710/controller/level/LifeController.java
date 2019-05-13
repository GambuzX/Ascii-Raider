package com.asciiraider.g710.controller.level;

import com.asciiraider.g710.controller.EventSubject;
import com.asciiraider.g710.controller.PlayerObserver;

import java.util.ArrayList;
import java.util.List;

public class LifeController implements EventSubject<PlayerObserver> {
	private List<PlayerObserver> playerObservers = new ArrayList<>();

	@Override
	public void addObserver(PlayerObserver observer) {
		playerObservers.add(observer);
	}

	@Override
	public void removeObserver(PlayerObserver observer) {
		playerObservers.remove(observer);

	}

	@Override
	public void notifyObservers() {
		for(PlayerObserver playerObserver : playerObservers)
			playerObserver.update();
	}
}
