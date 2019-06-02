package com.asciiraider.g710.model.level;

import com.asciiraider.g710.GlobalConfigs;
import com.asciiraider.g710.controller.element.interaction.*;
import com.asciiraider.g710.model.element.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.mockito.Mockito.*;

public class LevelBuilderTest {
	LevelBuilder levelBuilder;
	LevelModel levelMock;

	@Before
	public void setUp(){
		levelBuilder = new LevelBuilder();

		levelMock = mock(LevelModel.class);

	}

	@Test
	public void testWall() throws InvalidLevelException {
		levelBuilder.buildLevel(levelMock,1);
		ArgumentCaptor<Wall> argument = ArgumentCaptor.forClass(Wall.class);
		verify(levelMock, times(45)).addWall(argument.capture());
		assertEquals(0, argument.getAllValues().get(0).getPosition().getX());
		assertTrue(argument.getAllValues().get(0).getPlayerInteraction() instanceof BarrierInteraction);
	}

	@Test
	public void testStone() throws InvalidLevelException {
		levelBuilder.buildLevel(levelMock,1);
		ArgumentCaptor<StoneBlock> argument = ArgumentCaptor.forClass(StoneBlock.class);
		verify(levelMock, times(1)).addStoneBlock(argument.capture());
		assertEquals(1, argument.getValue().getPosition().getX());
		assertTrue(argument.getValue().getPlayerInteraction() instanceof BarrierInteraction);
	}

	@Test
	public void testBoulder() throws InvalidLevelException {
		levelBuilder.buildLevel(levelMock,1);
		ArgumentCaptor<Boulder> argument = ArgumentCaptor.forClass(Boulder.class);
		verify(levelMock, times(1)).addBoulder(argument.capture());
		assertEquals(2, argument.getValue().getPosition().getX());
		assertTrue(argument.getValue().getPlayerInteraction() instanceof PushInteraction);

	}

	@Test
	public void testEnemy() throws InvalidLevelException {
		levelBuilder.buildLevel(levelMock,1);
		ArgumentCaptor<Enemy> argument = ArgumentCaptor.forClass(Enemy.class);
		verify(levelMock, times(2)).addEnemy(argument.capture());
		List<Enemy> enemies = argument.getAllValues();

		assertTrue(enemies.get(0) instanceof SkullEnemy);
		assertEquals(4, enemies.get(0).getPosition().getX());
		assertTrue(enemies.get(0).getPlayerInteraction() instanceof DeathInteraction);

		assertTrue(enemies.get(1) instanceof MummyEnemy);
		assertEquals(5, enemies.get(1).getPosition().getX());
		assertTrue(enemies.get(1).getPlayerInteraction() instanceof DeathInteraction);

	}

	@Test
	public void testTNT() throws InvalidLevelException {
		levelBuilder.buildLevel(levelMock,1);
		ArgumentCaptor<TNT> argument = ArgumentCaptor.forClass(TNT.class);
		verify(levelMock, times(1)).addTNT(argument.capture());
		assertEquals(6, argument.getValue().getPosition().getX());
		assertTrue(argument.getValue().getPlayerInteraction() instanceof PushInteraction);
	}

	@Test
	public void testSand() throws InvalidLevelException {
		levelBuilder.buildLevel(levelMock,1);
		ArgumentCaptor<Sand> argument = ArgumentCaptor.forClass(Sand.class);
		verify(levelMock, times(1)).addSandBlock(argument.capture());
		assertEquals(7, argument.getValue().getPosition().getX());
		assertTrue(argument.getValue().getPlayerInteraction() instanceof SandInteraction);
	}

	@Test
	public void testLevelKey() throws InvalidLevelException {
		levelBuilder.buildLevel(levelMock,1);
		ArgumentCaptor<LevelKey> argument = ArgumentCaptor.forClass(LevelKey.class);
		verify(levelMock, times(1)).addLevelKey(argument.capture());
		assertEquals(8, argument.getValue().getPosition().getX());
		assertTrue(argument.getValue().getPlayerInteraction() instanceof PushInteraction);
	}

	@Test
	public void testPlayer() throws InvalidLevelException {
		levelBuilder.buildLevel(levelMock,1);
		ArgumentCaptor<Player> argument = ArgumentCaptor.forClass(Player.class);
		verify(levelMock, times(1)).setPlayer(argument.capture());
		assertEquals(3, argument.getValue().getPosition().getX());
	}

