package com.asciiraider.g710.controller;

import com.asciiraider.g710.controller.state.MenuState;
import com.asciiraider.g710.controller.state.State;
import com.asciiraider.g710.view.ViewFactory;

public class Game {
	private State state;
	private boolean exit = false;
	private ViewFactory viewFactory;

	public Game(ViewFactory viewFactory) {
		this.viewFactory = viewFactory;
		state = new MenuState(this);
	}

	public void changeState(State state){
		this.state = state;
		Thread t = new Thread(this.state);
		t.start();
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
