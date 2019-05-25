package com.asciiraider.g710.view.lanterna.game;

import com.asciiraider.g710.GlobalConfigs;
import com.asciiraider.g710.model.infobar.IllegalConversionException;
import com.asciiraider.g710.model.infobar.InfoBarModel;
import com.asciiraider.g710.model.infobar.Score;
import com.asciiraider.g710.model.utilities.HexColorString;
import com.asciiraider.g710.view.View;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.TerminalScreen;

public class LanternaInfoBarComponent extends View<InfoBarModel> {

    private TerminalScreen screen;

    private static final String rButton = "®";
    private static final String withLife = "❤";
    private static final HexColorString backgroundColor = new HexColorString("E0A21D");
    private static final HexColorString textColor = new HexColorString("000000");
    private static final HexColorString divideSectionColor = new HexColorString("1");

    public LanternaInfoBarComponent(TerminalScreen screen) {
        this.screen = screen;
    }

    @Override
    public synchronized void draw(InfoBarModel model) {
        TextGraphics graphics = screen.newTextGraphics();

        graphics.setBackgroundColor(TextColor.Factory.fromString(backgroundColor.toString()));


        char[] scoreArray;
        Score points = new Score(model.getScore());
        try {
            scoreArray = points.pointsToArray3();
        } catch (IllegalConversionException e) {
            scoreArray = new char[]{'9', '9', '9'};
        }

        int barHeight = 0;
        for (int i = 0; i < GlobalConfigs.LEVEL_WIDTH; i++) {
            graphics.setForegroundColor(TextColor.Factory.fromString(textColor.toString()));

            String toDraw = " ";
            int value = -1;
            switch(i) {
                case 0:
                    value = model.getCurrentLevel();
                    break;
                case 1: case 9: case 12: case 5: case 16:
                    graphics.setForegroundColor(TextColor.Factory.fromString(divideSectionColor.toString()));
                    toDraw = "│";
                    break;
                case 2:
                    toDraw = ""+scoreArray[0];
                    break;
                case 3:
                    toDraw = ""+scoreArray[1];
                    break;
                case 4:
                    toDraw = ""+scoreArray[2];
                    break;
                case 6:
                    value = model.getKeys();
                    break;
                case 7:
                    toDraw = "/";
                    break;
                case 8:
                    value = model.getMaxKeys();
                    break;
                case 10:
                    value = model.getTime() / 10;
                    break;
                case 11:
                    value = model.getTime() % 10;
                    break;
                case 13:
                    graphics.setForegroundColor(TextColor.Factory.fromString(divideSectionColor.toString()));
                    if(model.getLives() < 3)
                        graphics.setForegroundColor(TextColor.Factory.fromString(textColor.toString()));
                    toDraw = withLife;
                    break;
                case 14:
                    graphics.setForegroundColor(TextColor.Factory.fromString(divideSectionColor.toString()));
                    if(model.getLives() < 2)
                        graphics.setForegroundColor(TextColor.Factory.fromString(textColor.toString()));
                    toDraw = withLife;
                    break;
                case 15:
                    graphics.setForegroundColor(TextColor.Factory.fromString(divideSectionColor.toString()));
                    toDraw = withLife;
                    break;
                case 17:
                    toDraw = rButton;
                    break;
            }
            if (value != -1) toDraw = Integer.toString(value);
            graphics.putString(new TerminalPosition(i, barHeight), toDraw);
        }
    }
}
