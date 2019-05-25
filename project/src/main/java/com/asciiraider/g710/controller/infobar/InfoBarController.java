package com.asciiraider.g710.controller.infobar;

import com.asciiraider.g710.controller.level.LevelController;
import com.asciiraider.g710.model.infobar.InfoBarModel;
import com.asciiraider.g710.model.level.LevelTimeAlarm;

public class InfoBarController {

	private InfoBarModel infoBarModel;

	public InfoBarController(LevelController levelController, InfoBarModel infoBarModel){
		this.infoBarModel = infoBarModel;
		levelController.getLifeController().addObserver(infoBarModel);
		levelController.getLevelKeyController().addObserver(infoBarModel);
		levelController.getLevelProgressionController().addObserver(infoBarModel);
	}

	public void handler(LevelTimeAlarm timeAlarm) {
		this.infoBarModel.setTime(timeAlarm.getCurrentTime());
	}

}
