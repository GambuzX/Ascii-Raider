package com.asciiraider.g710.model.menu;


import com.asciiraider.g710.model.utilities.Button;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MenuModelTest {
	MenuModel menuModel;

	@Before
	public void setUp(){
	 	menuModel = new MenuModel();
	}

	@Test
	public void buttons(){
		assertEquals(2, menuModel.getOptions().size());
	}

	@Test
	public void defautlSelected(){
		assertTrue(menuModel.getSelectedButton().isActive());
	}

	@Test
	public void numberButtons(){
		assertEquals(2, menuModel.getNumberOptions());
	}

	@Test
	public void getSelected1(){
		assertEquals(0, menuModel.getSelected());
	}

	@Test
	public void nextOption1(){
		menuModel.nextOption();
		assertEquals(1, menuModel.getSelected());
	}

	@Test
	public void nextOption2(){
		menuModel.nextOption();
		assertFalse(menuModel.getOptions().get(0).isActive());
	}

	@Test
	public void nextOption3(){
		menuModel.nextOption();
		assertTrue(menuModel.getOptions().get(menuModel.getSelected()).isActive());
	}

	@Test
	public void getSelected2(){
		menuModel.nextOption();
		menuModel.nextOption();
		assertEquals(0, menuModel.getSelected());
	}

	@Test
	public void getPrevious1(){
		menuModel.previousOption();
		assertEquals(1, menuModel.getSelected());
	}

	@Test
	public void getPrevious2(){
		menuModel.previousOption();
		assertFalse(menuModel.getOptions().get(0).isActive());
	}

	@Test
	public void getPrevious3(){
		menuModel.previousOption();
		assertTrue(menuModel.getOptions().get(menuModel.getSelected()).isActive());
	}

	@Test
	public void getPrevious4(){
		menuModel.nextOption();
		menuModel.previousOption();
		assertEquals(0, menuModel.getSelected());
	}

	@Test
	public void addOptions1(){
		Button mockButton = mock(Button.class);
		menuModel.addOption(mockButton);
		assertEquals(3, menuModel.getNumberOptions());
	}

	@Test
	public void getSelectedButton(){
		Button mockButton = mock(Button.class);
		when(mockButton.getText()).thenReturn("certo");
		menuModel.addOption(mockButton);
		menuModel.previousOption();
		assertEquals("certo", menuModel.getSelectedButton().getText());
	}

}
