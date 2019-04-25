package com.asciiraider.g710.model.level;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LevelManagerTest {
	private LevelManager levelManager = LevelManager.getInstance();

	@Test
	public void currentLevel1(){
		levelManager.resetLevel();
		assertEquals(levelManager.getCurrentLevelIndex(), 0);
	}

	@Test
	public void nextLevel1(){
		levelManager.resetLevel();
		levelManager.nextLevel();
		assertEquals(levelManager.getCurrentLevelIndex(), 1);
	}

	@Test
	public void resetLevel(){
		levelManager.resetLevel();
		levelManager.nextLevel();
		levelManager.resetLevel();
		assertEquals(levelManager.getCurrentLevelIndex(), 0);
	}
}
