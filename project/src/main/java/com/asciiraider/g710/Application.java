package com.asciiraider.g710;

import com.asciiraider.g710.controller.level.LevelController;
import com.asciiraider.g710.model.infobar.InfoBarModel;
import com.asciiraider.g710.model.level.LevelManager;
import com.asciiraider.g710.model.level.LevelModelGroup;
import com.asciiraider.g710.view.View;
import com.asciiraider.g710.view.ViewFactory;
import com.asciiraider.g710.view.lanterna.LanternaFactory;
import com.asciiraider.g710.view.lanterna.LanternaView;
import com.asciiraider.g710.view.swing.SwingFactory;
import com.asciiraider.g710.view.swing.SwingView;

import java.io.IOException;

public class Application {

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

		View finalView = viewFactory.createView(level_width, level_height);
		if (finalView == null) return;

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
					levelController.processEventList(finalView.getEventsList());
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
						finalView.draw(levelModelGroup);

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

				finalView.exit();
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
