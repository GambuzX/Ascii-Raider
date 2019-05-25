package com.asciiraider.g710.controller;

import com.asciiraider.g710.view.Event;

public abstract class ControllerState extends Controller{
	public abstract void handleKeyPress(Event event);
}
