package com.asciiraider.g710.model.life;

import com.asciiraider.g710.controller.observer.PlayerDeathObserver;

import java.security.InvalidParameterException;

public class LifeManager implements PlayerDeathObserver {
	private int currentLife;
	private int initialLife;

	public LifeManager(int numberLife) throws InvalidParameterException {
		if(numberLife <= 0)
			throw new InvalidParameterException("Number of life must be higher than 0");
		this.currentLife = numberLife;
		this.initialLife = numberLife;
	}


	public int getCurrentLife() {
		return currentLife;
	}

	public int getInitialLife() {
		return initialLife;
	}

	public boolean hasLifes(){
		return getCurrentLife() > 0;
	}

	@Override
	public void updateDeath() {
		currentLife--;
	}
}
