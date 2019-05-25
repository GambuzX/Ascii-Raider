package com.asciiraider.g710.model.element;

import com.asciiraider.g710.GlobalConfigs;
import com.asciiraider.g710.model.utilities.Animation;
import com.asciiraider.g710.model.utilities.HexColorString;
import com.asciiraider.g710.model.utilities.Position;
import com.asciiraider.g710.model.utilities.Symbol;

public class Explosion extends AnimatedElement {

	public Explosion(Position position) {
		super(position, explosionAnimation());
	}

	static public Animation explosionAnimation() {
		Animation explosionAnimation = new Animation(GlobalConfigs.ANIMATION_DURATION, false);
		explosionAnimation.addSymbol(new Symbol('●', new HexColorString("FF0000")));
		explosionAnimation.addSymbol(new Symbol('⦁', new HexColorString("FF8C00")));
		explosionAnimation.addSymbol(new Symbol('٠', new HexColorString("FFFF00")));
		return explosionAnimation;
	}
}
