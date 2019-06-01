package com.asciiraider.g710.view.swing.gameover;

import com.asciiraider.g710.model.gameover.GameOverModel;
import com.asciiraider.g710.model.infobar.Score;
import com.asciiraider.g710.view.swing.resources.SwingGameOverResources;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.awt.image.BufferedImage;

import static org.mockito.Mockito.*;

public class SwingGameOverComponentTest {

    private SwingGameOverComponent gameOverComponent;
    private SwingGameOverResources resourcesMock;

    @Before
    public void setUp() {
        BufferedImage imageMock = mock(BufferedImage.class);

        resourcesMock = mock(SwingGameOverResources.class);
        when(resourcesMock.getGameOverBackground()).thenReturn(imageMock);

        gameOverComponent = new SwingGameOverComponent(resourcesMock);
    }

    @Test
    public void setGameOverModelTest() {
        Score scoreMock = mock(Score.class);
        when(scoreMock.toString()).thenReturn("teste");

        GameOverModel gameOverModelMock = mock(GameOverModel.class);
        when(gameOverModelMock.getFinalScore()).thenReturn(scoreMock);
        gameOverComponent.setGameOverModel(gameOverModelMock);

        verify(gameOverModelMock, times(1)).getFinalScore();

    }

    @Test
    public void paintComponentTest() {
        Graphics graphicsMock = mock(Graphics.class);
        when(graphicsMock.drawImage(any(BufferedImage.class), any(Integer.class), any(Integer.class), isNull())).thenReturn(true);
        when(graphicsMock.create()).thenReturn(graphicsMock);

        gameOverComponent.paintComponent(graphicsMock);

        verify(graphicsMock, times(1)).drawImage(any(BufferedImage.class), any(Integer.class), any(Integer.class), isNull());

    }
}
