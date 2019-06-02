package com.asciiraider.g710.controller.level;

import com.asciiraider.g710.controller.element.LevelKeyController;
import com.asciiraider.g710.controller.element.interaction.Interaction;
import com.asciiraider.g710.controller.life.LifeController;
import com.asciiraider.g710.model.element.*;
import com.asciiraider.g710.model.life.LifeManager;
import com.asciiraider.g710.model.level.LevelManager;
import com.asciiraider.g710.model.level.LevelTimeAlarm;
import com.asciiraider.g710.model.utilities.Position;
import org.junit.Before;
import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

public class LevelControllerTest {
	private LevelManager levelManagerMock;
	private LevelController levelController;

	@Before
	public void setUp(){
		levelManagerMock = mock(LevelManager.class);
		levelController = new LevelController(levelManagerMock);
	}

	@Test
	public void levelKeyObservers(){
		LevelKeyController levelKeyController = spy(levelController.getLevelKeyController()) ;
		levelKeyController.notifyObservers();
		verify(levelManagerMock).updateLevelKey();
	}

	@Test
	public void lifeControllerObservers(){


		final int[] counter = new int[1];

		Answer<Boolean> answer = new Answer<Boolean>() {
			@Override
			public Boolean answer(InvocationOnMock invocation) throws Throwable {
				counter[0]++;
				return true;
			}
		};

		LifeManager lifeManagerMock = mock(LifeManager.class);
		doAnswer(answer).when(lifeManagerMock).updateDeath();
		LevelTimeAlarm levelTimeAlarmMock = mock(LevelTimeAlarm.class);
		doAnswer(answer).when(levelTimeAlarmMock).updateDeath();

		when(levelManagerMock.getLifeManager()).thenReturn(lifeManagerMock);
		when(levelManagerMock.getTimeAlarm()).thenReturn(levelTimeAlarmMock);

		LevelController levelController2 = new LevelController(levelManagerMock);

		LifeController lifeController = spy(levelController2.getLifeController());


		lifeController.notifyObservers();

		verify(levelManagerMock, times(1)).updateDeath();
		assertEquals(2, counter[0]);
	}

	@Test
	public void levelProgressionController(){

		final int[] counter = new int[1];

		Answer<Boolean> answer = new Answer<Boolean>() {
			@Override
			public Boolean answer(InvocationOnMock invocation) throws Throwable {
				counter[0]++;
				return true;
			}
		};

		LevelTimeAlarm levelTimeAlarmMock = mock(LevelTimeAlarm.class);
		doAnswer(answer).when(levelTimeAlarmMock).updateScore(anyInt());

		when(levelManagerMock.getTimeAlarm()).thenReturn(levelTimeAlarmMock);

		LevelController levelController2 = new LevelController(levelManagerMock);

		LevelProgressionController levelProgressionController = spy(levelController2.getLevelProgressionController());

		levelProgressionController.notifyObservers();

		assertEquals(1, counter[0]);

	}

	@Test
	public void triggerExplosionFindWall(){
		Wall wallMock = mock(Wall.class);

		Position positionMock = mock(Position.class);


		LevelFacade levelFacadeMock = mock(LevelFacade.class);
		when(levelFacadeMock.findElement(positionMock)).thenReturn(wallMock);

		levelManagerMock = mock(LevelManager.class);
		when(levelManagerMock.getCurrentLevelFacade()).thenReturn(levelFacadeMock);

		LevelController levelControllerSpy = spy(new LevelController(levelManagerMock));


		List<Position> mockPos = new ArrayList<>();

		when(positionMock.getMatrix()).thenReturn(mockPos);
		LifeController lifeController = spy(levelControllerSpy.getLifeController());


		assertFalse(levelControllerSpy.triggerExplosion(positionMock));

		verify(levelFacadeMock, times(1)).findElement(positionMock);


		verify(lifeController, never()).notifyObservers();

		verify(levelFacadeMock, never()).removeDestructibleElement(positionMock);
		verify(levelFacadeMock, never()).addExplosion(positionMock);
		verify(levelControllerSpy, times(1)).triggerExplosion(positionMock);
	}

