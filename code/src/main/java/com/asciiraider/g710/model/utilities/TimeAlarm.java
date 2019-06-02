package com.asciiraider.g710.model.utilities;

import java.security.InvalidParameterException;

public class TimeAlarm {
	private int currentTime;
	private int initialTime;
	private boolean running;


	public TimeAlarm(int time) throws InvalidParameterException {
		if(time < 0)
			throw new InvalidParameterException("Time can't be negative");
		this.currentTime = time;
		this.initialTime = time;
		this.running = false;
	}

	public int getCurrentTime() {
		return currentTime;
	}

	public void decTimer(){
		if(this.running)
			this.currentTime--;
	}

	public boolean isRunning(){
		return this.running;
	}

	public void stop(){
		this.running = false;
	}

	public void start(){
		this.running = true;
	}

	public void setTimer(int time){
		if(time < 0)
			throw new InvalidParameterException("Time can't be negative");
		this.currentTime = time;
		this.initialTime = time;
	}

	public void resetTimer(){
		this.currentTime = this.initialTime;
		this.running = false;
	}
}
