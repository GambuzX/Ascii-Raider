package com.asciiraider.g710.controller.menu;

import com.asciiraider.g710.controller.command.RestartCommand;
import com.asciiraider.g710.controller.command.StartCommand;
import com.asciiraider.g710.model.menu.MenuModel;
import com.asciiraider.g710.model.utilities.Button;
import com.asciiraider.g710.view.event.Event;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class MenuControllerTest {
	private MenuController menuController;
	private MenuModel menuModelMock;

	@Before
	public void setUp(){
		menuModelMock = mock(MenuModel.class);

		menuController = new MenuController(menuModelMock);
	}

	@Test
	public void constructor(){
		assertFalse(menuController.isClose());
	}

	@Test
	public void handleKeyPress1(){
		menuController.handleKeyPress(null);
		assertFalse(menuController.isClose());
	}

	@Test
	public void handleKeyPress2(){
		menuController.handleKeyPress(Event.UP_KEY);

		verify(menuModelMock, times(1)).previousOption();

		assertFalse(menuController.isClose());
	}

	@Test
	public void handleKeyPress3(){
		menuController.handleKeyPress(Event.LEFT_KEY);

		verify(menuModelMock, times(1)).previousOption();

		assertFalse(menuController.isClose());
	}

	@Test
	public void handleKeyPress4(){
		menuController.handleKeyPress(Event.DOWN_KEY);

		verify(menuModelMock, times(1)).nextOption();

		assertFalse(menuController.isClose());
	}

	@Test
	public void handleKeyPress5(){
		menuController.handleKeyPress(Event.RIGHT_KEY);

		verify(menuModelMock, times(1)).nextOption();

		assertFalse(menuController.isClose());
	}

	@Test
	public void handleKeyPress6(){

		RestartCommand restartCommand = mock(RestartCommand.class);

		Button buttonMock = mock(Button.class);
		when(buttonMock.getAction()).thenReturn(restartCommand);

		when(menuModelMock.getSelectedButton()).thenReturn(buttonMock);

		menuController.handleKeyPress(Event.ENTER_KEY);

		verify(restartCommand, times(1)).execute();

		assertTrue(menuController.isClose());
	}

	@Test
	public void handleKeyPress7(){

		RestartCommand restartCommand = mock(RestartCommand.class);
		StartCommand startCommand  = mock(StartCommand.class);

		Button buttonMock = mock(Button.class);
		when(buttonMock.getAction()).thenReturn(restartCommand);

		Button buttonMock2 = mock(Button.class);
		when(buttonMock2.getAction()).thenReturn(startCommand);

		List<Button> buttonList = new ArrayList<>();
		buttonList.add(buttonMock);
		buttonList.add(buttonMock2);

		assertEquals(2, buttonList.size());

		when(menuModelMock.getOptions()).thenReturn(buttonList);

		menuController.handleKeyPress(Event.EOF);

		verify(startCommand, times(1)).execute();

		assertTrue(menuController.isClose());
	}

	@Test
	public void handleKeyPress8(){

		RestartCommand restartCommand = mock(RestartCommand.class);
		StartCommand startCommand  = mock(StartCommand.class);

		Button buttonMock = mock(Button.class);
		when(buttonMock.getAction()).thenReturn(restartCommand);

		Button buttonMock2 = mock(Button.class);
		when(buttonMock2.getAction()).thenReturn(startCommand);

		List<Button> buttonList = new ArrayList<>();
		buttonList.add(buttonMock);
		buttonList.add(buttonMock2);

		assertEquals(2, buttonList.size());

		when(menuModelMock.getOptions()).thenReturn(buttonList);

		menuController.handleKeyPress(Event.Q_KEY);

		verify(startCommand, times(1)).execute();

		assertTrue(menuController.isClose());
	}

}
