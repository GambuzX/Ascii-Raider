package com.asciiraider.g710.model.level;

import com.asciiraider.g710.controller.level.LevelFacade;
import com.asciiraider.g710.model.element.LevelKey;
import com.asciiraider.g710.model.infobar.LifeManager;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class LevelManagerTest {
	private LevelManager levelManager;
	private List<LevelModel> levelMocks;
	private LifeManager lifeManagerMock;
	private List<LevelKey> levelKeys;

	@Before
	public void setUp(){
		LevelBuilder mockLB = mock(LevelBuilder.class);
		levelKeys = new ArrayList<>();
		LevelKey lk = mock(LevelKey.class);
		levelKeys.add(lk);
		levelKeys.add(lk);
		levelKeys.add(lk);


		levelMocks = new ArrayList<>();
		LevelModel lM1 = mock(LevelModel.class);
		when(lM1.getLevelTime()).thenReturn(1);
		when(lM1.getLevelKeys()).thenReturn(levelKeys);
		LevelModel lM2 = mock(LevelModel.class);
		when(lM2.getLevelTime()).thenReturn(2);
		when(lM2.getLevelKeys()).thenReturn(levelKeys);
		LevelModel lM3 = mock(LevelModel.class);
		when(lM3.getLevelTime()).thenReturn(3);
		when(lM3.getLevelKeys()).thenReturn(levelKeys);

		levelMocks.add(lM1);
		levelMocks.add(lM2);
		levelMocks.add(lM3);

		when(mockLB.buildAllLevels()).thenReturn(levelMocks);

		lifeManagerMock = mock(LifeManager.class);
		when(lifeManagerMock.getCurrentLife()).thenReturn(2);
		when(lifeManagerMock.hasLifes()).thenReturn(false);

		levelManager = new LevelManager(mockLB, lifeManagerMock);


	}

	@Test
	public void startedTimer(){
		assertTrue(levelManager.getTimeAlarm().isRunning());
	}

	@Test
	public void currentLevel1(){
		assertEquals(0, levelManager.getCurrentLevelIndex());
	}

	@Test
	public void nextLevel1(){

		levelManager.nextLevel();
		assertEquals(1, levelManager.getCurrentLevelIndex());
	}

	@Test
	public void nextLevel2(){
		levelManager.nextLevel();
		levelManager.nextLevel();
		assertEquals(2, levelManager.getCurrentLevelIndex());
	}

	@Test
	public void nextLevel3(){
		levelManager.nextLevel();
		assertFalse(levelManager.isGameFinished());
	}

	@Test
	public void nextLevel4(){
		levelManager.nextLevel();
		levelManager.nextLevel();
		assertFalse(levelManager.isGameFinished());
	}

	@Test
	public void nextLevel5(){
		levelManager.nextLevel();
		assertEquals(2, levelManager.getTimeAlarm().getCurrentTime());
	}


	@Test
	public void isGameFinished1(){
		assertFalse(levelManager.isGameFinished());
	}

	@Test
	public void isGameFinished2(){
		levelManager.nextLevel();
		levelManager.nextLevel();
		levelManager.nextLevel();
		assertTrue(levelManager.isGameFinished());
	}

	@Test
	public void resetLevels1(){
		levelManager.nextLevel();
		levelManager.resetLevels();
		assertEquals(0, levelManager.getCurrentLevelIndex());
	}

	@Test
	public void resetLevels2(){
		LevelBuilder mockLB = mock(LevelBuilder.class);

		when(mockLB.buildAllLevels()).thenReturn(levelMocks);
		LevelManager levelManager1 = new LevelManager(mockLB, lifeManagerMock);
		levelManager1.resetLevels();
		verify(mockLB, times(2)).buildAllLevels();
	}

	@Test
	public void resetLevels3(){
		levelManager.updateLevelKey();
		levelManager.updateLevelKey();
		levelManager.resetLevels();
		assertEquals(3, levelManager.getCurrentLevelKeys());
	}

	@Test
	public void resetLevel(){
		LevelBuilder mockLB = mock(LevelBuilder.class);

		when(mockLB.buildAllLevels()).thenReturn(levelMocks);
		LevelManager levelManager1 = new LevelManager(mockLB, lifeManagerMock);
		int levelIndex = 1;
		levelManager1.resetLevel(levelIndex);
		verify(mockLB, times(1)).buildLevel(levelIndex+1);
		verify(mockLB, times(0)).buildLevel(levelIndex);

	}

	@Test
	public void getCurrentLevel(){
		assertEquals(1, levelManager.getCurrentLevel().getLevelTime());
	}

	@Test
	public void finishGame(){
		levelManager.finishGame();
		assertTrue(levelManager.isGameFinished());
	}

	@Test
	public  void getTimeAlarm(){
		LevelTimeAlarm timeAlarm = levelManager.getTimeAlarm();
		assertEquals(1, timeAlarm.getCurrentTime());
	}

	@Test
	public void getCurrentLevelKeys(){
		assertEquals(3, levelManager.getCurrentLevelKeys());
	}

	@Test
	public void getLevelModel1(){
		assertEquals(1, levelManager.getCurrentLevel().getLevelTime());
	}

	@Test
	public void getLevelModel2(){
		levelManager.nextLevel();
		levelManager.nextLevel();
		levelManager.nextLevel();
		assertEquals(1, levelManager.getCurrentLevel().getLevelTime());
	}

	@Test
	public void updateLevelKeys(){
		levelManager.updateLevelKey();
		assertEquals(2, levelManager.getCurrentLevelKeys());
	}

	@Test
	public void lifeManager(){
		assertEquals(2, levelManager.getLifeManager().getCurrentLife());
	}

	@Test
	public void levelFacade(){
		LevelFacade levelFacade = levelManager.getCurrentLevelFacade();
		when(levelFacade.getLevelKeys()).thenReturn(levelKeys);
		assertEquals(3, levelFacade.getLevelKeys().size());
	}
}
