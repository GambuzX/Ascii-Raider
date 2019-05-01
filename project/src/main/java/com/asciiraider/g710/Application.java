package com.asciiraider.g710;

import com.asciiraider.g710.controller.LevelController;
import com.asciiraider.g710.model.level.LevelManager;
import com.asciiraider.g710.view.LevelView;

import java.io.IOException;

public class Application {
	public static void main(String[] args) {
		new Application().run();
	}

	private void run() {
		System.out.println("Hello World");

		LevelManager levelManager = new LevelManager();

		LevelController levelController = new LevelController(levelManager);
		LevelView levelView = null;
		try {
			levelView = new LevelView(18, 12, 48);
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (levelView == null) return;

		LevelView finalLevelView = levelView;

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
				while (!levelManager.isGameFinished()) {
					try {
						levelController.handleKeyProgress();
						levelController.moveEnemies();
						if (levelController.isPlayerCollidingEnemy()) break;
						finalLevelView.draw(levelManager.getCurrentLevel());
						Thread.sleep(200);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					if(isInterrupted()) break;
				}

				if (levelManager.wonGame())
					System.out.println("GG you win|");
				else
					System.out.println("Game over");

				finalLevelView.exit();
			}
		};

		Thread physics_t = new Thread() {
			@Override
			public void run() {
				while (!levelManager.isGameFinished()) {
					try {
						levelController.handlePhysics();
						Thread.sleep(300);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					if(isInterrupted()) break;
				}
			}
		};

		draw_t.start();


		input_t.start();


		physics_t.start();


		// You win, GG
	}
}
