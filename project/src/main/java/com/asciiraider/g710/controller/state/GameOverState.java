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
	private TimeAlarm alarm;

	public GameOverState(Game game, GameOverModel gameOverModel) {
		this.game = game;
		this.gameOverModel = gameOverModel;
		this.gameOverController = new GameOverController(gameOverModel);
		this.gameOverModel.getRestartButton().setAction(new RestartCommand(game));
		this.gameOverView = game.getViewFactory().createGameOverView();
		this.alarm =  new TimeAlarm(GlobalConfigs.GAMEOVER_SCREEN_DURATION);


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

	public TimeAlarm getAlarm() {
		return alarm;
	}

	@Override
	public void run() {

		Thread tick_second = new Thread() {
			@Override
			public void run() {
				getAlarm().start();
				while (getAlarm().getCurrentTime() > 0) {
						getAlarm().decTimer();
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							return;
						}
				}
				game.exit();
			}
		};
		tick_second.start();



		while (!getStateController().isClose() && !game.toExit()) {
			try {
				getStateView().draw(gameOverModel);

				Thread.sleep(1000/ GlobalConfigs.FPS);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		if(!game.toExit())
			tick_second.interrupt();
	}
}
