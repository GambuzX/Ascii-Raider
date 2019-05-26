package com.asciiraider.g710.view.lanterna.menu;

import com.asciiraider.g710.GlobalConfigs;
import com.asciiraider.g710.model.menu.MenuModel;
import com.asciiraider.g710.model.utilities.HexColorString;
import com.asciiraider.g710.view.lanterna.LanternaStateView;
import com.asciiraider.g710.view.lanterna.utilities.LanternaButtonView;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.TerminalScreen;

import java.io.IOException;

public class LanternaMenuView extends LanternaStateView<MenuModel> {
	private LanternaButtonView lanternaButtonView;

	public LanternaMenuView(TerminalScreen screen){

		super(screen);
		lanternaButtonView = new LanternaButtonView(screen);
	}

	@Override
	public void draw(MenuModel model) {
		screen.clear();

		TextGraphics graphics = screen.newTextGraphics();
		graphics.setForegroundColor(TextColor.Factory.fromString(new HexColorString("CCCCCC").toString()));

		int column  = (GlobalConfigs.LEVEL_WIDTH - GlobalConfigs.GAME_NAME.length()) / 2;

		graphics.putString(column, 1, GlobalConfigs.GAME_NAME);

		for(int i = 0; i < model.getNumberOptions(); i++)
			lanternaButtonView.draw(model.getOptions().get(i));

		try {
			screen.refresh();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
