package com.asciiraider.g710.controller.level;

import com.asciiraider.g710.GlobalConfigs;
import com.asciiraider.g710.controller.element.interaction.DeathInteraction;
import com.asciiraider.g710.model.element.*;
import com.asciiraider.g710.model.level.LevelModel;
import com.asciiraider.g710.model.utilities.Position;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

public class LevelFacadeTest {
	private LevelModel levelModelMock;
	private LevelFacade levelFacade;

	@Before
	public void setUp(){
		levelModelMock = mock(LevelModel.class);
	}

	@Test
	public void getPlayer(){
		Position position = mock(Position.class);
		when(position.getX()).thenReturn(1);
		Player player = mock(Player.class);
		when(player.getPosition()).thenReturn(position);
		when(levelModelMock.getPlayer()).thenReturn(player);
		levelFacade = new LevelFacade(levelModelMock);
		assertEquals(1, levelFacade.getPlayer().getPosition().getX());
	}

	@Test
	public void getExitDoor(){
		Position position = mock(Position.class);
		when(position.getX()).thenReturn(1);
		ExitDoor exitDoor = mock(ExitDoor.class);
		when(exitDoor.getPosition()).thenReturn(position);
		when(levelModelMock.getExitDoor()).thenReturn(exitDoor);
		levelFacade = new LevelFacade(levelModelMock);
		assertEquals(1, levelFacade.getExitDoor().getPosition().getX());
	}

	@Test
	public void getDoor(){
		Position position = mock(Position.class);
		when(position.getX()).thenReturn(1);
		Door door = mock(Door.class);
		when(door.getPosition()).thenReturn(position);
		when(levelModelMock.getDoor()).thenReturn(door);
		levelFacade = new LevelFacade(levelModelMock);
		assertEquals(1, levelFacade.getDoor().getPosition().getX());
	}

	@Test
	public void getDoorKey(){
		Position position = mock(Position.class);
		when(position.getX()).thenReturn(1);
		DoorKey doorKey = mock(DoorKey.class);
		when(doorKey.getPosition()).thenReturn(position);
		when(levelModelMock.getDoorKey()).thenReturn(doorKey);
		levelFacade = new LevelFacade(levelModelMock);
		assertEquals(1, levelFacade.getDoorKey().getPosition().getX());
	}

	@Test
	public void getLevelKeys(){
		LevelKey levelKey = mock(LevelKey.class);
		List<LevelKey> levelKeys = new ArrayList<>();
		levelKeys.add(levelKey);
		when(levelModelMock.getLevelKeys()).thenReturn(levelKeys);
		levelFacade = new LevelFacade(levelModelMock);
		assertEquals(1, levelFacade.getLevelKeys().size());
	}

	@Test
	public void getEnemies(){
		Enemy enemy = mock(Enemy.class);
		List<Enemy> levelEnemies = new ArrayList<>();
		levelEnemies.add(enemy);
		when(levelModelMock.getEnemies()).thenReturn(levelEnemies);
		levelFacade = new LevelFacade(levelModelMock);
		assertEquals(1, levelFacade.getEnemies().size());
	}

	@Test
	public void getAnimatedElements(){
		Explosion explosion = mock(Explosion.class);
		List<Explosion> explosions = new ArrayList<>();
		explosions.add(explosion);
		when(levelModelMock.getExplosions()).thenReturn(explosions);
		levelFacade = new LevelFacade(levelModelMock);
		assertEquals(1, levelFacade.getAnimatedElements().size());
	}

	@Test
	public void getElements1(){
		Player player = mock(Player.class);
		when(levelModelMock.getPlayer()).thenReturn(player);

		ExitDoor exitDoor = mock(ExitDoor.class);
		when(levelModelMock.getExitDoor()).thenReturn(exitDoor);

		Wall wall = mock(Wall.class);
		List<Wall> walls = new ArrayList<>();
		walls.add(wall);
		when(levelModelMock.getWalls()).thenReturn(walls);

		Boulder boulder = mock(Boulder.class);
		List<Boulder> boulders = new ArrayList<>();
		boulders.add(boulder);
		when(levelModelMock.getBoulders()).thenReturn(boulders);

		StoneBlock stoneBlock = mock(StoneBlock.class);
		List<StoneBlock> stoneBlocks = new ArrayList<>();
		stoneBlocks.add(stoneBlock);
		when(levelModelMock.getStoneBlocks()).thenReturn(stoneBlocks);

		Sand sand = mock(Sand.class);
		List<Sand> sands = new ArrayList<>();
		sands.add(sand);
		when(levelModelMock.getSandBlocks()).thenReturn(sands);

		LevelKey levelKey = mock(LevelKey.class);
		List<LevelKey> levelKeys = new ArrayList<>();
		levelKeys.add(levelKey);
		when(levelModelMock.getLevelKeys()).thenReturn(levelKeys);

		TNT tnt = mock(TNT.class);
		List<TNT> tnts = new ArrayList<>();
		tnts.add(tnt);
		when(levelModelMock.getTNT()).thenReturn(tnts);

		Enemy enemy = mock(Enemy.class);
		List<Enemy> levelEnemies = new ArrayList<>();
		levelEnemies.add(enemy);
		when(levelModelMock.getEnemies()).thenReturn(levelEnemies);

		Explosion explosion = mock(Explosion.class);
		List<Explosion> explosions = new ArrayList<>();
		explosions.add(explosion);
		when(levelModelMock.getExplosions()).thenReturn(explosions);

		when(levelModelMock.getDoor()).thenReturn(null);

		DoorKey doorKey = mock(DoorKey.class);
		when(levelModelMock.getDoorKey()).thenReturn(doorKey);

		levelFacade = new LevelFacade(levelModelMock);


		assertEquals(10, levelFacade.getElements().size());
	}