	@Test
	public void triggerExplosionFindPlayer(){


		Answer<Boolean> answer = new Answer<Boolean>() {
			@Override
			public Boolean answer(InvocationOnMock invocation) throws Throwable {
				return true;
			}
		};

		LifeManager lifeManagerMock = mock(LifeManager.class);
		doAnswer(answer).when(lifeManagerMock).updateDeath();
		LevelTimeAlarm levelTimeAlarmMock = mock(LevelTimeAlarm.class);
		doAnswer(answer).when(levelTimeAlarmMock).updateDeath();

		Player playerMock = mock(Player.class);
		Position playerPosition = mock(Position.class);

		List<Position> positionList = new ArrayList<>();
		positionList.add(playerPosition);

		Position initialPosition = mock(Position.class);
		when(initialPosition.getMatrix()).thenReturn(positionList);


		LevelFacade levelFacadeMock = mock(LevelFacade.class);
		when(levelFacadeMock.findElement(playerPosition)).thenReturn(playerMock);


		when(levelManagerMock.getLifeManager()).thenReturn(lifeManagerMock);
		when(levelManagerMock.getTimeAlarm()).thenReturn(levelTimeAlarmMock);
		when(levelManagerMock.getCurrentLevelFacade()).thenReturn(levelFacadeMock);

		LevelController levelController2 = spy( new LevelController(levelManagerMock));

		LifeController lifeController = spy(levelController2.getLifeController());

		assertTrue(levelController2.triggerExplosion(initialPosition));

		verify(levelFacadeMock, times(1)).findElement(any());

		verify(levelTimeAlarmMock, times(1)).updateDeath();

		verify(levelFacadeMock, never()).removeDestructibleElement(any());
		verify(levelFacadeMock, never()).addExplosion(any());
		verify(levelController2, times(1)).triggerExplosion(any());

	}

	@Test
	public void triggerExplosionCatchNull(){

		Position positionMock = mock(Position.class);


		LevelFacade levelFacadeMock = mock(LevelFacade.class);
		when(levelFacadeMock.findElement(positionMock)).thenReturn(null);

		levelManagerMock = mock(LevelManager.class);
		when(levelManagerMock.getCurrentLevelFacade()).thenReturn(levelFacadeMock);

		LevelController levelControllerSpy = spy(new LevelController(levelManagerMock));


		List<Position> mockPos = new ArrayList<>();

		when(positionMock.getMatrix()).thenReturn(mockPos);
		LifeController lifeController = spy(levelControllerSpy.getLifeController());


		assertFalse(levelControllerSpy.triggerExplosion(positionMock));

		verify(levelFacadeMock, times(1)).findElement(any());


		verify(lifeController, never()).notifyObservers();

		verify(levelFacadeMock, never()).removeDestructibleElement(any());
		verify(levelFacadeMock, times(1)).addExplosion(positionMock);
		verify(levelControllerSpy, times(1)).triggerExplosion(any());
	}

	@Test
	public void triggerExplosionOnDestructibleNonExplosive(){
		StoneBlock stoneBlock = mock(StoneBlock.class);
		Position positionMock = mock(Position.class);


		LevelFacade levelFacadeMock = mock(LevelFacade.class);
		when(levelFacadeMock.findElement(positionMock)).thenReturn(stoneBlock);

		levelManagerMock = mock(LevelManager.class);
		when(levelManagerMock.getCurrentLevelFacade()).thenReturn(levelFacadeMock);

		LevelController levelControllerSpy = spy(new LevelController(levelManagerMock));


		List<Position> mockPos = new ArrayList<>();

		when(positionMock.getMatrix()).thenReturn(mockPos);
		LifeController lifeController = spy(levelControllerSpy.getLifeController());


		assertFalse(levelControllerSpy.triggerExplosion(positionMock));

		verify(levelFacadeMock, times(1)).findElement(any());


		verify(lifeController, never()).notifyObservers();

		verify(levelFacadeMock, times(1)).removeDestructibleElement(positionMock);
		verify(levelFacadeMock, times(1)).addExplosion(positionMock);
		verify(levelControllerSpy, times(1)).triggerExplosion(any());
	}