	@Test
	public void testExitDoor() throws InvalidLevelException {
		levelBuilder.buildLevel(levelMock,1);
		ArgumentCaptor<ExitDoor> argument = ArgumentCaptor.forClass(ExitDoor.class);
		verify(levelMock, times(1)).setExitDoor(argument.capture());
		assertEquals(9, argument.getValue().getPosition().getX());
		assertTrue(argument.getValue().getPlayerInteraction() instanceof BarrierInteraction);
	}

	@Test
	public void testDoor() throws InvalidLevelException {
		levelBuilder.buildLevel(levelMock,1);
		ArgumentCaptor<Door> argument = ArgumentCaptor.forClass(Door.class);
		verify(levelMock, times(1)).setDoor(argument.capture());
		assertEquals(10, argument.getValue().getPosition().getX());
		assertTrue(argument.getValue().getPlayerInteraction() instanceof BarrierInteraction);
	}

	@Test
	public void testKey() throws InvalidLevelException {
		levelBuilder.buildLevel(levelMock,1);
		ArgumentCaptor<DoorKey> argument = ArgumentCaptor.forClass(DoorKey.class);
		verify(levelMock, times(1)).setDoorKey(argument.capture());
		assertEquals(11, argument.getValue().getPosition().getX());
		assertTrue(argument.getValue().getPlayerInteraction() instanceof DoorKeyInteraction);
	}

	@Test
	public void testTimer() throws InvalidLevelException {
		levelBuilder.buildLevel(levelMock, 1);
		ArgumentCaptor<Integer> argument = ArgumentCaptor.forClass(Integer.class);
		verify(levelMock, times(1)).setTime(argument.capture());
		assertTrue(argument.getValue().equals(1));
	}

	@Test
	public void testVertical() throws InvalidLevelException {
		levelBuilder.buildLevel(levelMock,10);
		ArgumentCaptor<ExitDoor> argument = ArgumentCaptor.forClass(ExitDoor.class);
		verify(levelMock, times(1)).setExitDoor(argument.capture());
		assertEquals(1, argument.getValue().getPosition().getY());
	}

	@Test(expected = InvalidLevelException.class)
	public void constructor1() throws InvalidLevelException {
		levelBuilder.buildLevel(levelMock,2);
	}

	@Test(expected = InvalidLevelException.class)
	public void constructor2() throws InvalidLevelException {
		levelBuilder.buildLevel(levelMock,3);
	}

	@Test(expected = InvalidLevelException.class)
	public void constructor3() throws InvalidLevelException {
		levelBuilder.buildLevel(levelMock,4);
	}

	@Test(expected = InvalidLevelException.class)
	public void constructor4() throws InvalidLevelException {
		levelBuilder.buildLevel(levelMock,5);
	}

	@Test(expected = InvalidLevelException.class)
	public void constructor5() throws InvalidLevelException {
		levelBuilder.buildLevel(levelMock,6);
	}

	@Test(expected = InvalidLevelException.class)
	public void constructor6() throws InvalidLevelException {
		levelBuilder.buildLevel(levelMock,7);
	}

	@Test(expected = InvalidLevelException.class)
	public void constructor7() throws InvalidLevelException {
		levelBuilder.buildLevel(levelMock,8);
	}

	@Test(expected = InvalidLevelException.class)
	public void constructor8() throws InvalidLevelException {
		levelBuilder.buildLevel(levelMock,9);
	}

	@Test
	public void buildAllLevels() throws InvalidLevelException {
		LevelBuilder levelBuilderMock = spy(LevelBuilder.class);
		final int[] counter = new int[1];

		Answer<Integer> answer = new Answer<Integer>() {
			@Override
			public Integer answer(InvocationOnMock invocation) throws Throwable {
				counter[0]++;
				return 1;
			}
		};

		doAnswer(answer).when(levelBuilderMock).buildLevel(any(), anyInt());

		List<LevelModel> levelModels = levelBuilderMock.buildAllLevels();

		assertEquals(GlobalConfigs.LEVEL_COUNT, counter[0]);
	}

	@Test
	public void buildAllLevels2(){
		assertEquals(12, levelBuilder.buildAllLevels().size());
	}


}
