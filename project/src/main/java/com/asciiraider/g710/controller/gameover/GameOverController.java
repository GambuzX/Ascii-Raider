package com.asciiraider.g710.controller.gameover;

import com.asciiraider.g710.controller.ControllerState;
import com.asciiraider.g710.model.gameover.GameOverModel;
import com.asciiraider.g710.view.Event;

public class GameOverController extends ControllerState<GameOverModel>  {
	private boolean close = false;

	public GameOverController(GameOverModel gameOverModel) {
		super(gameOverModel);
	}


	@Override
	public void handleKeyPress(Event event) {
		if(event == null)
			return;
		switch (event){
			case EOF:
				close = true;
				break;
			case ENTER_KEY:
			case Q_KEY:
				close = true;
				model.getRestartButton().getAction().execute();
		}

	}

	@Override
	public boolean isClose() {
		return close;
	}
}