	@Test
	public void triggerExplosionOnTNT(){
		TNT tntMock = mock(TNT.class);
		Position tntPosition = mock(Position.class);

		Wall wallMock = mock(Wall.class);

		Position positionMock = mock(Position.class);


		LevelFacade levelFacadeMock = mock(LevelFacade.class);
		when(levelFacadeMock.findElement(tntPosition)).thenReturn(tntMock);
		when(levelFacadeMock.findElement(positionMock)).thenReturn(wallMock);

		levelManagerMock = mock(LevelManager.class);
		when(levelManagerMock.getCurrentLevelFacade()).thenReturn(levelFacadeMock);

		LevelController levelControllerSpy = spy(new LevelController(levelManagerMock));


		List<Position> mockPos = new ArrayList<>();
		mockPos.add(tntPosition);

		List<Position> mockPos2 = new ArrayList<>();


		when(positionMock.getMatrix()).thenReturn(mockPos);
		when(tntPosition.getMatrix()).thenReturn(mockPos2);

		LifeController lifeController = spy(levelControllerSpy.getLifeController());

		final int[] counter = new int[1];

		Answer<Boolean> answer = new Answer<Boolean>() {
			@Override
			public Boolean answer(InvocationOnMock invocation) throws Throwable {
				counter[0]++;
				return true;
			}
		};

		doAnswer(answer).when(levelControllerSpy).triggerExplosion(tntPosition);


		assertTrue(levelControllerSpy.triggerExplosion(positionMock));

		verify(levelFacadeMock, times(1)).findElement(any());


		verify(lifeController, never()).notifyObservers();

		verify(levelFacadeMock, times(1)).removeDestructibleElement(tntPosition);
		verify(levelFacadeMock, times(1)).addExplosion(any());
		verify(levelControllerSpy, times(2)).triggerExplosion(any());
		assertEquals(1, counter[0]);
	}

	@Test(expected = IllegalArgumentException.class)
	public void handlePhysics1(){
		PhysicsElement physicsElement = mock(PhysicsElement.class);
		doThrow(new IllegalArgumentException()).when(physicsElement).moveDown();

		List<PhysicsElement> physicsElementList = new ArrayList<>();
		physicsElementList.add(physicsElement);

		LevelFacade levelFacadeMock = mock(LevelFacade.class);
		when(levelFacadeMock.getPhysicsElements()).thenReturn(physicsElementList);

		when(levelManagerMock.getCurrentLevelFacade()).thenReturn(levelFacadeMock);

		LevelController levelController2 = new LevelController(levelManagerMock);

		levelController2.handlePhysics();
	}

	@Test(expected = IllegalArgumentException.class)
	public void handleEnemies(){
		Position mockPos = mock(Position.class);

		Player playerMock = mock(Player.class);
		when(playerMock.getPosition()).thenReturn(mockPos);
		Enemy enemy = mock(Enemy.class);

		doThrow(new IllegalArgumentException()).when(enemy).move(mockPos);

		List<Enemy> enemyList = new ArrayList<>();
		enemyList.add(enemy);

		LevelFacade levelFacadeMock = mock(LevelFacade.class);
		when(levelFacadeMock.getEnemies()).thenReturn(enemyList);
		when(levelFacadeMock.getPlayer()).thenReturn(playerMock);

		when(levelManagerMock.getCurrentLevelFacade()).thenReturn(levelFacadeMock);

		LevelController levelController2 = new LevelController(levelManagerMock);

		levelController2.handleEnemies();
	}

	@Test
	public void handleAnimation1(){
		AnimatedElement animatedElement = mock(AnimatedElement.class);
		when(animatedElement.updateAnimation()).thenReturn(true);


		List<AnimatedElement> animatedElements = new ArrayList<>();
		animatedElements.add(animatedElement);

		LevelFacade levelFacadeMock = mock(LevelFacade.class);
		when(levelFacadeMock.getAnimatedElements()).thenReturn(animatedElements);

		when(levelManagerMock.getCurrentLevelFacade()).thenReturn(levelFacadeMock);

		LevelController levelController2 = new LevelController(levelManagerMock);

		levelController2.handleAnimations();

		verify(levelFacadeMock, never()).removeAnimation(any());

	}

