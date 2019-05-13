package com.asciiraider.g710.view;

import com.asciiraider.g710.model.infobar.InfoBarModel;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.TerminalScreen;

import java.io.IOException;

public class InfoBarView extends TerminalView<InfoBarModel> {

    public InfoBarView(TerminalScreen terminal) throws IOException {
        super(terminal);
    }

    @Override
    public void draw(InfoBarModel model) {
        TextGraphics graphics = screen.newTextGraphics();

        graphics.putString(new TerminalPosition(5, 1), "X");
        graphics.putString(new TerminalPosition(6, 1), "X");
        graphics.putString(new TerminalPosition(7, 1), "X");

        try {
            screen.refresh();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Event getKey() {
        return null;
    }
}
