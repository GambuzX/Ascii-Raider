package com.asciiraider.g710.model.level;

import com.asciiraider.g710.model.Model;
import com.asciiraider.g710.model.infobar.InfoBarModel;

public class LevelModelGroup extends Model {
    private LevelModel levelModel;
    private InfoBarModel infoBarModel;

    public LevelModelGroup(LevelModel levelModel, InfoBarModel infoBarModel) {
        this.levelModel = levelModel;
        this.infoBarModel = infoBarModel;
    }

    public LevelModel getLevelModel() {
        return levelModel;
    }

    public InfoBarModel getInfoBarModel() {
        return infoBarModel;
    }
}
