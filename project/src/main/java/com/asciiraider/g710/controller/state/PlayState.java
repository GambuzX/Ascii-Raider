package com.asciiraider.g710.controller.state;

import com.asciiraider.g710.GlobalConfigs;
import com.asciiraider.g710.controller.Game;
import com.asciiraider.g710.controller.level.LevelControllerGroup;
import com.asciiraider.g710.model.level.LevelModelGroup;
import com.asciiraider.g710.view.ViewState;

public class PlayState extends State<LevelModelGroup> {
	private LevelControllerGroup levelControllerGroup;
	private LevelModelGroup levelModelGroup;
	private ViewState<LevelModelGroup> levelModelGroupView;

	public PlayState(Game game) {
		this.game = game;
		levelModelGroup = new LevelModelGroup();
		levelControllerGroup = new LevelControllerGroup(levelModelGroup);

		levelModelGroupView = game.getViewFactory().createLevelView();
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
				//while (!getStateController().isClose()) {
				while (!getStateModel().getLevelManager().isGameFinished()) {

					// TODO: refactoring??
					while (getStateModel().getLevelManager().getTimeAlarm().getCurrentTime() > 0) {
						getStateController().getInfoBarController().handler(getStateModel().getLevelManager().getTimeAlarm());
						getStateModel().getLevelManager().getTimeAlarm().decTimer();
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						if(game.toExit()) break;
					}
					if(!game.toExit())
						getStateController().getLevelController().getLifeController().notifyObservers();
				}
			}
		};
		tick_second.start();

		//while (!getStateController().isClose()) {
		while (!getStateModel().getLevelManager().isGameFinished()) {

			try {

				levelControllerGroup.getLevelController().handlePhysics();

				levelControllerGroup.getLevelController().handleEnemies();

				levelControllerGroup.getLevelController().handleAnimations();


				if (levelControllerGroup.getLevelController().isPlayerCollidingEnemy())
					levelControllerGroup.getLevelController().getLifeController().notifyObservers();

				levelModelGroupView.draw(levelModelGroup);


				levelControllerGroup.getLevelController().handleLevelKey();

				Thread.sleep(1000/ GlobalConfigs.FPS);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		game.changeState(new GameOverState(game, getStateModel().getInfoBarModel().getScore()));
	}

}
