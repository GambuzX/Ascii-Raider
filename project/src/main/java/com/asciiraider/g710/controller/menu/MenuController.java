package com.asciiraider.g710.controller.menu;

import com.asciiraider.g710.controller.ControllerState;
import com.asciiraider.g710.model.menu.MenuModel;
import com.asciiraider.g710.view.Event;

public class MenuController extends ControllerState<MenuModel> {
	private boolean close = false;

	public MenuController(MenuModel menuModel) {
		super(menuModel);
	}

	@Override
	public void handleKeyPress(Event event) {
		if(event == null)
			return;

		switch (event){
			case UP_KEY: case LEFT_KEY:
				model.previousOption();
				break;
			case DOWN_KEY: case RIGHT_KEY:
				model.nextOption();
				break;
			case ENTER_KEY:
				close = true;
				model.getSelectedButton().getAction().execute();
				break;
			case EOF:
			case Q_KEY:
				close = true;
				model.getOptions().get(1).getAction().execute();
				return;

		}

	}

	@Override
	public boolean isClose() {
		return close;
	}
}
