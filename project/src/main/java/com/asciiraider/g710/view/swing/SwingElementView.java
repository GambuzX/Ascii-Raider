package com.asciiraider.g710.view.swing;

import com.asciiraider.g710.model.element.Element;
import com.asciiraider.g710.view.View;

import java.awt.*;

public class SwingElementView extends View<Element> {
	private Graphics graphics;
	private SymbolMapper symbolMapper;
	private int sizeFactor;

	public SwingElementView(Graphics graphics, SymbolMapper symbolMapper, int sizeFactor){
		this.graphics = graphics;
		this.symbolMapper = symbolMapper;
		this.sizeFactor = sizeFactor;
	}

	@Override
	public void draw(Element model) {
		graphics.drawImage(symbolMapper.getElementImage(model), model.getPosition().getX() * sizeFactor, model.getPosition().getY() * sizeFactor, null);
	}
}