	@Test
	public void getElements2(){
		Player player = mock(Player.class);
		when(levelModelMock.getPlayer()).thenReturn(player);

		ExitDoor exitDoor = mock(ExitDoor.class);
		when(levelModelMock.getExitDoor()).thenReturn(exitDoor);

		Wall wall = mock(Wall.class);
		List<Wall> walls = new ArrayList<>();
		walls.add(wall);
		when(levelModelMock.getWalls()).thenReturn(walls);

		Boulder boulder = mock(Boulder.class);
		List<Boulder> boulders = new ArrayList<>();
		boulders.add(boulder);
		when(levelModelMock.getBoulders()).thenReturn(boulders);

		StoneBlock stoneBlock = mock(StoneBlock.class);
		List<StoneBlock> stoneBlocks = new ArrayList<>();
		stoneBlocks.add(stoneBlock);
		when(levelModelMock.getStoneBlocks()).thenReturn(stoneBlocks);

		Sand sand = mock(Sand.class);
		List<Sand> sands = new ArrayList<>();
		sands.add(sand);
		when(levelModelMock.getSandBlocks()).thenReturn(sands);

		LevelKey levelKey = mock(LevelKey.class);
		List<LevelKey> levelKeys = new ArrayList<>();
		levelKeys.add(levelKey);
		when(levelModelMock.getLevelKeys()).thenReturn(levelKeys);

		TNT tnt = mock(TNT.class);
		List<TNT> tnts = new ArrayList<>();
		tnts.add(tnt);
		when(levelModelMock.getTNT()).thenReturn(tnts);

		Enemy enemy = mock(Enemy.class);
		List<Enemy> levelEnemies = new ArrayList<>();
		levelEnemies.add(enemy);
		when(levelModelMock.getEnemies()).thenReturn(levelEnemies);

		Explosion explosion = mock(Explosion.class);
		List<Explosion> explosions = new ArrayList<>();
		explosions.add(explosion);
		when(levelModelMock.getExplosions()).thenReturn(explosions);


		Door door = mock(Door.class);
		when(levelModelMock.getDoor()).thenReturn(door);

		DoorKey doorKey = mock(DoorKey.class);
		when(levelModelMock.getDoorKey()).thenReturn(doorKey);

		levelFacade = new LevelFacade(levelModelMock);


		assertEquals(12, levelFacade.getElements().size());
	}

	@Test
	public void insideBounds1(){
		Position position = mock(Position.class);
		when(position.getX()).thenReturn(GlobalConfigs.LEVEL_WIDTH);
		levelFacade = new LevelFacade(levelModelMock);

		assertFalse(levelFacade.insideBounds(position));
	}

	@Test
	public void insideBounds2(){
		Position position = mock(Position.class);
		when(position.getX()).thenReturn(GlobalConfigs.LEVEL_WIDTH - 1);
		when(position.getY()).thenReturn(GlobalConfigs.LEVEL_HEIGHT);
		levelFacade = new LevelFacade(levelModelMock);

		assertFalse(levelFacade.insideBounds(position));
	}

	@Test
	public void insideBounds3(){
		Position position = mock(Position.class);
		when(position.getX()).thenReturn(GlobalConfigs.LEVEL_WIDTH - 1);
		when(position.getY()).thenReturn(GlobalConfigs.LEVEL_HEIGHT - 1);
		levelFacade = new LevelFacade(levelModelMock);

		assertTrue(levelFacade.insideBounds(position));
	}

