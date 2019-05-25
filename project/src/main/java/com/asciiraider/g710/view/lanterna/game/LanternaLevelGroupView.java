package com.asciiraider.g710.view.lanterna.game;

import com.asciiraider.g710.model.level.LevelModelGroup;
import com.asciiraider.g710.view.Event;
import com.asciiraider.g710.view.KeyPressEvent;
import com.asciiraider.g710.view.ViewState;
import com.googlecode.lanterna.screen.TerminalScreen;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LanternaLevelGroupView extends ViewState<LevelModelGroup> {

    LanternaLevelComponent levelView;
    LanternaInfoBarComponent infoBarView;

    protected TerminalScreen screen;

    public LanternaLevelGroupView(TerminalScreen screen){
        this.screen = screen;
        levelView = new LanternaLevelComponent(screen);
        infoBarView = new LanternaInfoBarComponent(screen);
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

    @Override
    public List<Event> getEventsList() {
        List<Event> events = new ArrayList<>();
        try {
            events.add(KeyPressEvent.handleLanterna(screen.readInput()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return events;
    }

    @Override
    public void exit() {
        try {
            this.screen.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
