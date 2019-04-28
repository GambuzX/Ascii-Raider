package com.asciiraider.g710.model.element;

import com.asciiraider.g710.model.utilities.Position;
import com.asciiraider.g710.model.utilities.Symbol;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

abstract public class Element implements Cloneable, Drawable {
	private Position position;
	private Symbol symbol;

	public Element(Position position, Symbol symbol) {
		this.position = position;
		this.symbol = symbol;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position){
		this.position = position;
	}

	public Symbol getSymbol() {
		return symbol;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Element)) return false;
		Element element = (Element) o;
		return getSymbol() == element.getSymbol() &&
				getPosition().equals(element.getPosition());
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	@Override
	public void draw(TextGraphics graphics) {
		graphics.setForegroundColor(TextColor.Factory.fromString(symbol.getForegroundColorString()));
		graphics.setBackgroundColor(TextColor.Factory.fromString(symbol.getBackgroundColorString()));
		graphics.putString(new TerminalPosition(position.getX(), position.getY()), ""+symbol.getAscii());
	}
}
