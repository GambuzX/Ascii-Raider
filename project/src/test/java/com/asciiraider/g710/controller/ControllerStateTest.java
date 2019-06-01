package com.asciiraider.g710.controller;

import com.asciiraider.g710.model.Model;
import com.asciiraider.g710.view.Event;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class ControllerStateTest {
	@Test
	public void test1(){
		Model modelMock = mock(Model.class);

		ControllerState controllerState = spy(new ControllerState(modelMock) {
			@Override
			public void handleKeyPress(Event event) {

			}

			@Override
			public boolean isClose() {
				return false;
			}
		});

		List<Event> events = new ArrayList<>();
		events.add(Event.Q_KEY);
		events.add(Event.Q_KEY);
		events.add(Event.Q_KEY);
		events.add(Event.Q_KEY);

		controllerState.processEventList(events);

		verify(controllerState, times(4)).handleKeyPress(Event.Q_KEY);
	}
}
