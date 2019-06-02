package com.asciiraider.g710.model.level;

import com.asciiraider.g710.GlobalConfigs;
import com.asciiraider.g710.controller.level.LevelBuilder;
import com.asciiraider.g710.model.Model;
import com.asciiraider.g710.model.infobar.InfoBarModel;
import com.asciiraider.g710.model.life.LifeManager;

public class LevelModelGroup extends Model {
    private LevelManager levelManager;
    private InfoBarModel infoBarModel;

    public LevelModelGroup(){
        levelManager = new LevelManager(new LevelBuilder(), new LifeManager(GlobalConfigs.PLAYER_HP));
        infoBarModel = new InfoBarModel(levelManager.getCurrentLevelIndex() + 1, levelManager.getCurrentLevelKeys(), 0);
    }

    public LevelManager getLevelManager() {
        return levelManager;
    }

    public LevelModel getLevelModel() {
        return levelManager.getCurrentLevel();
    }


    public InfoBarModel getInfoBarModel() {
        return infoBarModel;
    }
}
