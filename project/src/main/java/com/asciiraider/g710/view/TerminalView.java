package com.asciiraider.g710.view;

import com.asciiraider.g710.model.Model;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public abstract class TerminalView<M extends Model> extends View<M> {
    protected TerminalScreen screen;

    public TerminalView(Terminal terminal) throws IOException {
        screen = new TerminalScreen(terminal);

        screen.setCursorPosition(null);
        screen.startScreen();
        screen.doResizeIfNecessary();
    }
}
