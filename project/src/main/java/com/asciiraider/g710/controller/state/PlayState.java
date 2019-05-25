package com.asciiraider.g710.controller.state;

import com.asciiraider.g710.controller.Game;
import com.asciiraider.g710.controller.level.LevelControllerGroup;
import com.asciiraider.g710.model.level.LevelModelGroup;
import com.asciiraider.g710.view.ViewState;

public class PlayState<T> extends State<LevelModelGroup> {
	private LevelControllerGroup levelControllerGroup;
	private LevelModelGroup levelModelGroup;
	private ViewState<LevelModelGroup> levelModelGroupView;

	public PlayState(int fps, int hp, Game game) {
		this.game = game;
		levelModelGroup = new LevelModelGroup(fps, hp);
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
					getStateController().getLevelController().handleLife();
				}
			}
		};
		tick_second.start();

		int physicsCounter = 0;
		int enemiesCounter = 0;
		while (!levelModelGroup.getLevelManager().isGameFinished()) {
			physicsCounter++;
			enemiesCounter++;
			try {
				if(physicsCounter == 4){
					physicsCounter = 0;
					//levelController.handleKeyProgress();
					levelControllerGroup.getLevelController().handlePhysics();
				}
				if(enemiesCounter == 6){
					enemiesCounter = 0;
					levelControllerGroup.getLevelController().moveEnemies();
				}
				if (levelControllerGroup.getLevelController().isPlayerCollidingEnemy())
					levelControllerGroup.getLevelController().handleLife();
				levelControllerGroup.getLevelController().handleAnimations(levelModelGroup.getLevelManager().getFps());

				levelModelGroupView.draw(levelModelGroup);

				Thread.sleep(1000/levelModelGroup.getLevelManager().getFps());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		game.exit();

	}

}
