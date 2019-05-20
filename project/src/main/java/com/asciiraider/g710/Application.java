package com.asciiraider.g710;

import com.asciiraider.g710.controller.level.LevelController;
import com.asciiraider.g710.model.infobar.InfoBarModel;
import com.asciiraider.g710.model.level.LevelManager;
import com.asciiraider.g710.model.level.LevelModelGroup;
import com.asciiraider.g710.view.lanterna.LanternaView;

import java.io.IOException;

public class Application {
	public static void main(String[] args) {
		new Application().run();
	}

	private void run() {
		final int FPS = 20;
		final int PLAYER_HP = 3;

		LevelManager levelManager = new LevelManager(FPS, PLAYER_HP);
		int level_width = levelManager.getCurrentLevelFacade().getWidth();
		int level_height = levelManager.getCurrentLevelFacade().getHeight();

		LanternaView lanternaView = null;
		try {
			lanternaView = new LanternaView(level_width, level_height);
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (lanternaView == null) {
			System.out.println("error creating lanternaView");
			return;
		}
		LanternaView finalLanternaView = lanternaView;

		LevelController levelController = new LevelController(levelManager);

		LevelModelGroup levelModelGroup = new LevelModelGroup();
		levelModelGroup.setInfoBarModel(new InfoBarModel());
		levelModelGroup.getInfoBarModel().setMaxLives(levelManager.getLifeManager().getInitialLife());

		/**
		 * Draw Cicle
		 */
		// TODO: ve se gostas assim sem o LevelManager na view. ainda n sei onde por isto, mas tem de ser numa thread
		Thread input_t = new Thread() {
			@Override
			public void run(){
				while (!levelManager.isGameFinished()) {
					levelController.handleKeyPress(finalLanternaView.getKey());
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

						levelController.updateInfoBarModel(levelModelGroup.getInfoBarModel());
						levelModelGroup.setLevelModel(levelManager.getCurrentLevel());
						finalLanternaView.draw(levelModelGroup);

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

				finalLanternaView.exit();
			}
		};

		Thread tick_second = new Thread() {
			@Override
			public void run() {
				while (!levelManager.isGameFinished()) {
					// TODO: refactoring??
					while (!levelManager.isGameFinished() && levelManager.getCurrentLevel().getTimeAlarm().getCurrentTime() > 0) {
						System.out.println(levelManager.getCurrentLevel().getTimeAlarm().getCurrentTime());
						levelManager.getCurrentLevel().getTimeAlarm().decTimer();
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
