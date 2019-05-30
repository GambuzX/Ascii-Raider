package com.asciiraider.g710.model.utilities;

import com.asciiraider.g710.controller.command.ButtonCommand;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

public class ButtonTest {

	@Test
	public void constructor1(){
		Button b1 = new Button("texto", new Position(2, 3), new Position(4, 5), new HexColorString("123"), new HexColorString("321"));
		assertFalse(b1.isActive());
	}

	@Test
	public void getText(){
		Button b1 = new Button("texto", new Position(2, 3), new Position(4, 5), new HexColorString("123"), new HexColorString("321"));
		assertEquals("texto", b1.getText());
	}

	@Test
	public void getUpperLeft(){
		Position mockPosition = mock(Position.class);
		when(mockPosition.getX()).thenReturn(1);
		when(mockPosition.getY()).thenReturn(2);
		Button b1 = new Button("texto", mockPosition, new Position(4, 5), new HexColorString("123"), new HexColorString("321"));
		assertEquals(1, b1.getUpperLeft().getX());
		assertEquals(2, b1.getUpperLeft().getY());
	}

	@Test
	public void getLowerRight(){
		Position mockPosition = mock(Position.class);
		when(mockPosition.getX()).thenReturn(1);
		when(mockPosition.getY()).thenReturn(2);
		Button b1 = new Button("texto", new Position(2, 3), mockPosition, new HexColorString("123"), new HexColorString("321"));
		assertEquals(1, b1.getLowerRight().getX());
		assertEquals(2, b1.getLowerRight().getY());
	}

	@Test
	public void getBackgroundColor(){
		HexColorString mockColor = mock(HexColorString.class);
		when(mockColor.toString()).thenReturn("certo");
		Button b1 = new Button("texto", new Position(2, 3), new Position(4, 5), mockColor, new HexColorString("321"));
		assertEquals("certo", b1.getBackgroundColor().toString());
	}

	@Test
	public void getTextColor(){
		HexColorString mockColor = mock(HexColorString.class);
		when(mockColor.toString()).thenReturn("certo");
		Button b1 = new Button("texto", new Position(2, 3), new Position(4, 5), new HexColorString("123"),mockColor);
		assertEquals("certo", b1.getTextColor().toString());
	}

	@Test
	public void setActive(){
		Button b1 = new Button("texto", new Position(2, 3), new Position(4, 5), new HexColorString("123"), new HexColorString("321"));
		b1.setActive(true);
		assertTrue(b1.isActive());
	}

	@Test(expected = IllegalAccessError.class)
	public void action(){
		Button b1 = new Button("texto", new Position(2, 3), new Position(4, 5), new HexColorString("123"), new HexColorString("321"));
		ButtonCommand mockButtonCommand = mock(ButtonCommand.class);
		doThrow(new IllegalAccessError()).when(mockButtonCommand).execute();

		b1.setAction(mockButtonCommand);
		b1.getAction().execute();
	}


}