	@Test
	public void removeAnimation(){
		Position position = mock(Position.class);
		Explosion element = mock(Explosion.class);
		when(element.getPosition()).thenReturn(position);

		List<Explosion> explosions = new ArrayList<>();
		explosions.add(element);

		when(levelModelMock.getExplosions()).thenReturn(explosions);

		levelFacade = new LevelFacade(levelModelMock);

		levelFacade.removeAnimation(element);

		assertEquals(0, explosions.size());
		verify(levelModelMock, times(1)).clearMatrixPosition(position);
	}

	@Test
	public void findExplosion1(){
		Position position = mock(Position.class);
		when(position.getY()).thenReturn(0);
		when(position.getX()).thenReturn(0);

		Wall wall = mock(Wall.class);

		Element[][] elementsMatrix = new Element[1][1];
		elementsMatrix[0][0] = wall;

		when(levelModelMock.getElementsMatrix()).thenReturn(elementsMatrix);

		levelFacade = new LevelFacade(levelModelMock);

		assertEquals(null, levelFacade.findExplosion(position));
	}

	@Test
	public void findExplosion2(){
		Position position = mock(Position.class);
		when(position.getY()).thenReturn(0);
		when(position.getX()).thenReturn(0);

		Explosion explosion = mock(Explosion.class);

		Element[][] elementsMatrix = new Element[1][1];
		elementsMatrix[0][0] = explosion;

		when(levelModelMock.getElementsMatrix()).thenReturn(elementsMatrix);

		levelFacade = new LevelFacade(levelModelMock);

		assertEquals(explosion, levelFacade.findExplosion(position));
	}

	@Test
	public void getPhysicsElements1(){

		Boulder boulder = mock(Boulder.class);
		List<Boulder> boulders = new ArrayList<>();
		boulders.add(boulder);
		when(levelModelMock.getBoulders()).thenReturn(boulders);

		LevelKey levelKey = mock(LevelKey.class);
		List<LevelKey> levelKeys = new ArrayList<>();
		levelKeys.add(levelKey);
		when(levelModelMock.getLevelKeys()).thenReturn(levelKeys);

		TNT tnt = mock(TNT.class);
		List<TNT> tnts = new ArrayList<>();
		tnts.add(tnt);
		when(levelModelMock.getTNT()).thenReturn(tnts);

		when(levelModelMock.getDoorKey()).thenReturn(null);

		levelFacade = new LevelFacade(levelModelMock);


		assertEquals(3, levelFacade.getPhysicsElements().size());
	}

	@Test
	public void getPhysicsElements2(){

		Boulder boulder = mock(Boulder.class);
		List<Boulder> boulders = new ArrayList<>();
		boulders.add(boulder);
		when(levelModelMock.getBoulders()).thenReturn(boulders);

		LevelKey levelKey = mock(LevelKey.class);
		List<LevelKey> levelKeys = new ArrayList<>();
		levelKeys.add(levelKey);
		when(levelModelMock.getLevelKeys()).thenReturn(levelKeys);

		TNT tnt = mock(TNT.class);
		List<TNT> tnts = new ArrayList<>();
		tnts.add(tnt);
		when(levelModelMock.getTNT()).thenReturn(tnts);

		DoorKey doorKey = mock(DoorKey.class);
		when(levelModelMock.getDoorKey()).thenReturn(doorKey);

		levelFacade = new LevelFacade(levelModelMock);

		assertEquals(4, levelFacade.getPhysicsElements().size());
	}

	@Test
	public void isEmptyPosition1(){
		Position position = mock(Position.class);
		when(position.getY()).thenReturn(0);
		when(position.getX()).thenReturn(0);

		Wall wall = mock(Wall.class);

		Element[][] elementsMatrix = new Element[1][1];
		elementsMatrix[0][0] = wall;

		when(levelModelMock.getElementsMatrix()).thenReturn(elementsMatrix);

		levelFacade = new LevelFacade(levelModelMock);

		assertFalse(levelFacade.canEnemyMoveTo(position));
	}

	@Test
	public void isEmptyPosition2(){
		Position position = mock(Position.class);
		when(position.getY()).thenReturn(0);
		when(position.getX()).thenReturn(0);

		Element[][] elementsMatrix = new Element[1][1];
		elementsMatrix[0][0] = null;

		when(levelModelMock.getElementsMatrix()).thenReturn(elementsMatrix);

		levelFacade = new LevelFacade(levelModelMock);

		assertTrue(levelFacade.canEnemyMoveTo(position));
	}

