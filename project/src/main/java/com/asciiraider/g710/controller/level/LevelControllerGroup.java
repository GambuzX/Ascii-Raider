package com.asciiraider.g710.controller.level;

import com.asciiraider.g710.controller.Controller;
import com.asciiraider.g710.controller.infobar.InfoBarController;
import com.asciiraider.g710.model.level.LevelModelGroup;

public class LevelControllerGroup extends Controller {
	private LevelController levelController;
	private InfoBarController infoBarController;

	public LevelControllerGroup(LevelModelGroup levelModelGroup){
		this.levelController = new LevelController(levelModelGroup.getLevelManager());
		this.infoBarController = new InfoBarController(levelController, levelModelGroup.getInfoBarModel());
	}

	public LevelController getLevelController() {
		return levelController;
	}


	public InfoBarController getInfoBarController() {
		return infoBarController;
	}

}
