package com.asciiraider.g710.view.swing;

import com.asciiraider.g710.view.swing.game.SwingGroupLevelView;
import com.asciiraider.g710.view.swing.gameover.SwingGameOverView;
import com.asciiraider.g710.view.swing.menu.SwingMenuView;
import org.junit.Before;
import org.junit.Test;

import javax.swing.*;

import java.awt.*;
import java.awt.event.KeyListener;
import java.security.Key;

import static junit.framework.TestCase.assertTrue;
import static org.mockito.Mockito.*;
import static org.mockito.internal.verification.VerificationModeFactory.times;

public class SwingFactoryTest {
    private SwingFactory swingFactory;
    JFrame jFrameMock;

    @Before
    public void setUp() {
        KeyListener listenerMock = mock(KeyListener.class);
        KeyListener keyListenerMocks[] = new KeyListener[1];
        keyListenerMocks[0] = mock(KeyListener.class);

        Container mockContainer = mock(Container.class);

        jFrameMock = mock(JFrame.class);
        jFrameMock.addKeyListener(listenerMock);
        when(jFrameMock.getContentPane()).thenReturn(mockContainer);
        when(jFrameMock.getKeyListeners()).thenReturn(keyListenerMocks);
        doNothing().when(jFrameMock).removeKeyListener(any(KeyListener.class));

        swingFactory = new SwingFactory(jFrameMock);
    }

    @Test
    public void createMenuViewTest() {
        assertTrue(swingFactory.createMenuView() instanceof SwingMenuView);
        verify(jFrameMock, times(1)).removeKeyListener(any(KeyListener.class));
        verify(jFrameMock, times(2)).getContentPane();
    }

    @Test
    public void createLevelViewTest() {
        assertTrue(swingFactory.createLevelView() instanceof SwingGroupLevelView);
        verify(jFrameMock, times(1)).removeKeyListener(any(KeyListener.class));
        verify(jFrameMock, times(3)).getContentPane();
    }

    @Test
    public void createGameOverViewTest() {
        assertTrue(swingFactory.createGameOverView() instanceof SwingGameOverView);
        verify(jFrameMock, times(1)).removeKeyListener(any(KeyListener.class));
        verify(jFrameMock, times(2)).getContentPane();
    }

    @Test
    public void constructorTest() {
        verify(jFrameMock, times(1)).setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        verify(jFrameMock, times(1)).setLayout(any(LayoutManager.class));
        verify(jFrameMock, times(1)).setSize(any(Dimension.class));
    }

    @Test
    public void removeKeyListenersTest() {
        swingFactory.removeKeyListeners();
        verify(jFrameMock, times(1)).removeKeyListener(any(KeyListener.class));
    }
}
