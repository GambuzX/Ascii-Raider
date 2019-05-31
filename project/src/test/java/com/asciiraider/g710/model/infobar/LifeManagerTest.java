package com.asciiraider.g710.model.infobar;

import org.junit.Before;
import org.junit.Test;

import java.security.InvalidParameterException;

import static junit.framework.TestCase.*;

public class LifeManagerTest {
	LifeManager lifeManager;

	@Before
	public void	setUp(){
		lifeManager = new LifeManager(3);
	}

	@Test(expected = InvalidParameterException.class)
	public void constructor1(){
		LifeManager lifeManager1 = new LifeManager(0);
	}

	@Test
	public void getInitialLife(){
		assertEquals(3, lifeManager.getInitialLife());
	}

	@Test
	public void updateDeath(){
		lifeManager.updateDeath();
		lifeManager.updateDeath();
		assertEquals(1, lifeManager.getCurrentLife());
	}

	@Test
	public void hasLife1(){
		lifeManager.updateDeath();
		lifeManager.updateDeath();
		assertTrue(lifeManager.hasLifes());
	}

	@Test
	public void hasLife2(){
		lifeManager.updateDeath();
		lifeManager.updateDeath();
		lifeManager.updateDeath();
		assertFalse(lifeManager.hasLifes());
	}
}
