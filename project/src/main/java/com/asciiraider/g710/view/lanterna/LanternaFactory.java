package com.asciiraider.g710.view.lanterna;

import com.asciiraider.g710.model.level.LevelModelGroup;
import com.asciiraider.g710.model.menu.MenuModel;
import com.asciiraider.g710.view.ViewFactory;
import com.asciiraider.g710.view.ViewState;
import com.asciiraider.g710.view.lanterna.game.LanternaLevelGroupView;
import com.asciiraider.g710.view.lanterna.menu.LanternaMenuView;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.SwingTerminalFontConfiguration;

import java.awt.*;
import java.io.IOException;

public class LanternaFactory implements ViewFactory {
    private TerminalScreen screen;
    private final int FONT_SIZE = 48;

    public LanternaFactory(int width, int height) throws IOException {
        Font font = new Font("Monospaced", Font.PLAIN,  FONT_SIZE);
        SwingTerminalFontConfiguration cfg = SwingTerminalFontConfiguration.newInstance(font);
        Terminal terminal = new DefaultTerminalFactory().setTerminalEmulatorFontConfiguration(cfg).setInitialTerminalSize(new TerminalSize(width, height)).createTerminal();
        screen = new TerminalScreen(terminal);
        screen.setCursorPosition(null);
        screen.startScreen();
        screen.doResizeIfNecessary();
    }


    @Override
    public ViewState<MenuModel> createMenuView() {
        return new LanternaMenuView(screen);
    }

    @Override
    public ViewState<LevelModelGroup> createLevelView() {
        return new LanternaLevelGroupView(screen);
    }
}
