package com.asciiraider.g710.view.lanterna;

import com.asciiraider.g710.model.Model;
import com.asciiraider.g710.view.Event;
import com.asciiraider.g710.view.KeyPressEvent;
import com.asciiraider.g710.view.ViewState;
import com.googlecode.lanterna.screen.TerminalScreen;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class LanternaStateView<M extends Model> extends ViewState<M> {
	protected final TerminalScreen screen;
	protected LanternaStateView(TerminalScreen screen) {
		this.screen = screen;
	}

	@Override
	public List<Event> getEventsList() {
		List<Event> events = new ArrayList<>();
		try {
			events.add(KeyPressEvent.handleLanterna(screen.readInput()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return events;
	}

	@Override
	public void exit() {
		System.out.println("exiting");
		try {
			this.screen.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