	@Test
	public void isEmptyPosition3(){
		Position position = mock(Position.class);
		when(position.getY()).thenReturn(0);
		when(position.getX()).thenReturn(0);

		Player player = mock(Player.class);

		Element[][] elementsMatrix = new Element[1][1];
		elementsMatrix[0][0] = player;

		when(levelModelMock.getPlayer()).thenReturn(player);
		when(levelModelMock.getElementsMatrix()).thenReturn(elementsMatrix);

		levelFacade = new LevelFacade(levelModelMock);

		assertTrue(levelFacade.canEnemyMoveTo(position));
	}

	@Test
	public void findElement(){
		Position position = mock(Position.class);
		when(position.getY()).thenReturn(0);
		when(position.getX()).thenReturn(0);

		Player player = mock(Player.class);

		Element[][] elementsMatrix = new Element[1][1];
		elementsMatrix[0][0] = player;

		when(levelModelMock.getPlayer()).thenReturn(player);
		when(levelModelMock.getElementsMatrix()).thenReturn(elementsMatrix);

		levelFacade = new LevelFacade(levelModelMock);

		assertEquals(player, levelFacade.findElement(position));

	}

	@Test
	public void findPhysicsElement1(){
		Position position = mock(Position.class);
		when(position.getY()).thenReturn(0);
		when(position.getX()).thenReturn(0);

		Wall wall = mock(Wall.class);

		Element[][] elementsMatrix = new Element[1][1];
		elementsMatrix[0][0] = wall;

		when(levelModelMock.getElementsMatrix()).thenReturn(elementsMatrix);

		levelFacade = new LevelFacade(levelModelMock);

		assertEquals(null, levelFacade.findPhysicsElement(position));
	}

	@Test
	public void findPhysicsElement2(){
		Position position = mock(Position.class);
		when(position.getY()).thenReturn(0);
		when(position.getX()).thenReturn(0);

		Boulder boulder = mock(Boulder.class);

		Element[][] elementsMatrix = new Element[1][1];
		elementsMatrix[0][0] = boulder;

		when(levelModelMock.getElementsMatrix()).thenReturn(elementsMatrix);

		levelFacade = new LevelFacade(levelModelMock);

		assertEquals(boulder, levelFacade.findPhysicsElement(position));
	}

	@Test
	public void findPhysicsElement3(){
		Position position = mock(Position.class);
		when(position.getY()).thenReturn(0);
		when(position.getX()).thenReturn(0);

		LevelKey levelKey = mock(LevelKey.class);

		Element[][] elementsMatrix = new Element[1][1];
		elementsMatrix[0][0] = levelKey;

		when(levelModelMock.getElementsMatrix()).thenReturn(elementsMatrix);

		levelFacade = new LevelFacade(levelModelMock);

		assertEquals(levelKey, levelFacade.findPhysicsElement(position));
	}

	@Test
	public void findPhysicsElement4(){
		Position position = mock(Position.class);
		when(position.getY()).thenReturn(0);
		when(position.getX()).thenReturn(0);

		TNT tnt = mock(TNT.class);

		Element[][] elementsMatrix = new Element[1][1];
		elementsMatrix[0][0] = tnt;

		when(levelModelMock.getElementsMatrix()).thenReturn(elementsMatrix);

		levelFacade = new LevelFacade(levelModelMock);

		assertEquals(tnt, levelFacade.findPhysicsElement(position));
	}

	@Test
	public void findWall1(){
		Position position = mock(Position.class);
		when(position.getY()).thenReturn(0);
		when(position.getX()).thenReturn(0);

		TNT tnt = mock(TNT.class);

		Element[][] elementsMatrix = new Element[1][1];
		elementsMatrix[0][0] = tnt;

		when(levelModelMock.getElementsMatrix()).thenReturn(elementsMatrix);

		levelFacade = new LevelFacade(levelModelMock);

		assertEquals(null, levelFacade.findWall(position));
	}

	@Test
	public void findWall2(){
		Position position = mock(Position.class);
		when(position.getY()).thenReturn(0);
		when(position.getX()).thenReturn(0);

		Wall wall = mock(Wall.class);

		Element[][] elementsMatrix = new Element[1][1];
		elementsMatrix[0][0] = wall;

		when(levelModelMock.getElementsMatrix()).thenReturn(elementsMatrix);

		levelFacade = new LevelFacade(levelModelMock);

		assertEquals(wall, levelFacade.findWall(position));
	}

	@Test
	public void findBoulder1(){
		Position position = mock(Position.class);
		when(position.getY()).thenReturn(0);
		when(position.getX()).thenReturn(0);

		TNT tnt = mock(TNT.class);

		Element[][] elementsMatrix = new Element[1][1];
		elementsMatrix[0][0] = tnt;

		when(levelModelMock.getElementsMatrix()).thenReturn(elementsMatrix);

		levelFacade = new LevelFacade(levelModelMock);

		assertEquals(null, levelFacade.findBoulder(position));
	}

