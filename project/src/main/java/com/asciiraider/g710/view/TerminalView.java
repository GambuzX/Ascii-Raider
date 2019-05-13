package com.asciiraider.g710.view;

import com.asciiraider.g710.model.Model;
import com.googlecode.lanterna.screen.TerminalScreen;

import java.io.IOException;

public abstract class TerminalView<M extends Model> extends View<M> {
    protected TerminalScreen screen;

    public TerminalView(TerminalScreen screen) throws IOException {
        this.screen = screen;
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
