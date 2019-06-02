package com.asciiraider.g710.view.lanterna;

import com.asciiraider.g710.model.gameover.GameOverModel;
import com.asciiraider.g710.model.level.LevelModelGroup;
import com.asciiraider.g710.model.menu.MenuModel;
import com.asciiraider.g710.view.ViewFactory;
import com.asciiraider.g710.view.lanterna.game.LanternaElementView;
import com.asciiraider.g710.view.lanterna.game.LanternaInfoBarComponent;
import com.asciiraider.g710.view.lanterna.game.LanternaLevelComponent;
import com.asciiraider.g710.view.lanterna.game.LanternaLevelGroupView;
import com.asciiraider.g710.view.lanterna.gameover.LanternaGameOverView;
import com.asciiraider.g710.view.lanterna.menu.LanternaMenuView;
import com.asciiraider.g710.view.lanterna.utilities.LanternaButtonView;
import com.googlecode.lanterna.screen.TerminalScreen;

import java.io.IOException;

public class LanternaFactory implements ViewFactory {
        private TerminalScreen screen;

    public LanternaFactory(TerminalScreen screen) throws IOException {
        this.screen = screen;
        screen.setCursorPosition(null);
        screen.startScreen();
        screen.doResizeIfNecessary();
    }


    @Override
    public LanternaStateView<MenuModel> createMenuView() {
        return new LanternaMenuView(screen, new LanternaButtonView(screen));
    }

    @Override
    public LanternaStateView<LevelModelGroup> createLevelView() {
        LanternaLevelComponent levelView = new LanternaLevelComponent(screen, new LanternaElementView(screen));
        LanternaInfoBarComponent infoBarView = new LanternaInfoBarComponent(screen);
        return new LanternaLevelGroupView(screen, levelView, infoBarView);
    }

    @Override
    public LanternaStateView<GameOverModel> createGameOverView() {
        return new LanternaGameOverView(screen);
    }
}
