package com.asciiraider.g710.model.level;

import com.asciiraider.g710.model.element.*;
import com.asciiraider.g710.model.utilities.Position;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LevelModelTest {
	LevelModel levelModel;
	Position mockPos;

	@Before
	public void setUp(){
		levelModel = new LevelModel();

		mockPos = mock(Position.class);
		when(mockPos.getX()).thenReturn(2);
		when(mockPos.getY()).thenReturn(2);

	}

	@Test
	public void setPlayer(){
		Player playerMock = mock(Player.class);
		when(playerMock.getPosition()).thenReturn(mockPos);
		levelModel.setPlayer(playerMock);
		assertEquals(2, levelModel.getPlayer().getPosition().getX());
	}

	@Test
	public void setExitDoor(){
		ExitDoor exitDoor = mock(ExitDoor.class);
		when(exitDoor.getPosition()).thenReturn(mockPos);
		levelModel.setExitDoor(exitDoor);
		assertTrue( levelModel.getElementsMatrix()[mockPos.getX()][mockPos.getY()] instanceof ExitDoor);
	}

	@Test
	public void setDoor(){
		Door door = mock(Door.class);
		when(door.getPosition()).thenReturn(mockPos);
		levelModel.setDoor(door);
		assertTrue( levelModel.getElementsMatrix()[mockPos.getX()][mockPos.getY()] instanceof Door);
	}

	@Test
	public void setDoorKey(){
		DoorKey doorkey = mock(DoorKey.class);
		when(doorkey.getPosition()).thenReturn(mockPos);
		levelModel.setDoorKey(doorkey);
		assertTrue( levelModel.getElementsMatrix()[mockPos.getX()][mockPos.getY()] instanceof DoorKey);
	}

	@Test
	public void getExitDoor(){
		ExitDoor exitDoor = mock(ExitDoor.class);
		when(exitDoor.getPosition()).thenReturn(mockPos);
		levelModel.setExitDoor(exitDoor);
		assertEquals(2, levelModel.getExitDoor().getPosition().getX());
	}

	@Test
	public void getDoor(){
		Door door = mock(Door.class);
		when(door.getPosition()).thenReturn(mockPos);
		levelModel.setDoor(door);
		assertEquals(2, levelModel.getDoor().getPosition().getX());
	}

	@Test
	public void getDoorKey(){
		DoorKey doorkey = mock(DoorKey.class);
		when(doorkey.getPosition()).thenReturn(mockPos);
		levelModel.setDoorKey(doorkey);
		assertEquals(2, levelModel.getDoorKey().getPosition().getX());
	}

	@Test
	public void addWall(){
		Wall wall = mock(Wall.class);
		when(wall.getPosition()).thenReturn(mockPos);
		levelModel.addWall(wall);
		assertTrue( levelModel.getElementsMatrix()[mockPos.getX()][mockPos.getY()] instanceof Wall);
	}

	@Test
	public void addBoulder(){
		Boulder boulder = mock(Boulder.class);
		when(boulder.getPosition()).thenReturn(mockPos);
		levelModel.addBoulder(boulder);
		assertTrue( levelModel.getElementsMatrix()[mockPos.getX()][mockPos.getY()] instanceof Boulder);
	}

	@Test
	public void addStoneBlock(){
		StoneBlock stoneBlock = mock(StoneBlock.class);
		when(stoneBlock.getPosition()).thenReturn(mockPos);
		levelModel.addStoneBlock(stoneBlock);
		assertTrue( levelModel.getElementsMatrix()[mockPos.getX()][mockPos.getY()] instanceof StoneBlock);
	}

	@Test
	public void addSandBlock(){
		Sand sand = mock(Sand.class);
		when(sand.getPosition()).thenReturn(mockPos);
		levelModel.addSandBlock(sand);
		assertTrue( levelModel.getElementsMatrix()[mockPos.getX()][mockPos.getY()] instanceof Sand);
	}

	@Test
	public void addTNT(){
		TNT tnt = mock(TNT.class);
		when(tnt.getPosition()).thenReturn(mockPos);
		levelModel.addTNT(tnt);
		assertTrue( levelModel.getElementsMatrix()[mockPos.getX()][mockPos.getY()] instanceof TNT);
	}

	@Test
	public void addLevelKey(){
		LevelKey levelKey = mock(LevelKey.class);
		when(levelKey.getPosition()).thenReturn(mockPos);
		levelModel.addLevelKey(levelKey);
		assertTrue( levelModel.getElementsMatrix()[mockPos.getX()][mockPos.getY()] instanceof LevelKey);
	}

	@Test
	public void addEnemy(){
		Enemy enemy = mock(Enemy.class);
		when(enemy.getPosition()).thenReturn(mockPos);
		levelModel.addEnemy(enemy);
		assertTrue( levelModel.getElementsMatrix()[mockPos.getX()][mockPos.getY()] instanceof Enemy);
	}

	@Test
	public void addExplosion(){
		Explosion explosion = mock(Explosion.class);
		when(explosion.getPosition()).thenReturn(mockPos);
		levelModel.addExplosion(explosion);
		assertTrue( levelModel.getElementsMatrix()[mockPos.getX()][mockPos.getY()] instanceof Explosion);
	}

	@Test
	public void setTime(){
		levelModel.setTime(3);
		assertEquals(3, levelModel.getLevelTime());
	}

	@Test
	public void getElementsMatrix(){
		Player playerMock = mock(Player.class);
		when(playerMock.getPosition()).thenReturn(mockPos);
		levelModel.setPlayer(playerMock);
		assertTrue( levelModel.getElementsMatrix()[mockPos.getX()][mockPos.getY()] instanceof Player);
	}

	@Test
	public void clearMatrixPosition(){
		Player playerMock = mock(Player.class);
		when(playerMock.getPosition()).thenReturn(mockPos);
		levelModel.setPlayer(playerMock);
		levelModel.clearMatrixPosition(mockPos);
		assertTrue( levelModel.getElementsMatrix()[mockPos.getX()][mockPos.getY()] == null);
	}

	@Test
	public void findElement(){
		assertTrue( null == levelModel.findElement(mockPos));
	}

	@Test
	public void clear(){
		Player playerMock = mock(Player.class);
		when(playerMock.getPosition()).thenReturn(mockPos);
		levelModel.setPlayer(playerMock);
		levelModel.clear();
		assertTrue( levelModel.getElementsMatrix()[mockPos.getX()][mockPos.getY()] == null);
	}
}
