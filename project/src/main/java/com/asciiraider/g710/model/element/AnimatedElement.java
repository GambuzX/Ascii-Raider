package com.asciiraider.g710.model.element;

import com.asciiraider.g710.model.utilities.Animation;
import com.asciiraider.g710.model.utilities.Position;
import com.asciiraider.g710.model.utilities.Symbol;

public class AnimatedElement extends Element {
	private Animation animation;

	public AnimatedElement(Position position, Animation animation, int fps) {
		super(position, animation.getNextSymbol(fps));
		this.animation = animation;
	}

	public boolean updateAnimation(int fps){
		Symbol newSymbol = animation.getNextSymbol(fps);
		if(newSymbol == null)
			return false;
		setSymbol(newSymbol);
		return true;
	}
}
