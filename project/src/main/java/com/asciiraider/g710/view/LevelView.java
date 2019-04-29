package com.asciiraider.g710.view;

import com.asciiraider.g710.model.element.Element;
import com.asciiraider.g710.model.level.LevelModel;
import com.asciiraider.g710.model.utilities.Position;
import com.asciiraider.g710.model.utilities.Symbol;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.SwingTerminalFontConfiguration;

import java.awt.*;
import java.io.IOException;
import java.util.List;

public class LevelView extends View<LevelModel>{
	private final TerminalScreen screen;
	public LevelView(int width, int height, int size) throws IOException {
		Font font = new Font("DejaVu Sans Mono", Font.PLAIN,  size);
		SwingTerminalFontConfiguration cfg = SwingTerminalFontConfiguration.newInstance(font);

		Terminal terminal = new DefaultTerminalFactory().setTerminalEmulatorFontConfiguration(cfg).setInitialTerminalSize(new TerminalSize(width, height)).createTerminal();
		screen = new TerminalScreen(terminal);

		screen.setCursorPosition(null);
		screen.startScreen();
		screen.doResizeIfNecessary();
	}

	// TODO: synchronized adicionado aqui e ao physics ver melhor o efeito
	public synchronized void draw(LevelModel levelModel) throws IOException {
		screen.clear();
		TextGraphics graphics = screen.newTextGraphics();
		List<Element> levelEles = levelModel.getElements();
		for (Element ele : levelEles)
			drawElement(graphics, ele);
		screen.refresh();
	}

	public void drawElement(TextGraphics graphics, Element element) {
		Symbol symbol = element.getSymbol();
		Position position = element.getPosition();

		graphics.setForegroundColor(TextColor.Factory.fromString(symbol.getForegroundColorString()));
		graphics.setBackgroundColor(TextColor.Factory.fromString(symbol.getBackgroundColorString()));
		graphics.putString(new TerminalPosition(position.getX(), position.getY()), ""+symbol.getAscii());
	}


	public Event getKey() {
		try {
			return KeyPressEvent.handle(screen.readInput());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return Event.OTHER;
	}
}
