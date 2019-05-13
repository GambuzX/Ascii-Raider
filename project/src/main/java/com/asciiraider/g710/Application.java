package com.asciiraider.g710;

import com.asciiraider.g710.controller.level.LevelController;
import com.asciiraider.g710.model.infobar.InfoBarModel;
import com.asciiraider.g710.model.level.LevelManager;
import com.asciiraider.g710.view.InfoBarView;
import com.asciiraider.g710.view.LevelView;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.SwingTerminalFontConfiguration;

import java.awt.*;
import java.io.IOException;

public class Application {
	public static void main(String[] args) {
		new Application().run();
	}

	private void run() {
		final int FPS = 20;
		final int PLAYER_HP = 3;
		final int FONT_SIZE = 48;

		LevelManager levelManager = new LevelManager(FPS, PLAYER_HP);
		int level_width = levelManager.getCurrentLevelFacade().getWidth();
		int level_height = levelManager.getCurrentLevelFacade().getHeight();

		Font font = new Font("Monospaced", Font.PLAIN,  FONT_SIZE);
		SwingTerminalFontConfiguration cfg = SwingTerminalFontConfiguration.newInstance(font);
		Terminal terminal = null;
		TerminalScreen screen = null;
		try {
			terminal = new DefaultTerminalFactory().setTerminalEmulatorFontConfiguration(cfg).setInitialTerminalSize(new TerminalSize(level_width, level_height)).createTerminal();
			screen = new TerminalScreen(terminal);
			screen.setCursorPosition(null);
			screen.startScreen();
			screen.doResizeIfNecessary();
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (terminal == null) {
			System.out.println("error initializing terminal");
			return;
		}

		LevelController levelController = new LevelController(levelManager);

		LevelView levelView = null;
		InfoBarView infoBarView = null;
		try {
			levelView = new LevelView(screen);
			infoBarView = new InfoBarView(screen);
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (levelView == null || infoBarView == null) return;

		LevelView finalLevelView = levelView;
		InfoBarView finalBarView = infoBarView;
		TerminalScreen finalScreen = screen;

		/**
		 * Draw Cicle
		 */
		// TODO: ve se gostas assim sem o LevelManager na view. ainda n sei onde por isto, mas tem de ser numa thread
		Thread input_t = new Thread() {
			@Override
			public void run(){
				while (!levelManager.isGameFinished()) {
					levelController.handleKeyPress(finalLevelView.getKey());
					if(isInterrupted()) break;
				}
			}
		};

		Thread draw_t = new Thread() {
			@Override
			public void run(){
				int physicsCounter = 0;
				int enemiesCounter = 0;
				while (!levelManager.isGameFinished()) {
					physicsCounter++;
					enemiesCounter++;
					try {
						if(physicsCounter == 4){
							physicsCounter = 0;
							//levelController.handleKeyProgress();
							levelController.handlePhysics();
						}
						if(enemiesCounter == 6){
							enemiesCounter = 0;
							levelController.moveEnemies();
							levelController.moveEnemies();
						}
						if (levelController.isPlayerCollidingEnemy())
							levelController.handleLife();
						levelController.handleAnimations(levelManager.getFps());

						finalScreen.clear();
						finalLevelView.draw(levelManager.getCurrentLevel());
						finalBarView.draw(new InfoBarModel());

						Thread.sleep(1000/levelManager.getFps());
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					if(isInterrupted()) break;
				}

				if (levelManager.wonGame())
					System.out.println("GG you win!");
				else
					System.out.println("Game over");

				finalLevelView.exit();
			}
		};


		draw_t.start();
		input_t.start();
	}
}
