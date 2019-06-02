package com.asciiraider.g710.controller.state;

import com.asciiraider.g710.GlobalConfigs;
import com.asciiraider.g710.controller.Game;
import com.asciiraider.g710.controller.command.RestartCommand;
import com.asciiraider.g710.controller.gameover.GameOverController;
import com.asciiraider.g710.model.gameover.GameOverModel;
import com.asciiraider.g710.model.utilities.TimeAlarm;
import com.asciiraider.g710.view.ViewState;

public class GameOverState extends State {

	private GameOverController gameOverController;
	private GameOverModel gameOverModel;
	private ViewState<GameOverModel> gameOverView;

	public GameOverState(Game game, int score) {
		this.game = game;
		gameOverModel = new GameOverModel(score);
		gameOverController = new GameOverController(gameOverModel);
		gameOverModel.getRestartButton().setAction(new RestartCommand(game));
		gameOverView = game.getViewFactory().createGameOverView();

	}

	@Override
	public GameOverModel getStateModel() {
		return gameOverModel;
	}

	@Override
	public ViewState<GameOverModel> getStateView() {
		return gameOverView;
	}

	@Override
	public GameOverController getStateController() {
		return gameOverController;
	}

	@Override
	public void run() {
		TimeAlarm alarm =  new TimeAlarm(GlobalConfigs.GAMEOVER_SCREEN_DURATION);
		Thread tick_second = new Thread() {
			@Override
			public void run() {
				alarm.start();
				while (alarm.getCurrentTime() > 0) {
						alarm.decTimer();
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							return;
						}
						if (isInterrupted()) {
							return;
						}

						if(game.toExit()) break;
				}
				game.exit();
			}
		};
		tick_second.start();



		while (!getStateController().isClose() && !game.toExit()) {
			try {
				gameOverView.draw(gameOverModel);

				Thread.sleep(1000/ GlobalConfigs.FPS);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		if(!game.toExit())
			tick_second.interrupt();
	}
}
