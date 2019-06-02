package com.asciiraider.g710.model.element;

import com.asciiraider.g710.model.utilities.Animation;
import com.asciiraider.g710.model.utilities.Position;
import com.asciiraider.g710.model.utilities.Symbol;

public class AnimatedElement extends Element {
	private Animation animation;

	public AnimatedElement(Position position, Animation animation) {
		super(position, animation.getNextSymbol());
		this.animation = animation;
	}

	public boolean updateAnimation(){
		Symbol newSymbol = animation.getNextSymbol();
		if(newSymbol == null)
			return false;
		setSymbol(newSymbol);
		return true;
	}
}
