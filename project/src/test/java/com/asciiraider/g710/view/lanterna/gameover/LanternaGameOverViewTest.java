package com.asciiraider.g710.view.lanterna.gameover;

import com.asciiraider.g710.GlobalConfigs;
import com.asciiraider.g710.model.gameover.GameOverModel;
import com.asciiraider.g710.model.infobar.Score;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.TerminalScreen;
import org.junit.Test;

import java.io.IOException;

import static org.mockito.Mockito.*;
import static org.mockito.internal.verification.VerificationModeFactory.times;

public class LanternaGameOverViewTest {

    @Test
    public void testDraw() {
        TextGraphics graphicsMock = mock(TextGraphics.class);

        TerminalScreen screenMock = mock(TerminalScreen.class);
        when(screenMock.newTextGraphics()).thenReturn(graphicsMock);

        LanternaGameOverView lanternaGameOverView = new LanternaGameOverView(screenMock);

        Score scoreMock = mock(Score.class);
        when(scoreMock.toString()).thenReturn("123");

        GameOverModel gameOverModelMock = mock(GameOverModel.class);
        when(gameOverModelMock.getFinalScore()).thenReturn(scoreMock);

        lanternaGameOverView.draw(gameOverModelMock);


        String gameOver = "GAME OVER";
        int column  = (GlobalConfigs.LEVEL_WIDTH - gameOver.length()) / 2;
        verify(graphicsMock, times(1)).putString(column, 4, gameOver);

        column  = (GlobalConfigs.LEVEL_WIDTH - 3) / 2;
        verify(graphicsMock, times(1)).putString(column, 6, "123");
        verify(screenMock, times(1)).clear();
        verify(screenMock, times(1)).newTextGraphics();
        try {
            verify(screenMock, times(1)).refresh();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
