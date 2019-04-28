package com.asciiraider.g710.view;

import com.asciiraider.g710.model.element.Element;
import com.asciiraider.g710.model.level.Level;
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
import org.jetbrains.annotations.NotNull;

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

	public void drawElements(Level level) throws IOException {
		screen.clear();
		TextGraphics graphics = screen.newTextGraphics();
		List<Element> levelEles = level.getElements();
		for (Element ele : levelEles)
			drawElement(ele, graphics);
		screen.refresh();
	}

	private void drawElement(@NotNull Element ele, @NotNull TextGraphics graphics) {
		Position pos = ele.getPosition();
		Symbol sym = ele.getSymbol();

		graphics.setForegroundColor(TextColor.Factory.fromString(sym.getForegroundColorString()));
		graphics.setBackgroundColor(TextColor.Factory.fromString(sym.getBackgroundColorString()));
		graphics.putString(new TerminalPosition(pos.getX(), pos.getY()), ""+sym.getAscii());

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