	@Test
	public void findBoulder2(){
		Position position = mock(Position.class);
		when(position.getY()).thenReturn(0);
		when(position.getX()).thenReturn(0);

		Boulder boulder = mock(Boulder.class);

		Element[][] elementsMatrix = new Element[1][1];
		elementsMatrix[0][0] = boulder;

		when(levelModelMock.getElementsMatrix()).thenReturn(elementsMatrix);

		levelFacade = new LevelFacade(levelModelMock);

		assertEquals(boulder, levelFacade.findBoulder(position));
	}

	@Test
	public void findLevelKey1(){
		Position position = mock(Position.class);
		when(position.getY()).thenReturn(0);
		when(position.getX()).thenReturn(0);

		TNT tnt = mock(TNT.class);

		Element[][] elementsMatrix = new Element[1][1];
		elementsMatrix[0][0] = tnt;

		when(levelModelMock.getElementsMatrix()).thenReturn(elementsMatrix);

		levelFacade = new LevelFacade(levelModelMock);

		assertEquals(null, levelFacade.findLevelKey(position));
	}

	@Test
	public void findLevelKey2(){
		Position position = mock(Position.class);
		when(position.getY()).thenReturn(0);
		when(position.getX()).thenReturn(0);

		LevelKey levelKey = mock(LevelKey.class);

		Element[][] elementsMatrix = new Element[1][1];
		elementsMatrix[0][0] = levelKey;

		when(levelModelMock.getElementsMatrix()).thenReturn(elementsMatrix);

		levelFacade = new LevelFacade(levelModelMock);

		assertEquals(levelKey, levelFacade.findLevelKey(position));
	}

	@Test
	public void findSandBlock1(){
		Position position = mock(Position.class);
		when(position.getY()).thenReturn(0);
		when(position.getX()).thenReturn(0);

		TNT tnt = mock(TNT.class);

		Element[][] elementsMatrix = new Element[1][1];
		elementsMatrix[0][0] = tnt;

		when(levelModelMock.getElementsMatrix()).thenReturn(elementsMatrix);

		levelFacade = new LevelFacade(levelModelMock);

		assertEquals(null, levelFacade.findSandBlock(position));
	}

	@Test
	public void findSandBlock2(){
		Position position = mock(Position.class);
		when(position.getY()).thenReturn(0);
		when(position.getX()).thenReturn(0);

		Sand element = mock(Sand.class);

		Element[][] elementsMatrix = new Element[1][1];
		elementsMatrix[0][0] = element;

		when(levelModelMock.getElementsMatrix()).thenReturn(elementsMatrix);

		levelFacade = new LevelFacade(levelModelMock);

		assertEquals(element, levelFacade.findSandBlock(position));
	}

	@Test
	public void findStoneBlock1(){
		Position position = mock(Position.class);
		when(position.getY()).thenReturn(0);
		when(position.getX()).thenReturn(0);

		TNT tnt = mock(TNT.class);

		Element[][] elementsMatrix = new Element[1][1];
		elementsMatrix[0][0] = tnt;

		when(levelModelMock.getElementsMatrix()).thenReturn(elementsMatrix);

		levelFacade = new LevelFacade(levelModelMock);

		assertEquals(null, levelFacade.findSandBlock(position));
	}

	@Test
	public void findStoneBlock2(){
		Position position = mock(Position.class);
		when(position.getY()).thenReturn(0);
		when(position.getX()).thenReturn(0);

		StoneBlock element = mock(StoneBlock.class);

		Element[][] elementsMatrix = new Element[1][1];
		elementsMatrix[0][0] = element;

		when(levelModelMock.getElementsMatrix()).thenReturn(elementsMatrix);

		levelFacade = new LevelFacade(levelModelMock);

		assertEquals(element, levelFacade.findStoneBlock(position));
	}

	@Test
	public void findDoorKey1(){
		Position position = mock(Position.class);
		when(position.getY()).thenReturn(0);
		when(position.getX()).thenReturn(0);

		TNT tnt = mock(TNT.class);

		Element[][] elementsMatrix = new Element[1][1];
		elementsMatrix[0][0] = tnt;

		when(levelModelMock.getElementsMatrix()).thenReturn(elementsMatrix);

		levelFacade = new LevelFacade(levelModelMock);

		assertEquals(null, levelFacade.findDoorKey(position));
	}

