package com.asciiraider.g710.model.element;

import com.asciiraider.g710.view.Drawable;

abstract public class Element implements Drawable, Cloneable {
	private Position position;
	// TODO: se calhar nao devia ser obrigatoriamente char
	private char symbol;

	public Element(Position position, char symbol) {
		this.position = position;
		this.symbol = symbol;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position){
		this.position = position;
	}

	public char getSymbol() {
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
	public void draw(){
		// TODO: implentar
		System.out.println("draw: to be implemented");
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
