package com.asciiraider.g710.controller;

import com.asciiraider.g710.controller.state.MenuState;
import com.asciiraider.g710.controller.state.State;

import java.io.IOException;

public class Game {
	private State state;
	private boolean exit = false;

	public Game() throws IOException {
		state = new MenuState(this);
	}

	public void changeState(State state){
		this.state = state;
	}

	public State getState() {
		return state;
	}

	public boolean toExit() {
		return exit;
	}

	public void exit(){
		exit = true;
		this.getState().getStateView().exit();
	}
}