	@Test
	public void findDoorKey2(){
		Position position = mock(Position.class);
		when(position.getY()).thenReturn(0);
		when(position.getX()).thenReturn(0);

		DoorKey element = mock(DoorKey.class);

		Element[][] elementsMatrix = new Element[1][1];
		elementsMatrix[0][0] = element;

		when(levelModelMock.getElementsMatrix()).thenReturn(elementsMatrix);

		levelFacade = new LevelFacade(levelModelMock);

		assertEquals(element, levelFacade.findDoorKey(position));
	}

	@Test
	public void findTNT1(){
		Position position = mock(Position.class);
		when(position.getY()).thenReturn(0);
		when(position.getX()).thenReturn(0);

		TNT tnt = mock(TNT.class);

		Element[][] elementsMatrix = new Element[1][1];
		elementsMatrix[0][0] = tnt;

		when(levelModelMock.getElementsMatrix()).thenReturn(elementsMatrix);

		levelFacade = new LevelFacade(levelModelMock);

		assertEquals(tnt, levelFacade.findTNT(position));
	}

	@Test
	public void findTNT2(){
		Position position = mock(Position.class);
		when(position.getY()).thenReturn(0);
		when(position.getX()).thenReturn(0);

		DoorKey element = mock(DoorKey.class);

		Element[][] elementsMatrix = new Element[1][1];
		elementsMatrix[0][0] = element;

		when(levelModelMock.getElementsMatrix()).thenReturn(elementsMatrix);

		levelFacade = new LevelFacade(levelModelMock);

		assertEquals(null, levelFacade.findTNT(position));
	}

	@Test
	public void findEnemy1(){
		Position position = mock(Position.class);
		when(position.getY()).thenReturn(0);
		when(position.getX()).thenReturn(0);

		TNT tnt = mock(TNT.class);

		Element[][] elementsMatrix = new Element[1][1];
		elementsMatrix[0][0] = tnt;

		when(levelModelMock.getElementsMatrix()).thenReturn(elementsMatrix);

		levelFacade = new LevelFacade(levelModelMock);

		assertEquals(null, levelFacade.findEnemy(position));
	}

	@Test
	public void findEnemy2(){
		Position position = mock(Position.class);
		when(position.getY()).thenReturn(0);
		when(position.getX()).thenReturn(0);

		Enemy element = mock(Enemy.class);

		Element[][] elementsMatrix = new Element[1][1];
		elementsMatrix[0][0] = element;

		when(levelModelMock.getElementsMatrix()).thenReturn(elementsMatrix);

		levelFacade = new LevelFacade(levelModelMock);

		assertEquals(element, levelFacade.findEnemy(position));
	}

	@Test
	public void findEnemy3(){
		levelFacade = new LevelFacade(levelModelMock);

		assertEquals(null, levelFacade.findEnemy(null));
	}

	@Test
	public void removeLevelKey1(){
		Position position = mock(Position.class);
		when(position.getY()).thenReturn(0);
		when(position.getX()).thenReturn(0);

		TNT tnt = mock(TNT.class);

		Element[][] elementsMatrix = new Element[1][1];
		elementsMatrix[0][0] = tnt;

		when(levelModelMock.getElementsMatrix()).thenReturn(elementsMatrix);

		levelFacade = new LevelFacade(levelModelMock);

		assertFalse(levelFacade.removeLevelKey(position));
	}

	@Test
	public void removeLevelKey2(){
		Position position = mock(Position.class);
		when(position.getY()).thenReturn(0);
		when(position.getX()).thenReturn(0);

		LevelKey levelKey = mock(LevelKey.class);
		when(levelKey.getPosition()).thenReturn(position);

		Element[][] elementsMatrix = new Element[1][1];
		elementsMatrix[0][0] = levelKey;

		when(levelModelMock.getElementsMatrix()).thenReturn(elementsMatrix);

		levelFacade = new LevelFacade(levelModelMock);

		assertTrue(levelFacade.removeLevelKey(position));

		verify(levelModelMock, times(1)).clearMatrixPosition(position);
	}

	@Test
	public void removeSandBlock1(){
		Position position = mock(Position.class);
		when(position.getY()).thenReturn(0);
		when(position.getX()).thenReturn(0);

		TNT tnt = mock(TNT.class);

		Element[][] elementsMatrix = new Element[1][1];
		elementsMatrix[0][0] = tnt;

		when(levelModelMock.getElementsMatrix()).thenReturn(elementsMatrix);

		levelFacade = new LevelFacade(levelModelMock);

		assertFalse(levelFacade.removeSandBlock(position));
	}

	@Test
	public void removeSandBlock2(){
		Position position = mock(Position.class);
		when(position.getY()).thenReturn(0);
		when(position.getX()).thenReturn(0);

		Sand element = mock(Sand.class);
		when(element.getPosition()).thenReturn(position);

		Element[][] elementsMatrix = new Element[1][1];
		elementsMatrix[0][0] = element;

		when(levelModelMock.getElementsMatrix()).thenReturn(elementsMatrix);

		levelFacade = new LevelFacade(levelModelMock);

		assertTrue(levelFacade.removeSandBlock(position));

		verify(levelModelMock, times(1)).clearMatrixPosition(position);
	}

