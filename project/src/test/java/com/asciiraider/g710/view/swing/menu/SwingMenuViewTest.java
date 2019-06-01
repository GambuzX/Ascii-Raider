package com.asciiraider.g710.view.swing.menu;

import com.asciiraider.g710.model.gameover.GameOverModel;
import com.asciiraider.g710.model.menu.MenuModel;
import com.asciiraider.g710.view.swing.SwingStateView;
import com.asciiraider.g710.view.swing.gameover.SwingGameOverComponent;
import com.asciiraider.g710.view.swing.gameover.SwingGameOverView;
import org.junit.Test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static junit.framework.TestCase.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

public class SwingMenuViewTest {

    @Test
    public void drawTest() {
        Container containerMock = mock(Container.class);

        KeyListener listenerMock = mock(KeyListener.class);
        doNothing().when(listenerMock).keyPressed(any(KeyEvent.class));

        JFrame jFrameMock = mock(JFrame.class);
        when(jFrameMock.getContentPane()).thenReturn(containerMock);

        SwingMenuComponent menuComponentMock = mock(SwingMenuComponent.class);
        doNothing().when(menuComponentMock).setMenuModel(any(MenuModel.class));

        SwingMenuView menuView = new SwingMenuView(jFrameMock, menuComponentMock);

        MenuModel menuModelMock = mock(MenuModel.class);

        menuView.draw(menuModelMock);

        verify(listenerMock, times(0)).keyPressed(any(KeyEvent.class));
        verify(menuComponentMock, times(1)).setMenuModel(any(MenuModel.class));
        verify(menuComponentMock, times(1)).setFocusable(false);
        verify(containerMock, times(1)).add(any(Component.class), any(String.class));
        verify(jFrameMock, times(1)).setVisible(true);
        verify(jFrameMock, times(1)).pack();
        verify(jFrameMock, times(1)).repaint();
        verify(jFrameMock, times(1)).getContentPane();
        verify(jFrameMock, times(1)).addKeyListener(any(KeyListener.class));
    }
}
