package com.asciiraider.g710.view.lanterna;

import com.asciiraider.g710.model.element.Element;
import com.asciiraider.g710.model.utilities.Position;
import com.asciiraider.g710.model.utilities.Symbol;
import com.asciiraider.g710.view.View;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.TerminalScreen;

public class LanternaElementView extends View<Element> {
	private TerminalScreen screen;

	public LanternaElementView(TerminalScreen screen){
		this.screen = screen;
	}

	@Override
	public void draw(Element model) {
		TextGraphics graphics = screen.newTextGraphics();

		Symbol symbol = model.getSymbol();
		Position position = model.getPosition();

		graphics.setForegroundColor(TextColor.Factory.fromString(symbol.getForegroundColorString()));
		graphics.setBackgroundColor(TextColor.Factory.fromString(symbol.getBackgroundColorString()));
		graphics.putString(new TerminalPosition(position.getX(), position.getY()+1), ""+symbol.getAscii());
	}
}
