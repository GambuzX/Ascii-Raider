package com.asciiraider.g710.view.lanterna.menu;

import com.asciiraider.g710.model.menu.MenuModel;
import com.asciiraider.g710.view.Event;
import com.asciiraider.g710.view.KeyPressEvent;
import com.asciiraider.g710.view.ViewState;
import com.asciiraider.g710.view.lanterna.utilities.LanternaButtonView;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.SwingTerminalFontConfiguration;

import java.awt.*;
import java.io.IOException;

public class LanternaMenuView extends ViewState<MenuModel> {
	private TerminalScreen screen;
	private LanternaButtonView lanternaButtonView;
	private final int FONT_SIZE = 48;

	public LanternaMenuView(int menu_width, int menu_height) throws IOException {

		Font font = new Font("Monospaced", Font.PLAIN,  FONT_SIZE);
		SwingTerminalFontConfiguration cfg = SwingTerminalFontConfiguration.newInstance(font);
		Terminal terminal = new DefaultTerminalFactory().setTerminalEmulatorFontConfiguration(cfg).setInitialTerminalSize(new TerminalSize(menu_width, menu_height)).createTerminal();
		screen = new TerminalScreen(terminal);
		screen.setCursorPosition(null);
		screen.startScreen();
		screen.doResizeIfNecessary();

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
	public Event getKey() {
		try {
			return KeyPressEvent.handle(screen.readInput());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return Event.OTHER;
	}

	@Override
	public void exit() {
		try {
			this.screen.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public TerminalScreen getScreen() {
		return screen;
	}

}
