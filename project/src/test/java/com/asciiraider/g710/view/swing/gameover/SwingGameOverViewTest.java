package com.asciiraider.g710.view.swing.gameover;

import com.asciiraider.g710.model.gameover.GameOverModel;
import com.asciiraider.g710.view.swing.SwingStateView;
import org.junit.Test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static junit.framework.TestCase.assertTrue;
import static org.mockito.Mockito.*;

public class SwingGameOverViewTest {

    @Test
    public void drawTest() {
        Container containerMock = mock(Container.class);

        KeyListener listenerMock = mock(KeyListener.class);
        doNothing().when(listenerMock).keyPressed(any(KeyEvent.class));

        JFrame jFrameMock = mock(JFrame.class);
        when(jFrameMock.getContentPane()).thenReturn(containerMock);

        SwingGameOverComponent gameOverComponentMock = mock(SwingGameOverComponent.class);
        doNothing().when(gameOverComponentMock).setGameOverModel(any(GameOverModel.class));

        SwingGameOverView gameOverView = new SwingGameOverView(jFrameMock, gameOverComponentMock);

        GameOverModel gameOverModelMock = mock(GameOverModel.class);

        gameOverView.draw(gameOverModelMock);

        verify(listenerMock, times(0)).keyPressed(any(KeyEvent.class));
        verify(gameOverComponentMock, times(1)).setGameOverModel(any(GameOverModel.class));
        verify(containerMock, times(1)).add(any(Component.class), any(String.class));
        verify(jFrameMock, times(1)).setVisible(true);
        verify(jFrameMock, times(1)).pack();
        verify(jFrameMock, times(1)).repaint();
        verify(jFrameMock, times(1)).getContentPane();
        verify(jFrameMock, times(1)).addKeyListener(any(KeyListener.class));
    }
}
