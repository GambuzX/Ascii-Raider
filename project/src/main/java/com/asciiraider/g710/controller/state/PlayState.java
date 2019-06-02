package com.asciiraider.g710.controller.state;

import com.asciiraider.g710.GlobalConfigs;
import com.asciiraider.g710.controller.Game;
import com.asciiraider.g710.controller.level.LevelControllerGroup;
import com.asciiraider.g710.model.gameover.GameOverModel;
import com.asciiraider.g710.model.level.LevelModelGroup;
import com.asciiraider.g710.view.ViewState;

public class PlayState extends State<LevelModelGroup> {
	private LevelControllerGroup levelControllerGroup;
	private LevelModelGroup levelModelGroup;
	private ViewState<LevelModelGroup> levelModelGroupView;

	public PlayState(Game game, LevelModelGroup levelModelGroup) {
		this.game = game;
		this.levelModelGroup = levelModelGroup;
		this.levelControllerGroup = new LevelControllerGroup(this.levelModelGroup);

		this.levelModelGroupView = game.getViewFactory().createLevelView();
	}

	@Override
	public LevelModelGroup getStateModel() {
		return this.levelModelGroup;
	}

	@Override
	public ViewState<LevelModelGroup>  getStateView() {
		return this.levelModelGroupView;
	}

	@Override
	public LevelControllerGroup getStateController() {
		return this.levelControllerGroup;
	}

	@Override
	public void run() {

		Thread tick_second = new Thread() {
			@Override
			public void run() {
				while (!getStateModel().getLevelManager().isGameFinished()) {

					while (getStateModel().getLevelManager().getTimeAlarm().getCurrentTime() > 0) {
						getStateController().getInfoBarController().handler(getStateModel().getLevelManager().getTimeAlarm());
						getStateModel().getLevelManager().getTimeAlarm().decTimer();
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							return;
						}
						if(isInterrupted()) return;
						if(game.toExit()) break;
					}

					if(!game.toExit())
						getStateController().getLevelController().getLifeController().notifyObservers();
				}
			}
		};
		tick_second.start();

		while (!levelModelGroup.getLevelManager().isGameFinished()) {

			try {

				getStateController().getLevelController().handlePhysics();

				getStateController().getLevelController().handleEnemies();

				getStateController().getLevelController().handleAnimations();


				if (getStateController().getLevelController().isPlayerCollidingEnemy())
					getStateController().getLevelController().getLifeController().notifyObservers();

				getStateView().draw(levelModelGroup);


				getStateController().getLevelController().handleLevelKey();

				Thread.sleep(1000/ GlobalConfigs.FPS);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		tick_second.interrupt();
		game.changeState(new GameOverState(game, new GameOverModel(getStateModel().getInfoBarModel().getScore())));
	}

}
