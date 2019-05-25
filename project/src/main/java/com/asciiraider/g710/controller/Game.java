package com.asciiraider.g710.controller;

import com.asciiraider.g710.controller.state.MenuState;
import com.asciiraider.g710.controller.state.State;
import com.asciiraider.g710.view.ViewFactory;
import com.asciiraider.g710.view.ViewState;

import java.io.IOException;

public class Game {
	private State state;
	private boolean exit = false;

	public Game(ViewFactory viewFactory, int width, int height) throws IOException {
		ViewState finalView = viewFactory.createView(width, height);
		if (finalView == null) return;
		state = new MenuState(this, finalView);
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
