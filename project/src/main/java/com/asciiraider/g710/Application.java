package com.asciiraider.g710;

import com.asciiraider.g710.controller.Game;
import com.asciiraider.g710.view.ViewFactory;
import com.asciiraider.g710.view.lanterna.LanternaFactory;
import com.asciiraider.g710.view.swing.SwingFactory;

import java.io.IOException;

public class Application {
	private static Game game;

	private static ViewFactory viewFactory;

	public static void main(String[] args) {
		if (args.length != 1) {
			System.out.println("Please specify View Platform");
			return;
		}
		// TODO: refactor os valores aqui
		if (args[0].equals(GlobalConfigs.LANTERNA_OPTION)) {
			try {
				viewFactory = new LanternaFactory(GlobalConfigs.LEVEL_WIDTH, GlobalConfigs.LEVEL_HEIGHT + GlobalConfigs.INFOBAR_HEIGHT);
			} catch (IOException e) {
				e.printStackTrace();
				return;
			}
		}
		else if (args[0].equals(GlobalConfigs.SWING_OPTION))
			viewFactory = new SwingFactory();
		else {
			System.out.println("Unknown view platform");
			return;
		}

		new Application().run();
	}

	private void run() {
		game = new Game(viewFactory);

		game.getState().run();
	}
}
