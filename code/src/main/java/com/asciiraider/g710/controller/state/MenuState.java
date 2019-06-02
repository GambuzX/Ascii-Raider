package com.asciiraider.g710.controller.state;

import com.asciiraider.g710.GlobalConfigs;
import com.asciiraider.g710.controller.Game;
import com.asciiraider.g710.controller.command.ExitCommand;
import com.asciiraider.g710.controller.command.StartCommand;
import com.asciiraider.g710.controller.menu.MenuController;
import com.asciiraider.g710.model.menu.MenuModel;
import com.asciiraider.g710.view.ViewState;

public class MenuState extends State<MenuModel> {

	private MenuController menuController;
	private MenuModel menuModel;
	private ViewState<MenuModel> menuView;

	public MenuState(Game game, MenuModel menuModel) {
		this.game = game;
		this.menuModel = menuModel;
		this.menuModel.getOptions().get(0).setAction(new StartCommand(game));
		this.menuModel.getOptions().get(1).setAction(new ExitCommand(game));
		this.menuController = new MenuController(menuModel);
		this.menuView = game.getViewFactory().createMenuView();
	}

	@Override
	public MenuModel getStateModel() {
		return menuModel;
	}

	@Override
	public ViewState<MenuModel> getStateView() {
		return menuView;
	}

	@Override
	public MenuController getStateController() {
		return menuController;
	}

	@Override
	public void run() {

		while (!getStateController().isClose()) {
			try {

				getStateView().draw(menuModel);

				Thread.sleep(1000/ GlobalConfigs.FPS);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}


}
