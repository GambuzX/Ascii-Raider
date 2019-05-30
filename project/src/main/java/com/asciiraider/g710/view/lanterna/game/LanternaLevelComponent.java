package com.asciiraider.g710.view.lanterna.game;

import com.asciiraider.g710.controller.level.LevelFacade;
import com.asciiraider.g710.model.element.Element;
import com.asciiraider.g710.model.level.LevelModel;
import com.asciiraider.g710.view.View;
import com.googlecode.lanterna.screen.TerminalScreen;

public class LanternaLevelComponent extends View<LevelModel> {

	private TerminalScreen screen;
	private LanternaElementView lanternaElementView;

	public LanternaLevelComponent(TerminalScreen screen) {
		this.screen = screen;
		this.lanternaElementView = new LanternaElementView(screen);
	}

	// TODO: synchronized adicionado aqui e ao physics ver melhor o efeito
	public synchronized void draw(LevelModel levelModel) {

		// TODO: ver isto
		LevelFacade levelModelF = new LevelFacade(levelModel);

		for (Element ele : levelModelF.getElements())
			lanternaElementView.draw(ele);
	}

}
