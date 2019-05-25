package com.asciiraider.g710.view.lanterna.menu;

import com.asciiraider.g710.model.menu.MenuModel;
import com.asciiraider.g710.view.Event;
import com.asciiraider.g710.view.KeyPressEvent;
import com.asciiraider.g710.view.ViewState;
import com.asciiraider.g710.view.lanterna.utilities.LanternaButtonView;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.TerminalScreen;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LanternaMenuView extends ViewState<MenuModel> {
	private TerminalScreen screen;
	private LanternaButtonView lanternaButtonView;

	public LanternaMenuView(TerminalScreen screen){

		this.screen = screen;
		lanternaButtonView = new LanternaButtonView(screen);
	}

	@Override
	public void draw(MenuModel model) {
		screen.clear();
		TextGraphics graphics = screen.newTextGraphics();

		for(int i = 0; i < model.getNumberOptions(); i++)
			lanternaButtonView.draw(model.getOptions().get(i));

		try {
			screen.refresh();
		} catch (IOException e) {
			e.printStackTrace();
		}
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
		try {
			this.screen.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
