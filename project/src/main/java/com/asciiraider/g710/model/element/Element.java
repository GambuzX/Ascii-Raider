package com.asciiraider.g710.model.element;

import com.asciiraider.g710.controller.element.interaction.Interaction;
import com.asciiraider.g710.model.Model;
import com.asciiraider.g710.model.utilities.Position;
import com.asciiraider.g710.model.utilities.Symbol;

abstract public class Element extends Model implements Cloneable {
	private Position position;
	private Symbol symbol;
	private Interaction playerInteraction = null;

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

	public void setSymbol(Symbol symbol){
		this.symbol = symbol;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Element)) return false;
		Element element = (Element) o;
		return getSymbol() == element.getSymbol() &&
				getPosition().equals(element.getPosition());
	}

	public Interaction getPlayerInteraction() {
		return playerInteraction;
	}

	public void setPlayerInteraction(Interaction playerInteraction) {
		this.playerInteraction = playerInteraction;
	}
}
