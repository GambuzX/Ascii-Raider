package com.asciiraider.g710.controller.state;

import com.asciiraider.g710.controller.Game;
import com.asciiraider.g710.controller.command.ButtonCommand;
import com.asciiraider.g710.controller.command.ExitCommand;
import com.asciiraider.g710.controller.command.StartCommand;
import com.asciiraider.g710.controller.menu.MenuController;
import com.asciiraider.g710.model.menu.MenuModel;
import com.asciiraider.g710.model.utilities.Button;
import com.asciiraider.g710.view.ViewFactory;
import com.asciiraider.g710.view.lanterna.menu.LanternaMenuView;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.mockito.Mockito.*;


public class MenuStateTest {
	private Game game;
	private MenuState menuState;
	private ViewFactory viewFactory;
	private MenuModel menuModel;

	@Before
	public void setUp(){
		LanternaMenuView lanternaMenuView = mock(LanternaMenuView.class);

		viewFactory = mock(ViewFactory.class);
		when(viewFactory.createMenuView()).thenReturn(lanternaMenuView);

		game = mock(Game.class);
		when(game.getViewFactory()).thenReturn(viewFactory);

		List<Button> buttons = new ArrayList<>();
		Button b1 = mock(Button.class);
		Button b2 = mock(Button.class);
		buttons.add(b1);
		buttons.add(b2);


		menuModel = mock(MenuModel.class);
		when(menuModel.getOptions()).thenReturn(buttons);

		menuState = new MenuState(game, menuModel);
	}

	@Test
	public void constructor(){
		List<Button> buttons = new ArrayList<>();
		Button b1 = mock(Button.class);
		Button b2 = mock(Button.class);
		buttons.add(b1);
		buttons.add(b2);
		menuModel = mock(MenuModel.class);
		when(menuModel.getOptions()).thenReturn(buttons);

		menuState = new MenuState(game, menuModel);

		ArgumentCaptor<ButtonCommand> argument = ArgumentCaptor.forClass(ButtonCommand.class);

		verify(b1, times(1)).setAction(argument.capture());
		verify(b2, times(1)).setAction(argument.capture());

		List<ButtonCommand> buttonCommands = argument.getAllValues();

		assertTrue(buttonCommands.get(0) instanceof StartCommand);
		assertTrue(buttonCommands.get(1) instanceof ExitCommand);
	}

	@Test
	public void getStateModel(){
		assertTrue(menuState.getStateModel() instanceof MenuModel);
	}

	@Test
	public void getStateController(){
		assertTrue(menuState.getStateController() instanceof MenuController);
	}

	@Test
	public void getStateView(){
		assertTrue(menuState.getStateView() instanceof LanternaMenuView);
	}

	@Test
	public void run1(){

		LanternaMenuView lanternaMenuView = mock(LanternaMenuView.class);

		viewFactory = mock(ViewFactory.class);
		when(viewFactory.createMenuView()).thenReturn(lanternaMenuView);

		game = mock(Game.class);
		when(game.getViewFactory()).thenReturn(viewFactory);

		List<Button> buttons = new ArrayList<>();
		Button b1 = mock(Button.class);
		Button b2 = mock(Button.class);
		buttons.add(b1);
		buttons.add(b2);


		menuModel = mock(MenuModel.class);
		when(menuModel.getOptions()).thenReturn(buttons);

		MenuState menuStateSpy = spy(new MenuState(game, menuModel));

		MenuController myMenuController = mock(MenuController.class);
		when(myMenuController.isClose()).thenReturn(false, true);

		when(menuStateSpy.getStateController()).thenReturn(myMenuController);

		menuStateSpy.run();

		verify(lanternaMenuView, times(1)).draw(menuModel);
	}


}
