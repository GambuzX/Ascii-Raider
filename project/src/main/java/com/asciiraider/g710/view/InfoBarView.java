package com.asciiraider.g710.view;

import com.asciiraider.g710.model.infobar.InfoBarModel;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
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

        graphics.setForegroundColor(TextColor.Factory.fromString(model.getTextColor().toString()));
        graphics.setBackgroundColor(TextColor.Factory.fromString(model.getBackgroundColor().toString()));

        int barWidth = screen.getTerminalSize().getColumns();
        int barHeight = 0;
        for (int i = 0 ; i < barWidth; i++) {
            String toDraw = " ";
            int value = -1;
            switch(i) {
                case 1:
                    value = model.getCurrentLevel();
                    break;
                case 4:
                    value = model.getScore();
                    break;
                case 6:
                    value = model.getKeys();
                    break;
                case 9:
                    value = model.getTime();
                    break;
                case 12:
                    value = model.getLives();
                    break;
                case 13:
                    toDraw = "/";
                    break;
                case 14:
                    value = model.getMaxLives();
                    break;
                case 16:
                    toDraw = model.getrButton();
                    break;
            }
            if (value != -1) toDraw = Integer.toString(value);
            graphics.putString(new TerminalPosition(i, barHeight), toDraw);
        }

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
