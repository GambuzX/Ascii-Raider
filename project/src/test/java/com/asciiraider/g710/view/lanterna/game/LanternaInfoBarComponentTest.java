package com.asciiraider.g710.view.lanterna.game;

import com.asciiraider.g710.model.infobar.InfoBarModel;
import com.asciiraider.g710.model.utilities.HexColorString;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.TerminalScreen;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.internal.verification.VerificationModeFactory.times;

public class LanternaInfoBarComponentTest {

    private static final String rButton = "®";
    private static final String withLife = "❤";
    private static final HexColorString backgroundColor = new HexColorString("E0A21D");
    private static final HexColorString textColor = new HexColorString("000000");
    private static final HexColorString divideSectionColor = new HexColorString("1");

    TerminalScreen screenMock;
    TextGraphics graphicsMock;
    InfoBarModel infoBarModelMock;

    @Before
    public void setUp() {
        graphicsMock = mock(TextGraphics.class);

        screenMock = mock(TerminalScreen.class);
        when(screenMock.newTextGraphics()).thenReturn(graphicsMock);

        infoBarModelMock = mock(InfoBarModel.class);
        when(infoBarModelMock.getScore()).thenReturn(12);

    }

    @Test
    public void drawTest3Lives() {

        when(infoBarModelMock.getLives()).thenReturn(3);
        when(infoBarModelMock.getTime()).thenReturn(10);

        LanternaInfoBarComponent infoBarComponent = new LanternaInfoBarComponent(screenMock);
        infoBarComponent.draw(infoBarModelMock);

        verify(graphicsMock, times(1)).setBackgroundColor(TextColor.Factory.fromString(backgroundColor.toString()));
        verify(graphicsMock, times(26)).setForegroundColor(any(TextColor.class));

        verify(graphicsMock, times(1)).putString(new TerminalPosition( 10, 0), "1");
        verify(graphicsMock, times(1)).putString(new TerminalPosition( 11, 0), "0");

    }

    @Test
    public void drawTest2Lives() {

        when(infoBarModelMock.getLives()).thenReturn(2);

        LanternaInfoBarComponent infoBarComponent = new LanternaInfoBarComponent(screenMock);
        infoBarComponent.draw(infoBarModelMock);

        verify(graphicsMock, times(1)).setBackgroundColor(TextColor.Factory.fromString(backgroundColor.toString()));
        verify(graphicsMock, times(27)).setForegroundColor(any(TextColor.class));

    }

    @Test
    public void drawTest1Life() {

        when(infoBarModelMock.getLives()).thenReturn(1);

        LanternaInfoBarComponent infoBarComponent = new LanternaInfoBarComponent(screenMock);
        infoBarComponent.draw(infoBarModelMock);

        verify(graphicsMock, times(1)).setBackgroundColor(TextColor.Factory.fromString(backgroundColor.toString()));
        verify(graphicsMock, times(28)).setForegroundColor(any(TextColor.class));

    }
}
