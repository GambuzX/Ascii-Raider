package com.asciiraider.g710.view;

import com.asciiraider.g710.model.infobar.InfoBarModel;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class InfoBarView extends TerminalView<InfoBarModel> {

    public InfoBarView(Terminal terminal) throws IOException {
        super(terminal);
    }

    @Override
    public void draw(InfoBarModel model) {

    }

    @Override
    public Event getKey() {
        return null;
    }

    @Override
    public void exit() {

    }
}
