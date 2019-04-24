package com.asciiraider.g710.view;

import com.asciiraider.g710.model.element.Element;
import com.asciiraider.g710.model.element.Position;
import com.asciiraider.g710.model.element.Symbol;
import com.asciiraider.g710.model.level.Level;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;
import java.util.List;

public class LevelView {
    private final TerminalScreen screen;
    private Level level;

    public LevelView(Level level, int width, int height) throws IOException {
        Terminal terminal = new DefaultTerminalFactory().setInitialTerminalSize(new TerminalSize(width, height)).createTerminal();
        screen = new TerminalScreen(terminal);

        screen.setCursorPosition(null);
        screen.startScreen();
        screen.doResizeIfNecessary();

        this.level = level;
    }

    public void drawElements() throws IOException {
        screen.clear();
        TextGraphics graphics = screen.newTextGraphics();
        List<Element> levelEles = level.getElements();
        for (Element ele : levelEles)
            drawElement(ele, graphics);
        screen.refresh();
    }

    private void drawElement(Element ele, TextGraphics graphics) {
        Position pos = ele.getPosition();
        Symbol sym = ele.getSymbol();

        graphics.setForegroundColor(TextColor.Factory.fromString(sym.getForegroundColor()));
        graphics.setBackgroundColor(TextColor.Factory.fromString(sym.getBackgroundColor()));
        graphics.putString(new TerminalPosition(pos.getX(), pos.getY()), ""+sym.getAscii());

    }
}
