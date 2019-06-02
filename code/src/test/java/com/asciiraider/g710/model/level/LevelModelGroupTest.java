package com.asciiraider.g710.model.level;

import com.asciiraider.g710.model.infobar.InfoBarModel;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class LevelModelGroupTest {
	@Test
	public void getLevelManager(){
		LevelModelGroup levelModelGroup = new LevelModelGroup();
		assertTrue(levelModelGroup.getLevelManager() instanceof LevelManager);
	}

	@Test
	public void getLevelModel(){
		LevelModelGroup levelModelGroup = new LevelModelGroup();
		assertTrue(levelModelGroup.getLevelModel() instanceof LevelModel);
	}

	@Test
	public void getInfoBarModel(){
		LevelModelGroup levelModelGroup = new LevelModelGroup();
		assertTrue(levelModelGroup.getInfoBarModel() instanceof InfoBarModel);
		assertEquals(1, levelModelGroup.getInfoBarModel().getCurrentLevel());
	}
}