	@Test
	public void handleAnimation2(){
		AnimatedElement animatedElement = mock(AnimatedElement.class);
		when(animatedElement.updateAnimation()).thenReturn(false);


		List<AnimatedElement> animatedElements = new ArrayList<>();
		animatedElements.add(animatedElement);

		LevelFacade levelFacadeMock = mock(LevelFacade.class);
		when(levelFacadeMock.getAnimatedElements()).thenReturn(animatedElements);

		when(levelManagerMock.getCurrentLevelFacade()).thenReturn(levelFacadeMock);

		LevelController levelController2 = new LevelController(levelManagerMock);

		levelController2.handleAnimations();

		verify(levelFacadeMock, times(1)).removeAnimation(animatedElement);

	}

	@Test(expected = IllegalArgumentException.class)
	public void handleLevelKey(){

		LevelFacade levelFacadeMock = mock(LevelFacade.class);
		when(levelFacadeMock.getExitDoor()).thenThrow(new IllegalArgumentException());

		when(levelManagerMock.getCurrentLevelFacade()).thenReturn(levelFacadeMock);

		LevelController levelController2 = new LevelController(levelManagerMock);

		levelController2.handleLevelKey();
	}

	@Test
	public void movePlayer1(){
		Position delimPos = mock(Position.class);
		LevelFacade levelFacade = mock(LevelFacade.class);

		assertFalse(levelController.movePlayer(null, delimPos, levelFacade));
	}

	@Test
	public void movePlayer2(){
		Position newPos = mock(Position.class);
		Position delimPos = mock(Position.class);
		LevelFacade levelFacade = mock(LevelFacade.class);
		when(levelFacade.insideBounds(newPos)).thenReturn(false);

		assertFalse(levelController.movePlayer(newPos, delimPos, levelFacade));
	}

	@Test
	public void movePlayer3(){
		Position newPos = mock(Position.class);
		Position delimPos = mock(Position.class);
		LevelFacade levelFacade = mock(LevelFacade.class);
		when(levelFacade.insideBounds(newPos)).thenReturn(true);
		when(levelFacade.findElement(newPos)).thenReturn(null);

		assertTrue(levelController.movePlayer(newPos, delimPos, levelFacade));
	}

	@Test
	public void movePlayer4(){
		Position newPos = mock(Position.class);
		Position delimPos = mock(Position.class);
		LevelFacade levelFacade = mock(LevelFacade.class);
		when(levelFacade.insideBounds(newPos)).thenReturn(true);

		Interaction interaction = mock(Interaction.class);
		when(interaction.interact(levelController, delimPos)).thenReturn(true);

		Element element = mock(Element.class);
		when(element.getPlayerInteraction()).thenReturn(interaction);

		when(levelFacade.findElement(newPos)).thenReturn(element);

		assertTrue(levelController.movePlayer(newPos, delimPos, levelFacade));
	}

	@Test
	public void isColliding1(){
		Position position = mock(Position.class);

		Player player = mock(Player.class);
		when(player.getPosition()).thenReturn(position);

		LevelFacade levelFacade = mock(LevelFacade.class);
		when(levelFacade.getPlayer()).thenReturn(player);
		when(levelFacade.findEnemy(position)).thenReturn(null);

		when(levelManagerMock.getCurrentLevelFacade()).thenReturn(levelFacade);

		LevelController newLevelController = new LevelController(levelManagerMock);

		assertFalse(newLevelController.isPlayerCollidingEnemy());
	}

	@Test
	public void isColliding2(){
		Position position = mock(Position.class);

		Player player = mock(Player.class);
		when(player.getPosition()).thenReturn(position);

		Enemy enemy = mock(Enemy.class);

		LevelFacade levelFacade = mock(LevelFacade.class);
		when(levelFacade.getPlayer()).thenReturn(player);
		when(levelFacade.findEnemy(position)).thenReturn(enemy);

		when(levelManagerMock.getCurrentLevelFacade()).thenReturn(levelFacade);

		LevelController newLevelController = new LevelController(levelManagerMock);

		assertTrue(newLevelController.isPlayerCollidingEnemy());
	}

}
