package com.asciiraider.g710.view;

import com.asciiraider.g710.controller.level.LevelFacade;
import com.asciiraider.g710.model.element.Element;
import com.asciiraider.g710.model.level.LevelModel;
import com.asciiraider.g710.model.utilities.Position;
import com.asciiraider.g710.model.utilities.Symbol;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.TerminalScreen;

import java.io.IOException;

public class LevelView extends TerminalView<LevelModel>{

	public LevelView(TerminalScreen terminal) throws IOException {
		super(terminal);
	}

	// TODO: synchronized adicionado aqui e ao physics ver melhor o efeito
	public synchronized void draw(LevelModel levelModel) {
		TextGraphics graphics = screen.newTextGraphics();

		// TODO: ver isto
		LevelFacade levelModelF = new LevelFacade(levelModel);

		for (Element ele : levelModelF.getElements())
			drawElement(graphics, ele);

		try {
			screen.refresh();
		} catch (IOException e) {
			e.printStackTrace();
		}

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
