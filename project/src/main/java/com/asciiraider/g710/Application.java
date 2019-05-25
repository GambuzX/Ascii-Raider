package com.asciiraider.g710;

import com.asciiraider.g710.controller.Game;
import com.asciiraider.g710.model.level.LevelManager;
import com.asciiraider.g710.view.View;
import com.asciiraider.g710.view.ViewFactory;
import com.asciiraider.g710.view.lanterna.LanternaFactory;
import com.asciiraider.g710.view.lanterna.LanternaViewState;
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

		if (args[0].equals("lanterna"))
			viewFactory = new LanternaFactory();
		else if (args[0].equals("swing"))
			viewFactory = new SwingFactory();
		else {
			System.out.println("Unknown view platform");
			return;
		}

		new Application().run();
	}

	private void run() {
		final int FPS = 20;
		final int PLAYER_HP = 3;

		LevelManager levelManager = new LevelManager(FPS, PLAYER_HP);
		int level_width = levelManager.getCurrentLevelFacade().getWidth();
		int level_height = levelManager.getCurrentLevelFacade().getHeight();

		try {
			game = new Game(viewFactory, level_width, level_height + 1);
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}


		Thread t = new Thread(game.getState());
		t.start();

		Thread input_t = new Thread() {
			@Override
			public void run(){
				while (!game.toExit()) {
					game.getState().getStateController().processEventList(game.getState().getStateView().getEventsList());
				}
			}
		};

		input_t.start();
	}
}
