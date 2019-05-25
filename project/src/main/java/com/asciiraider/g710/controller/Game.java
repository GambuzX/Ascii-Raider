package com.asciiraider.g710.controller;

import com.asciiraider.g710.controller.state.PlayState;
import com.asciiraider.g710.controller.state.State;
import com.asciiraider.g710.view.ViewFactory;

import java.io.IOException;

public class Game {
	private State state;
	private boolean exit = false;
	private ViewFactory viewFactory;

	public Game(ViewFactory viewFactory) {
		this.viewFactory = viewFactory;
		state = new PlayState(this);
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

	public ViewFactory getViewFactory() {
		return viewFactory;
	}
}
