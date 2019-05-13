package com.asciiraider.g710.model.level;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LevelManagerTest {
	private LevelManager levelManager = new LevelManager(32, 3);

	@Test
	public void currentLevel1(){
		levelManager.resetLevels();
		assertEquals(0, levelManager.getCurrentLevelIndex());
	}

	@Test
	public void nextLevel1(){
		levelManager.resetLevels();

		levelManager.nextLevel();
		assertEquals(1, levelManager.getCurrentLevelIndex());
	}

	@Test
	public void nextLevel2(){
		levelManager.resetLevels();
		levelManager.nextLevel();
		levelManager.nextLevel();
		assertEquals(2, levelManager.getCurrentLevelIndex());
	}

	@Test
	public void resetLevel(){
		levelManager.resetLevels();
		levelManager.nextLevel();
		levelManager.resetLevels();
		assertEquals(levelManager.getCurrentLevelIndex(), 0);
	}
}
