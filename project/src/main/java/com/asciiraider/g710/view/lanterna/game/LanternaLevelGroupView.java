package com.asciiraider.g710.view.lanterna.game;

import com.asciiraider.g710.model.level.LevelModelGroup;
import com.asciiraider.g710.view.Event;
import com.asciiraider.g710.view.KeyPressEvent;
import com.asciiraider.g710.view.lanterna.LanternaViewState;
import com.googlecode.lanterna.screen.TerminalScreen;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LanternaLevelGroupView extends LanternaViewState<LevelModelGroup> {

    private final int FONT_SIZE = 48;
    private final int INFO_BAR_HEIGHT = 1;

    LanternaLevelView levelView;
    LanternaInfoBarView infoBarView;

    protected TerminalScreen screen;

    public LanternaLevelGroupView(int level_width, int level_height, TerminalScreen screen) throws IOException {

        /*Font font = new Font("Monospaced", Font.PLAIN,  FONT_SIZE);
        SwingTerminalFontConfiguration cfg = SwingTerminalFontConfiguration.newInstance(font);
        Terminal terminal = new DefaultTerminalFactory().setTerminalEmulatorFontConfiguration(cfg).setInitialTerminalSize(new TerminalSize(level_width, level_height + INFO_BAR_HEIGHT)).createTerminal();
        screen = new TerminalScreen(terminal);
        screen.setCursorPosition(null);
        screen.startScreen();
        screen.doResizeIfNecessary();*/
        this.screen = screen;
        levelView = new LanternaLevelView(screen);
        infoBarView = new LanternaInfoBarView(screen);
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

    @Override
    public TerminalScreen getScreen() {
        return screen;
    }
}
