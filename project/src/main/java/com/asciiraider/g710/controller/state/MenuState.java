package com.asciiraider.g710.controller.state;

import com.asciiraider.g710.GlobalConfigs;
import com.asciiraider.g710.controller.Game;
import com.asciiraider.g710.controller.command.ExitCommand;
import com.asciiraider.g710.controller.command.StartCommand;
import com.asciiraider.g710.controller.menu.MenuController;
import com.asciiraider.g710.model.menu.MenuModel;
import com.asciiraider.g710.view.ViewState;

import java.io.IOException;

public class MenuState<T> extends State<MenuModel> {

	private MenuController menuController;
	private MenuModel menuModel;
	private ViewState<MenuModel> menuView;

	// TODO: depois ver aqui
	public MenuState(Game game) {
		this.game = game;
		menuModel = new MenuModel();
		menuModel.getOptions().get(0).setAction(new StartCommand(game));
		menuModel.getOptions().get(1).setAction(new ExitCommand(game));
		menuController = new MenuController(menuModel);
		menuView = game.getViewFactory().createMenuView();
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

				menuView.draw(menuModel);

				Thread.sleep(1000/ GlobalConfigs.FPS);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}


}
