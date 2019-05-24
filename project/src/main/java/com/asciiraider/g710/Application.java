package com.asciiraider.g710;

import com.asciiraider.g710.controller.state.GameState;

import java.io.IOException;

public class Application {
	public static void main(String[] args) {
		new Application().run();
	}

	private void run() {
		final int FPS = 20;
		final int PLAYER_HP = 3;

		GameState gameState;
		try {
			gameState =  new GameState(FPS, PLAYER_HP);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("error creating lanternaView");
			return;
		}

		/**
		 * Draw Cicle
		 */
		// TODO: ve se gostas assim sem o LevelManager na view. ainda n sei onde por isto, mas tem de ser numa thread
		GameState finalGameState = gameState;
		Thread input_t = new Thread() {
			@Override
			public void run(){
				while (!finalGameState.getStateModel().getLevelManager().isGameFinished()) {
					finalGameState.getStateController().getLevelController().handleKeyPress(finalGameState.getStateView().getKey());
					if(isInterrupted()) break;
				}
			}
		};

		Thread draw_t = new Thread() {
			@Override
			public void run(){
				int physicsCounter = 0;
				int enemiesCounter = 0;
				while (!finalGameState.getStateModel().getLevelManager().isGameFinished()) {
					physicsCounter++;
					enemiesCounter++;
					try {
						if(physicsCounter == 4){
							physicsCounter = 0;
							//levelController.handleKeyProgress();
							finalGameState.getStateController().getLevelController().handlePhysics();
						}
						if(enemiesCounter == 6){
							enemiesCounter = 0;
							finalGameState.getStateController().getLevelController().moveEnemies();
						}
						if (finalGameState.getStateController().getLevelController().isPlayerCollidingEnemy())
							finalGameState.getStateController().getLevelController().handleLife();
						finalGameState.getStateController().getLevelController().handleAnimations(finalGameState.getStateModel().getLevelManager().getFps());

						finalGameState.getStateView().draw(finalGameState.getStateModel());

						Thread.sleep(1000/finalGameState.getStateModel().getLevelManager().getFps());
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					if(isInterrupted()) break;
				}

				if (finalGameState.getStateModel().getLevelManager().wonGame())
					System.out.println("GG you win!");
				else
					System.out.println("Game over");
				System.out.println(finalGameState.getStateModel().getInfoBarModel().getScore());

				finalGameState.getStateView().exit();
			}
		};

		Thread tick_second = new Thread() {
			@Override
			public void run() {
				while (!finalGameState.getStateModel().getLevelManager().isGameFinished()) {
					// TODO: refactoring??
					while (!finalGameState.getStateModel().getLevelManager().isGameFinished() && finalGameState.getStateModel().getLevelManager().getTimeAlarm().getCurrentTime() > 0) {
						finalGameState.getStateController().getInfoBarController().handler(finalGameState.getStateModel().getLevelManager().getTimeAlarm());
						finalGameState.getStateModel().getLevelManager().getTimeAlarm().decTimer();
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					finalGameState.getStateController().getLevelController().handleLife();
				}
			}
		};


		draw_t.start();
		input_t.start();
		tick_second.start();
	}
}
