package com.asciiraider.g710.model.level;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LevelManagerTest {
	private LevelManager levelManager = new LevelManager();

	@Test
	public void currentLevel1(){
		assertEquals(levelManager.getCurrentLevel(), 0);
	}

	@Test
	public void nextLevel1(){
		levelManager.nextLevel();
		assertEquals(levelManager.getCurrentLevel(), 1);
	}

	@Test
	public void resetLevel(){
		levelManager.nextLevel();
		levelManager.resetLevel();
		assertEquals(levelManager.getCurrentLevel(), 0);
	}
}
