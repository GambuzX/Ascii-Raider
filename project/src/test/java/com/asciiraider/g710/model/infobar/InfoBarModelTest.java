package com.asciiraider.g710.model.infobar;

import com.asciiraider.g710.GlobalConfigs;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class InfoBarModelTest {
	InfoBarModel infoBarModel;

	@Before
	public void setUp(){
		infoBarModel = new InfoBarModel(4, 4, 12);
	}

	@Test
	public void setTime(){
		infoBarModel.setTime(5);
		assertEquals(5, infoBarModel.getTime());
	}

	@Test
	public void updateLevelKey(){
		infoBarModel.updateLevelKey();
		infoBarModel.updateLevelKey();
		assertEquals(2, infoBarModel.getKeys());
	}

	 @Test
	public void updateDeath(){
		infoBarModel.updateDeath();
		infoBarModel.updateDeath();
		assertEquals(GlobalConfigs.PLAYER_HP - 2, infoBarModel.getLives());
	 }

	 @Test
	public void updateNumKeys1(){
		infoBarModel.updateNumKeys(5);
		assertEquals(5, infoBarModel.getMaxKeys());
	 }

	@Test
	public void updateNumKeys2(){
		infoBarModel.updateLevelKey();
		infoBarModel.updateNumKeys(5);
		assertEquals(0, infoBarModel.getKeys());
	}

	@Test
	public void updateNumKeys3(){
		infoBarModel.updateNumKeys(5);
		assertEquals(5, infoBarModel.getCurrentLevel());
	}

	@Test
	public void updateScore(){
		infoBarModel.updateScore(12);
		assertEquals(24, infoBarModel.getScore());
	}
}
