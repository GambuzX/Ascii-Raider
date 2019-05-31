package com.asciiraider.g710.model.element;

import com.asciiraider.g710.GlobalConfigs;
import com.asciiraider.g710.model.utilities.Position;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.mock;

// TODO: ver este teste
public class ExplosionTest {
	@Test
	public void explosionAnimation(){
		Position position = mock(Position.class);
		Explosion explosion = new Explosion(position);

		assertEquals('●', explosion.getSymbol().getAscii());
	}

	@Test
	public void explosionAnimation2(){
		Position position = mock(Position.class);
		Explosion explosion = new Explosion(position);

		for(int i = 0; i <= GlobalConfigs.ANIMATION_DURATION * GlobalConfigs.FPS / 3; i++)
			explosion.updateAnimation();
		explosion.updateAnimation();

		assertEquals('⦁', explosion.getSymbol().getAscii());
	}


	@Test
	public void explosionAnimation3(){
		Position position = mock(Position.class);
		Explosion explosion = new Explosion(position);

		for(int i = 0; i <= 2 * GlobalConfigs.ANIMATION_DURATION * GlobalConfigs.FPS / 3; i++)
			explosion.updateAnimation();
		explosion.updateAnimation();

		assertEquals('٠', explosion.getSymbol().getAscii());
	}
}
