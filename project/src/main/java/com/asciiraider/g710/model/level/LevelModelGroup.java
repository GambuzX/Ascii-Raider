package com.asciiraider.g710.model.level;

import com.asciiraider.g710.model.Model;
import com.asciiraider.g710.model.infobar.InfoBarModel;

public class LevelModelGroup extends Model {
    private LevelManager levelManager;
    private InfoBarModel infoBarModel;

    public LevelModelGroup(){
        levelManager = new LevelManager();
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
