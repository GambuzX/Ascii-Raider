package com.asciiraider.g710.model.level;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class LevelTimeAlarmTest {
	private LevelTimeAlarm levelTimeAlarm;

	@Before
	public void setUp(){
		levelTimeAlarm = new LevelTimeAlarm(5);
	}

	@Test
	public void updateDeath1(){
		levelTimeAlarm.start();
		levelTimeAlarm.decTimer();
		levelTimeAlarm.updateDeath();
		assertEquals(5, levelTimeAlarm.getCurrentTime());
	}

	@Test
	public void updateDeath2(){
		levelTimeAlarm.decTimer();
		levelTimeAlarm.updateDeath();
		assertTrue(levelTimeAlarm.isRunning());
	}

	@Test
	public void updateScore(){
		levelTimeAlarm.updateScore(123);
		assertTrue(levelTimeAlarm.isRunning());
	}

	@Test
	public void updateNumKeys(){
		levelTimeAlarm.updateNumKeys(123);
	}


}
