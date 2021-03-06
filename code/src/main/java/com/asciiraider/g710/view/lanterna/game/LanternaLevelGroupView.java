package com.asciiraider.g710.view.lanterna.game;

import com.asciiraider.g710.model.level.LevelModelGroup;
import com.asciiraider.g710.view.lanterna.LanternaStateView;
import com.googlecode.lanterna.screen.TerminalScreen;

import java.io.IOException;

public class LanternaLevelGroupView extends LanternaStateView<LevelModelGroup> {

    LanternaLevelComponent levelView;
    LanternaInfoBarComponent infoBarView;


    public LanternaLevelGroupView(TerminalScreen screen, LanternaLevelComponent lanternaLevelComponent, LanternaInfoBarComponent lanternaInfoBarComponent){
        super(screen);
        this.levelView = lanternaLevelComponent;
        this.infoBarView = lanternaInfoBarComponent;
    }

    @Override
    public synchronized void draw(LevelModelGroup model) {
        screen.clear();

        levelView.draw(model.getLevelModel());
        infoBarView.draw(model.getInfoBarModel());

        try {
            screen.refresh();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
