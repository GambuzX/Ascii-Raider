package com.asciiraider.g710.view.lanterna.game;

import com.asciiraider.g710.GlobalConfigs;
import com.asciiraider.g710.model.element.Element;
import com.asciiraider.g710.model.utilities.HexColorString;
import com.asciiraider.g710.model.utilities.Position;
import com.asciiraider.g710.model.utilities.Symbol;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.TerminalScreen;
import org.junit.Test;

import static org.mockito.Mockito.*;
import static org.mockito.internal.verification.VerificationModeFactory.times;

public class LanternaElementViewTest {

    @Test
    public void drawTest() {
        TextGraphics graphicsMock = mock(TextGraphics.class);

        TerminalScreen screenMock = mock(TerminalScreen.class);
        when(screenMock.newTextGraphics()).thenReturn(graphicsMock);

        LanternaElementView lanternaElementView = new LanternaElementView(screenMock);

        Position positionMock = mock(Position.class);
        when(positionMock.getX()).thenReturn(1);
        when(positionMock.getY()).thenReturn(2);

        Symbol symbolMock = mock(Symbol.class);
        when(symbolMock.getAscii()).thenReturn('X');
        when(symbolMock.getForegroundColorString()).thenReturn("#010101");
        when(symbolMock.getBackgroundColorString()).thenReturn("#101010");

        Element elementMock = mock(Element.class);
        when(elementMock.getPosition()).thenReturn(positionMock);
        when(elementMock.getSymbol()).thenReturn(symbolMock);

        lanternaElementView.draw(elementMock);

        verify(graphicsMock, times(1)).setForegroundColor(TextColor.Factory.fromString("#010101"));
        verify(graphicsMock, times(1)).setBackgroundColor(TextColor.Factory.fromString("#101010"));
        verify(graphicsMock, times(1)).putString(new TerminalPosition(1, 2+ GlobalConfigs.INFOBAR_HEIGHT), "X");
    }
}
