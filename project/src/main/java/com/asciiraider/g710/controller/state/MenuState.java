package com.asciiraider.g710.controller.state;

import com.asciiraider.g710.controller.Game;
import com.asciiraider.g710.controller.command.ExitCommand;
import com.asciiraider.g710.controller.command.StartCommand;
import com.asciiraider.g710.controller.menu.MenuController;
import com.asciiraider.g710.model.menu.MenuModel;
import com.asciiraider.g710.view.ViewState;
import com.asciiraider.g710.view.lanterna.menu.LanternaMenuView;

import java.io.IOException;

public class MenuState extends State {

	private MenuController menuController;
	private MenuModel menuModel;
	private LanternaMenuView lanternaMenuView;

	// TODO: depois ver aqui
	public MenuState(Game game, ViewState stateView) throws IOException {
		this.game = game;
		menuModel = new MenuModel();
		menuModel.getOptions().get(0).setAction(new StartCommand(game));
		menuModel.getOptions().get(1).setAction(new ExitCommand(game));
		menuController = new MenuController(menuModel);
		lanternaMenuView = (LanternaMenuView) stateView;
	}

	@Override
	public MenuModel getStateModel() {
		return menuModel;
	}

	@Override
	public LanternaMenuView getStateView() {
		return lanternaMenuView;
	}

	@Override
	public MenuController getStateController() {
		return menuController;
	}

	@Override
	public void run() {
		while (!getStateController().isClose()) {
			try {

				lanternaMenuView.draw(menuModel);

				Thread.sleep(1000/20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}


}
