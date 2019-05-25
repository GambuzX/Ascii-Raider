package com.asciiraider.g710.controller;

import com.asciiraider.g710.view.Event;

import java.util.List;

public abstract class ControllerState extends Controller{
	public void processEventList(List<Event> events) {
		for (Event event : events) handleKeyPress(event);
	}

	public abstract void handleKeyPress(Event event);
}
