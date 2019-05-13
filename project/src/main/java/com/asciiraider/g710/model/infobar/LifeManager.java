package com.asciiraider.g710.model.infobar;

import com.asciiraider.g710.controller.PlayerObserver;

import java.security.InvalidParameterException;

public class LifeManager implements PlayerObserver {
	private int numberLife;


	public LifeManager(int numberLife) throws InvalidParameterException {
		if(numberLife <= 0)
			throw new InvalidParameterException("Number of life must be higher than 0");
		this.numberLife = numberLife;
	}


	public int getNumberLife() {
		return numberLife;
	}

	public boolean hasLifes(){
		return numberLife > 0;
	}

	@Override
	public void update() {
		numberLife--;
	}
}
