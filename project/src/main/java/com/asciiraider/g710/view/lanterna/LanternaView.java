package com.asciiraider.g710.view.lanterna;

import com.asciiraider.g710.model.level.LevelModelGroup;
import com.asciiraider.g710.view.Event;
import com.asciiraider.g710.view.KeyPressEvent;
import com.asciiraider.g710.view.View;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.SwingTerminalFontConfiguration;

import java.awt.*;
import java.io.IOException;

public class LanternaView extends View<LevelModelGroup> {

    private final int FONT_SIZE = 48;
    private final int INFO_BAR_HEIGHT = 1;

    LanternaLevelView levelView;
    LanternaInfoBarView infoBarView;

    protected TerminalScreen screen;

    public LanternaView(int level_width, int level_height) throws IOException {

        Font font = new Font("Monospaced", Font.PLAIN,  FONT_SIZE);
        SwingTerminalFontConfiguration cfg = SwingTerminalFontConfiguration.newInstance(font);
        Terminal terminal = new DefaultTerminalFactory().setTerminalEmulatorFontConfiguration(cfg).setInitialTerminalSize(new TerminalSize(level_width, level_height + INFO_BAR_HEIGHT)).createTerminal();
        screen = new TerminalScreen(terminal);
        screen.setCursorPosition(null);
        screen.startScreen();
        screen.doResizeIfNecessary();

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
    public Event getKey() {
        try {
            return KeyPressEvent.handle(screen.readInput());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Event.OTHER;
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
