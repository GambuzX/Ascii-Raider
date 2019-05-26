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
			case ENTER_KEY:
			case EOF:
			case Q_KEY:
				close = true;
				model.getExitButton().getAction().execute();
				return;
		}

	}

	public boolean isClose() {
		return close;
	}
}
