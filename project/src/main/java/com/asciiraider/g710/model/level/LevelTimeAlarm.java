package com.asciiraider.g710.model.level;

import com.asciiraider.g710.controller.LevelCompletedObserver;
import com.asciiraider.g710.controller.PlayerDeathObserver;
import com.asciiraider.g710.model.utilities.TimeAlarm;

import java.security.InvalidParameterException;

public class LevelTimeAlarm extends TimeAlarm implements PlayerDeathObserver, LevelCompletedObserver {
	public LevelTimeAlarm(int time) throws InvalidParameterException {
		super(time);
	}

	@Override
	public void updateDeath() {
		resetTimer();
		start();
	}

	@Override
	public void updatePontuation(int pontuation) {
		start();
	}

	@Override
	public void updateNumKeys(int numKeys) {

	}
}
