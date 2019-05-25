package com.asciiraider.g710.controller.menu;

import com.asciiraider.g710.controller.ControllerState;
import com.asciiraider.g710.model.menu.MenuModel;
import com.asciiraider.g710.view.Event;

public class MenuController extends ControllerState {
	private MenuModel menuModel;
	private boolean close = false;

	public MenuController(MenuModel menuModel) {
		this.menuModel = menuModel;
	}

	@Override
	public void handleKeyPress(Event event) {
		switch (event){
			case UP_KEY: case LEFT_KEY:
				menuModel.previousOption();
				break;
			case DOWN_KEY: case RIGHT_KEY:
				menuModel.nextOption();
				break;
			case ENTER_KEY:
				close = true;
				menuModel.getSelectedButton().getAction().execute();
				break;
			case EOF:
			case Q_KEY:
				close = true;
				menuModel.getOptions().get(1).getAction().execute();
				return;
		}

	}

	public boolean isClose() {
		return close;
	}
}
