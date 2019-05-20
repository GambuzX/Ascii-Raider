package com.asciiraider.g710.model.utilities;

import com.asciiraider.g710.controller.LevelCompletedObserver;

import java.security.InvalidParameterException;

public class User implements LevelCompletedObserver {
	private String name;
	private int score;

	public User(){
		this.name = "";
		this.score = 0;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) throws InvalidParameterException {
		if(score < 0)
			throw new InvalidParameterException("Score can't be negative");
		this.score = score;
	}

	public void addScore(int score){
		this.score += score;
	}


	@Override
	public void updateNextLevel(int pontuation) {
		addScore(pontuation);
	}
}
