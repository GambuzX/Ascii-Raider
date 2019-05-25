package com.asciiraider.g710;

import com.asciiraider.g710.controller.Game;

import java.io.IOException;

public class Application {
	private static Game game;
	public static void main(String[] args) {
		new Application().run();
	}

	private void run() {
		final int FPS = 20;
		final int PLAYER_HP = 3;


		try {
			game = new Game();
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
					game.getState().getStateController().handleKeyPress(game.getState().getStateView().getKey());
				}
			}
		};
		input_t.start();
	}
}
