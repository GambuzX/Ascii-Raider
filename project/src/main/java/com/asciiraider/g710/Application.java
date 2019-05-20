package com.asciiraider.g710;

import com.asciiraider.g710.controller.level.LevelController;
import com.asciiraider.g710.model.level.LevelManager;
import com.asciiraider.g710.view.LevelView;

import java.io.IOException;

public class Application {
	public static void main(String[] args) {
		new Application().run();
	}

	private void run() {
		int fps = 20;

		LevelManager levelManager = new LevelManager(fps, 3);

		LevelController levelController = new LevelController(levelManager);
		LevelView levelView = null;
		try {
			levelView = new LevelView(levelManager.getCurrentLevelFacade().getWidth(), levelManager.getCurrentLevelFacade().getHeight(), 48);
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
						}
						if (levelController.isPlayerCollidingEnemy())
							levelController.handleLife();
						levelController.handleAnimations(levelManager.getFps());
						finalLevelView.draw(levelManager.getCurrentLevel());
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
				System.out.println(levelManager.getUser().getScore());

				finalLevelView.exit();
			}
		};

		Thread tick_second = new Thread() {
			@Override
			public void run() {
				while (!levelManager.isGameFinished()) {
					// TODO: refactoring??
					while (!levelManager.isGameFinished() && levelManager.getTimeAlarm().getCurrentTime() > 0) {
						System.out.println(levelManager.getTimeAlarm().getCurrentTime());
						levelManager.getTimeAlarm().decTimer();
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					levelController.handleLife();
				}
			}
		};


		draw_t.start();
		input_t.start();
		tick_second.start();
	}
}
