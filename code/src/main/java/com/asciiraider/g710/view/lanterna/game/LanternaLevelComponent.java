package com.asciiraider.g710.view.lanterna.game;

import com.asciiraider.g710.controller.level.LevelFacade;
import com.asciiraider.g710.model.element.Element;
import com.asciiraider.g710.model.level.LevelModel;
import com.asciiraider.g710.view.View;
import com.googlecode.lanterna.screen.TerminalScreen;

public class LanternaLevelComponent extends View<LevelModel> {

	private TerminalScreen screen;
	private LanternaElementView lanternaElementView;

	public LanternaLevelComponent(TerminalScreen screen, LanternaElementView lanternaElementView) {
		this.screen = screen;
		this.lanternaElementView = lanternaElementView;
	}

	public synchronized void draw(LevelModel levelModel) {

		for (Element ele : levelModel.getBoulders())
			lanternaElementView.draw(ele);

		for (Element ele : levelModel.getWalls())
			lanternaElementView.draw(ele);

		for (Element ele : levelModel.getStoneBlocks())
			lanternaElementView.draw(ele);

		for (Element ele : levelModel.getSandBlocks())
			lanternaElementView.draw(ele);

		for (Element ele : levelModel.getLevelKeys())
			lanternaElementView.draw(ele);

		for (Element ele : levelModel.getTNT())
			lanternaElementView.draw(ele);

		for (Element ele : levelModel.getEnemies())
			lanternaElementView.draw(ele);

		for (Element ele : levelModel.getExplosions())
			lanternaElementView.draw(ele);

		lanternaElementView.draw(levelModel.getPlayer());
		lanternaElementView.draw(levelModel.getExitDoor());

		if (levelModel.getDoor() != null) {
			lanternaElementView.draw(levelModel.getExitDoor());
			lanternaElementView.draw(levelModel.getDoorKey());
		}
	}

}
