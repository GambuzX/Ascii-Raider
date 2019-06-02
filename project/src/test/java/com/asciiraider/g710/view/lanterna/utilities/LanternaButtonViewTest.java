package com.asciiraider.g710.view.lanterna.utilities;

import com.asciiraider.g710.model.utilities.Button;
import com.asciiraider.g710.model.utilities.HexColorString;
import com.asciiraider.g710.model.utilities.Position;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.TerminalScreen;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class LanternaButtonViewTest {

    private LanternaButtonView lanternaButtonView;
    private final int counters[] = new int[3];

    private TextGraphics graphicsMock;
    private Position upperLeftMock, bottomRightMock;

    @Before
    public void setUp() {

        graphicsMock = mock(TextGraphics.class);

        TerminalScreen screenMock = mock(TerminalScreen.class);
        when(screenMock.newTextGraphics()).thenReturn(graphicsMock);

        upperLeftMock = mock(Position.class);
        when(upperLeftMock.getX()).thenReturn(1);
        when(upperLeftMock.getY()).thenReturn(1);

        bottomRightMock = mock(Position.class);
        when(bottomRightMock.getX()).thenReturn(5);
        when(bottomRightMock.getY()).thenReturn(5);

        lanternaButtonView = new LanternaButtonView(screenMock);

    }

    @Test
    public void drawTest1() {
        Button modelMock = mock(Button.class);
        when(modelMock.getUpperLeft()).thenReturn(upperLeftMock);
        when(modelMock.getLowerRight()).thenReturn(bottomRightMock);
        when(modelMock.getBackgroundColor()).thenReturn(new HexColorString("4a7c45"));
        when(modelMock.getTextColor()).thenReturn(new HexColorString("4a7c45"));
        when(modelMock.getText()).thenReturn("abc");
        when(modelMock.isActive()).thenReturn(true);
        lanternaButtonView.draw(modelMock);

        verify(graphicsMock, times(1)).setBackgroundColor(TextColor.Factory.fromString("#4a7c45"));
        verify(graphicsMock, times(1)).setForegroundColor(any(TextColor.class));
        verify(graphicsMock, times(16)).putString(any(TerminalPosition.class), any(String.class));
        verify(modelMock, times(1)).isActive();
        verify(graphicsMock, times(1)).putString(1, 3, "abc");
    }

    @Test
    public void drawTest2() {
        Button modelMock = mock(Button.class);
        when(modelMock.getUpperLeft()).thenReturn(upperLeftMock);
        when(modelMock.getLowerRight()).thenReturn(bottomRightMock);
        when(modelMock.getBackgroundColor()).thenReturn(new HexColorString("4a7c45"));
        when(modelMock.getTextColor()).thenReturn(new HexColorString("4a7c45"));
        when(modelMock.getText()).thenReturn(" ");
        when(modelMock.isActive()).thenReturn(false);
        lanternaButtonView.draw(modelMock);

        verify(graphicsMock, times(1)).setBackgroundColor(any(TextColor.class));
        verify(graphicsMock, times(1)).setForegroundColor(any(TextColor.class));
        verify(graphicsMock, times(1)).putString(any(Integer.class), any(Integer.class), any(String.class));
        verify(graphicsMock, times(16)).putString(any(TerminalPosition.class), any(String.class));
        verify(modelMock, times(1)).isActive();
    }

    @Test
    public void drawRectangle() {
        lanternaButtonView.drawRectangle(graphicsMock, upperLeftMock, bottomRightMock);
        verify(graphicsMock, times(16)).putString(any(TerminalPosition.class), any(String.class));
    }
}