	@Test
	public void removeDoorKey(){
		Position position = mock(Position.class);
		when(position.getY()).thenReturn(0);
		when(position.getX()).thenReturn(0);

		DoorKey element = mock(DoorKey.class);
		when(element.getPosition()).thenReturn(position);

		when(levelModelMock.getDoorKey()).thenReturn(element);


		levelFacade = new LevelFacade(levelModelMock);

		levelFacade.removeDoorKey();

		verify(levelModelMock, times(1)).clearMatrixPosition(position);
		verify(levelModelMock, times(1)).setDoorKey(null);

	}

	@Test
	public void removeDoor(){
		Position position = mock(Position.class);
		when(position.getY()).thenReturn(0);
		when(position.getX()).thenReturn(0);

		Door element = mock(Door.class);
		when(element.getPosition()).thenReturn(position);

		when(levelModelMock.getDoor()).thenReturn(element);


		levelFacade = new LevelFacade(levelModelMock);

		levelFacade.removeDoor();

		verify(levelModelMock, times(1)).clearMatrixPosition(position);
		verify(levelModelMock, times(1)).setDoor(null);

	}

	@Test
	public void removeDestructibleElement1(){
		Position position = mock(Position.class);
		when(position.getY()).thenReturn(0);
		when(position.getX()).thenReturn(0);

		Wall element = mock(Wall.class);

		Element[][] elementsMatrix = new Element[1][1];
		elementsMatrix[0][0] = element;

		when(levelModelMock.getElementsMatrix()).thenReturn(elementsMatrix);

		levelFacade = new LevelFacade(levelModelMock);

		levelFacade.removeDestructibleElement(position);

		verify(levelModelMock, never()).clearMatrixPosition(position);
	}

	@Test
	public void removeDestructibleElement2(){
		Position position = mock(Position.class);
		when(position.getY()).thenReturn(0);
		when(position.getX()).thenReturn(0);

		Player element = mock(Player.class);
		when(element.getPosition()).thenReturn(position);

		Element[][] elementsMatrix = new Element[1][1];
		elementsMatrix[0][0] = element;

		when(levelModelMock.getElementsMatrix()).thenReturn(elementsMatrix);

		levelFacade = new LevelFacade(levelModelMock);

		levelFacade.removeDestructibleElement(position);

		verify(levelModelMock, times(1)).clearMatrixPosition(position);
		verify(levelModelMock, times(1)).setPlayer(null);
	}

	@Test
	public void removeDestructibleElement3(){
		Position position = mock(Position.class);
		when(position.getY()).thenReturn(0);
		when(position.getX()).thenReturn(0);

		DoorKey element = mock(DoorKey.class);
		when(element.getPosition()).thenReturn(position);

		Element[][] elementsMatrix = new Element[1][1];
		elementsMatrix[0][0] = element;

		when(levelModelMock.getElementsMatrix()).thenReturn(elementsMatrix);

		levelFacade = new LevelFacade(levelModelMock);

		levelFacade.removeDestructibleElement(position);

		verify(levelModelMock, times(1)).clearMatrixPosition(position);
		verify(levelModelMock, times(1)).setDoorKey(null);
	}

	@Test
	public void removeDestructibleElement4(){
		Position position = mock(Position.class);
		when(position.getY()).thenReturn(0);
		when(position.getX()).thenReturn(0);

		StoneBlock element = mock(StoneBlock.class);
		when(element.getPosition()).thenReturn(position);

		Element[][] elementsMatrix = new Element[1][1];
		elementsMatrix[0][0] = element;

		when(levelModelMock.getElementsMatrix()).thenReturn(elementsMatrix);

		levelFacade = new LevelFacade(levelModelMock);

		levelFacade.removeDestructibleElement(position);

		verify(levelModelMock, times(1)).clearMatrixPosition(position);
		verify(levelModelMock, times(1)).getStoneBlocks();
	}

	@Test
	public void removeDestructibleElement5(){
		Position position = mock(Position.class);
		when(position.getY()).thenReturn(0);
		when(position.getX()).thenReturn(0);

		Sand element = mock(Sand.class);
		when(element.getPosition()).thenReturn(position);

		Element[][] elementsMatrix = new Element[1][1];
		elementsMatrix[0][0] = element;

		when(levelModelMock.getElementsMatrix()).thenReturn(elementsMatrix);

		levelFacade = new LevelFacade(levelModelMock);

		levelFacade.removeDestructibleElement(position);

		verify(levelModelMock, times(1)).clearMatrixPosition(position);
		verify(levelModelMock, times(1)).getSandBlocks();
	}

