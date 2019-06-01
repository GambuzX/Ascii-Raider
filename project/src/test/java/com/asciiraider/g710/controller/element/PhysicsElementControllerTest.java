package com.asciiraider.g710.controller.element;

import com.asciiraider.g710.controller.level.LevelController;
import com.asciiraider.g710.controller.level.LevelFacade;
import com.asciiraider.g710.model.element.Boulder;
import com.asciiraider.g710.model.element.PhysicsElement;
import com.asciiraider.g710.model.element.TNT;
import com.asciiraider.g710.model.utilities.Position;
import org.junit.Before;
import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.*;

public class PhysicsElementControllerTest {
	private PhysicsElementController physicsElementController;
	private PhysicsElement physicsElementMock;
	private Position positionMock;
	private LevelController levelController;
	private LevelFacade levelFacade;

	@Before
	public void setUp(){

		levelController = mock(LevelController.class);
		levelFacade = mock(LevelFacade.class);


		physicsElementMock = mock(PhysicsElement.class);
		positionMock = mock(Position.class);
		when(positionMock.getBelow()).thenReturn(positionMock);
		when(physicsElementMock.getPosition()).thenReturn(positionMock);
		physicsElementController = new PhysicsElementController(physicsElementMock);
	}

	// belowEle = null
	@Test
	public void handler1(){
		when(physicsElementMock.moveDown()).thenReturn(positionMock);
		when(levelFacade.findElement(positionMock)).thenReturn(null);

		final int[] counter = new int[1];

		Answer<Boolean> answer = new Answer<Boolean>() {
			@Override
			public Boolean answer(InvocationOnMock invocation) throws Throwable {
				counter[0]++;
				return true;
			}
		};

		doAnswer(answer).when(physicsElementMock).setFalling(true);
		doAnswer(answer).when(levelFacade).setElementPosition(physicsElementMock, positionMock);

		physicsElementController.handleElementPhysics(levelController, levelFacade);

		assertEquals(2, counter[0]);
	}

	// TNT not Falling
	@Test
	public void handler2(){
		TNT tntMock = mock(TNT.class);

		when(physicsElementMock.moveDown()).thenReturn(positionMock);
		when(levelFacade.findElement(positionMock)).thenReturn(tntMock);

		PhysicsElementController physicsElementController = new PhysicsElementController(tntMock);
		when(tntMock.getPosition()).thenReturn(positionMock);
		when(tntMock.isFalling()).thenReturn(false);

		final int[] counter = new int[1];

		Answer<Boolean> answer = new Answer<Boolean>() {
			@Override
			public Boolean answer(InvocationOnMock invocation) throws Throwable {
				counter[0]++;
				return true;
			}
		};

		doThrow(new IllegalArgumentException()).when(levelController).triggerExplosion(positionMock);

		doAnswer(answer).when(tntMock).setFalling(false);

		physicsElementController.handleElementPhysics(levelController, levelFacade);

		assertEquals(1, counter[0]);
	}

	// TNT falling
	@Test
	public void handler3(){
		TNT tntMock = mock(TNT.class);

		when(physicsElementMock.moveDown()).thenReturn(positionMock);
		when(levelFacade.findElement(positionMock)).thenReturn(tntMock);

		PhysicsElementController physicsElementController = new PhysicsElementController(tntMock);
		when(tntMock.getPosition()).thenReturn(positionMock);
		when(tntMock.isFalling()).thenReturn(true);

		final int[] counter = new int[1];

		Answer<Boolean> answer = new Answer<Boolean>() {
			@Override
			public Boolean answer(InvocationOnMock invocation) throws Throwable {
				counter[0]++;
				return true;
			}
		};

		doAnswer(answer).when(levelController).triggerExplosion(positionMock);
		doAnswer(answer).when(tntMock).setFalling(false);

		physicsElementController.handleElementPhysics(levelController, levelFacade);

		assertEquals(2, counter[0]);
	}

	//Boulder Falling in Tnt
	@Test
	public void handler4(){
		TNT tntMock = mock(TNT.class);
		when(tntMock.getPosition()).thenReturn(positionMock);

		Boulder boulder = mock(Boulder.class);
		when(boulder.getPosition()).thenReturn(positionMock);

		when(boulder.moveDown()).thenReturn(positionMock);
		when(levelFacade.findElement(positionMock)).thenReturn(tntMock);

		PhysicsElementController physicsElementController = new PhysicsElementController(boulder);
		when(boulder.isFalling()).thenReturn(true);

		final int[] counter = new int[1];

		Answer<Boolean> answer = new Answer<Boolean>() {
			@Override
			public Boolean answer(InvocationOnMock invocation) throws Throwable {
				counter[0]++;
				return true;
			}
		};

		doAnswer(answer).when(levelController).triggerExplosion(positionMock);
		doAnswer(answer).when(boulder).setFalling(false);

		physicsElementController.handleElementPhysics(levelController, levelFacade);

		assertEquals(2, counter[0]);
	}

	// Boulder Not Falling
	@Test
	public void handler6(){
		TNT tntMock = mock(TNT.class);
		when(tntMock.getPosition()).thenReturn(positionMock);

		Boulder boulder = mock(Boulder.class);
		when(boulder.getPosition()).thenReturn(positionMock);

		when(boulder.moveDown()).thenReturn(positionMock);
		when(levelFacade.findElement(positionMock)).thenReturn(tntMock);

		PhysicsElementController physicsElementController = new PhysicsElementController(boulder);
		when(boulder.isFalling()).thenReturn(false);

		final int[] counter = new int[1];

		Answer<Boolean> answer = new Answer<Boolean>() {
			@Override
			public Boolean answer(InvocationOnMock invocation) throws Throwable {
				counter[0]++;
				return true;
			}
		};

		doThrow(new IllegalArgumentException()).when(levelController).triggerExplosion(positionMock);
		doAnswer(answer).when(boulder).setFalling(false);

		physicsElementController.handleElementPhysics(levelController, levelFacade);

		assertEquals(1, counter[0]);
	}

	//Boulder Falling in Boulder
	@Test
	public void handler5(){

		Boulder boulder = mock(Boulder.class);
		when(boulder.getPosition()).thenReturn(positionMock);

		when(boulder.moveDown()).thenReturn(positionMock);
		when(levelFacade.findElement(positionMock)).thenReturn(boulder);

		PhysicsElementController physicsElementController = new PhysicsElementController(boulder);
		when(boulder.isFalling()).thenReturn(true);

		final int[] counter = new int[1];

		Answer<Boolean> answer = new Answer<Boolean>() {
			@Override
			public Boolean answer(InvocationOnMock invocation) throws Throwable {
				counter[0]++;
				return true;
			}
		};

		doThrow(new IllegalArgumentException()).when(levelController).triggerExplosion(positionMock);
		doAnswer(answer).when(boulder).setFalling(false);

		physicsElementController.handleElementPhysics(levelController, levelFacade);

		assertEquals(1, counter[0]);
	}



}
