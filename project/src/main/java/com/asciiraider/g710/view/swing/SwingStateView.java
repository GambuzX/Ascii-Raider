package com.asciiraider.g710.view.swing;

import com.asciiraider.g710.model.Model;
import com.asciiraider.g710.view.event.Event;
import com.asciiraider.g710.view.ViewState;

import javax.swing.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public abstract class SwingStateView<M extends Model> extends ViewState<M> {
	protected final JFrame frame;
	protected Queue<Event> eventQueue = new LinkedList<>();

	protected SwingStateView(JFrame frame) {
		this.frame = frame;
	}

	@Override
	public List<Event> getEventsList() {
		List<Event> events = new ArrayList<>();
		while (!eventQueue.isEmpty()) {
			events.add(eventQueue.remove());
		}
		return events;
	}

	@Override
	public void exit() {
		frame.setVisible(false);
		frame.dispose();
	}
}
