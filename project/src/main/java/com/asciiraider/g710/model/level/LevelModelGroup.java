package com.asciiraider.g710.model.level;

import com.asciiraider.g710.model.Model;
import com.asciiraider.g710.model.infobar.InfoBarModel;

public class LevelModelGroup extends Model {
    private LevelModel levelModel;
    private InfoBarModel infoBarModel;

    public LevelModel getLevelModel() {
        return levelModel;
    }

    public InfoBarModel getInfoBarModel() {
        return infoBarModel;
    }

    public void setLevelModel(LevelModel levelModel) {
        this.levelModel = levelModel;
    }

    public void setInfoBarModel(InfoBarModel infoBarModel) {
        this.infoBarModel = infoBarModel;
    }
}
