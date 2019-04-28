package com.asciiraider.g710.view;

import com.asciiraider.g710.model.element.Element;
import com.asciiraider.g710.model.level.Level;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.SwingTerminalFontConfiguration;

import java.awt.*;
import java.io.IOException;
import java.util.List;

public class LevelView {
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
	public synchronized void drawElements(Level level) throws IOException {
		screen.clear();
		TextGraphics graphics = screen.newTextGraphics();
		List<Element> levelEles = level.getElements();
		for (Element ele : levelEles)
			ele.draw(graphics);
		screen.refresh();
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
