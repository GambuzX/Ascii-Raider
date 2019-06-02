package com.asciiraider.g710;

import com.asciiraider.g710.controller.Game;
import com.asciiraider.g710.view.ViewFactory;
import com.asciiraider.g710.view.lanterna.LanternaFactory;
import com.asciiraider.g710.view.swing.SwingFactory;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.SwingTerminalFontConfiguration;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Application {
	private static Game game;

	private static ViewFactory viewFactory;

	public static void main(String[] args) {
		if (args.length != 1) {
			System.out.println("Please specify View Platform");
			return;
		}

		if (args[0].equals(GlobalConfigs.LANTERNA_OPTION)) {
			try {
				Font font = new Font(GlobalConfigs.LANTERNA_FONT, Font.PLAIN, GlobalConfigs.LANTERNA_FONT_SIZE);
				SwingTerminalFontConfiguration cfg = SwingTerminalFontConfiguration.newInstance(font);
				Terminal terminal = new DefaultTerminalFactory().setTerminalEmulatorFontConfiguration(cfg).setInitialTerminalSize(new TerminalSize(GlobalConfigs.LEVEL_WIDTH, GlobalConfigs.LEVEL_HEIGHT + GlobalConfigs.INFOBAR_HEIGHT)).createTerminal();
				TerminalScreen screen = new TerminalScreen(terminal);
				viewFactory = new LanternaFactory(screen);
			} catch (IOException e) {
				e.printStackTrace();
				return;
			}
		}
		else if (args[0].equals(GlobalConfigs.SWING_OPTION))
			viewFactory = new SwingFactory(new JFrame(GlobalConfigs.GAME_NAME));
		else {
			System.out.println("Unknown view platform");
			return;
		}

		new Application().run();
	}

	private void run() {
		game = new Game(viewFactory);

		Thread t = new Thread(game.getState());
		t.start();

		Thread input_t = new Thread() {
			@Override
			public void run(){
				while (!game.toExit()) {
					while (!game.getState().getStateController().isClose() && !game.toExit()) {
						game.getState().getStateController().processEventList(game.getState().getStateView().getEventsList());
					}
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};

		input_t.start();
	}
}
