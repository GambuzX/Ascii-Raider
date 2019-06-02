package com.asciiraider.g710.controller.element;

import com.asciiraider.g710.controller.observer.LevelKeyObserver;
import com.asciiraider.g710.controller.level.LevelFacade;
import com.asciiraider.g710.model.element.ExitDoor;
import com.asciiraider.g710.model.utilities.Position;
import org.junit.Before;
import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.*;

public class LevelKeyControllerTest {
	private LevelKeyController levelKeyController;
	private LevelKeyObserver levelKeyObserverMock;

	@Before
	public void setUp(){
		levelKeyController = new LevelKeyController();
		levelKeyObserverMock = mock(LevelKeyObserver.class);

	}

	@Test
	public void add1(){

		final int[] counter = new int[1];

		Answer<Boolean> answer = new Answer<Boolean>() {
			@Override
			public Boolean answer(InvocationOnMock invocation) throws Throwable {
				counter[0]++;
				return true;
			}
		};

		doAnswer(answer).when(levelKeyObserverMock).updateLevelKey();

		levelKeyController.addObserver(levelKeyObserverMock);
		levelKeyController.notifyObservers();

		assertEquals(1, counter[0]);
	}

	@Test
	public void remove1(){
		final int[] counter = new int[1];

		Answer<Boolean> answer = new Answer<Boolean>() {
			@Override
			public Boolean answer(InvocationOnMock invocation) throws Throwable {
				counter[0]++;
				return true;
			}
		};

		doAnswer(answer).when(levelKeyObserverMock).updateLevelKey();

		levelKeyController.addObserver(levelKeyObserverMock);
		levelKeyController.removeObserver(levelKeyObserverMock);
		levelKeyController.notifyObservers();

		assertEquals(0, counter[0]);
	}

	@Test
	public void handler1(){
		Position positionMock = mock(Position.class);
		when(positionMock.getAbove()).thenReturn(positionMock);

		ExitDoor exitMock = mock(ExitDoor.class);
		when(exitMock.getPosition()).thenReturn(positionMock);

		LevelFacade levelFacadeMock = mock(LevelFacade.class);
		when(levelFacadeMock.getExitDoor()).thenReturn(exitMock);

		when(levelFacadeMock.removeLevelKey(positionMock)).thenReturn(false);

		final int[] counter = new int[1];

		Answer<Boolean> answer = new Answer<Boolean>() {
			@Override
			public Boolean answer(InvocationOnMock invocation) throws Throwable {
				counter[0]++;
				return true;
			}
		};

		doAnswer(answer).when(levelKeyObserverMock).updateLevelKey();

		levelKeyController.addObserver(levelKeyObserverMock);

		levelKeyController.handler(levelFacadeMock);

		assertEquals(0, counter[0]);
	}

	@Test
	public void handler2(){
		Position positionMock = mock(Position.class);
		when(positionMock.getAbove()).thenReturn(positionMock);

		ExitDoor exitMock = mock(ExitDoor.class);
		when(exitMock.getPosition()).thenReturn(positionMock);

		LevelFacade levelFacadeMock = mock(LevelFacade.class);
		when(levelFacadeMock.getExitDoor()).thenReturn(exitMock);

		when(levelFacadeMock.removeLevelKey(positionMock)).thenReturn(true);

		final int[] counter = new int[1];

		Answer<Boolean> answer = new Answer<Boolean>() {
			@Override
			public Boolean answer(InvocationOnMock invocation) throws Throwable {
				counter[0]++;
				return true;
			}
		};

		doAnswer(answer).when(levelKeyObserverMock).updateLevelKey();

		levelKeyController.addObserver(levelKeyObserverMock);

		levelKeyController.handler(levelFacadeMock);

		assertEquals(1, counter[0]);
	}
}
