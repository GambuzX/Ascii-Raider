package com.asciiraider.g710.controller.state;

import com.asciiraider.g710.controller.ControllerState;
import com.asciiraider.g710.controller.Game;
import com.asciiraider.g710.model.Model;
import com.asciiraider.g710.view.ViewState;

public abstract class State<M extends Model> implements Runnable{
	protected Game game;
	public abstract M getStateModel();
	public abstract ViewState<M> getStateView();
	public abstract ControllerState getStateController();
}
