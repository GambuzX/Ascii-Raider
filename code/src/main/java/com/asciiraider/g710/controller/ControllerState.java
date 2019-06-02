package com.asciiraider.g710.controller;

import com.asciiraider.g710.model.Model;
import com.asciiraider.g710.view.event.Event;

import java.util.List;

public abstract class ControllerState<M extends Model>{
	protected  M model;

	protected ControllerState(M model){
		this.model = model;
	}

	public void processEventList(List<Event> events) {
		for (Event event : events) handleKeyPress(event);
	}

	public abstract void handleKeyPress(Event event);

	public abstract boolean isClose();
}