	@Test
	public void removeDestructibleElement6(){
		Position position = mock(Position.class);
		when(position.getY()).thenReturn(0);
		when(position.getX()).thenReturn(0);

		Boulder element = mock(Boulder.class);
		when(element.getPosition()).thenReturn(position);

		Element[][] elementsMatrix = new Element[1][1];
		elementsMatrix[0][0] = element;

		when(levelModelMock.getElementsMatrix()).thenReturn(elementsMatrix);

		levelFacade = new LevelFacade(levelModelMock);

		levelFacade.removeDestructibleElement(position);

		verify(levelModelMock, times(1)).clearMatrixPosition(position);
		verify(levelModelMock, times(1)).getBoulders();
	}

	@Test
	public void removeDestructibleElement7(){
		Position position = mock(Position.class);
		when(position.getY()).thenReturn(0);
		when(position.getX()).thenReturn(0);

		LevelKey element = mock(LevelKey.class);
		when(element.getPosition()).thenReturn(position);

		Element[][] elementsMatrix = new Element[1][1];
		elementsMatrix[0][0] = element;

		when(levelModelMock.getElementsMatrix()).thenReturn(elementsMatrix);

		levelFacade = new LevelFacade(levelModelMock);

		levelFacade.removeDestructibleElement(position);

		verify(levelModelMock, times(1)).clearMatrixPosition(position);
		verify(levelModelMock, times(1)).getLevelKeys();
	}

	@Test
	public void removeDestructibleElement8(){
		Position position = mock(Position.class);
		when(position.getY()).thenReturn(0);
		when(position.getX()).thenReturn(0);

		TNT element = mock(TNT.class);
		when(element.getPosition()).thenReturn(position);

		Element[][] elementsMatrix = new Element[1][1];
		elementsMatrix[0][0] = element;

		when(levelModelMock.getElementsMatrix()).thenReturn(elementsMatrix);

		levelFacade = new LevelFacade(levelModelMock);

		levelFacade.removeDestructibleElement(position);

		verify(levelModelMock, times(1)).clearMatrixPosition(position);
		verify(levelModelMock, times(1)).getTNT();
	}

	@Test
	public void removeDestructibleElement9(){
		Position position = mock(Position.class);
		when(position.getY()).thenReturn(0);
		when(position.getX()).thenReturn(0);

		Enemy element = mock(Enemy.class);
		when(element.getPosition()).thenReturn(position);

		Element[][] elementsMatrix = new Element[1][1];
		elementsMatrix[0][0] = element;

		when(levelModelMock.getElementsMatrix()).thenReturn(elementsMatrix);

		levelFacade = new LevelFacade(levelModelMock);

		levelFacade.removeDestructibleElement(position);

		verify(levelModelMock, times(1)).clearMatrixPosition(position);
		verify(levelModelMock, times(1)).getEnemies();
	}

	@Test
	public void clearMatrixPosition(){
		Position position = mock(Position.class);

		levelFacade = new LevelFacade(levelModelMock);

		levelFacade.clearMatrixPosition(position);

		verify(levelModelMock, times(1)).clearMatrixPosition(position);
	}

	@Test
	public void updateMatrixPosition(){
		Element element = mock(Element.class);

		levelFacade = new LevelFacade(levelModelMock);

		levelFacade.updateMatrixPosition(element);

		verify(levelModelMock, times(1)).updateMatrixPosition(element);
	}

	@Test
	public void addExplosion(){
		Position position = mock(Position.class);
		levelFacade = new LevelFacade(levelModelMock);

		ArgumentCaptor<Explosion> argument = ArgumentCaptor.forClass(Explosion.class);

		levelFacade.addExplosion(position);

		verify(levelModelMock, times(1)).addExplosion(argument.capture());
		assertEquals(position, argument.getValue().getPosition());
		TestCase.assertTrue(argument.getValue().getPlayerInteraction() instanceof DeathInteraction);
	}

	@Test
	public void setElementPosition1(){
		Position position = mock(Position.class);
		MovableElement movableElement = mock(MovableElement.class);
		when(movableElement.getPosition()).thenReturn(position);

		levelFacade = new LevelFacade(levelModelMock);

		levelFacade.setElementPosition(movableElement, position);

		verify(levelModelMock, times(1)).clearMatrixPosition(position);
		verify(levelModelMock, times(1)).updateMatrixPosition(movableElement);
		verify(movableElement, times(1)).setPosition(position);

	}


}

