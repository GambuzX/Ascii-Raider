package com.asciiraider.g710.view.swing.game;

import com.asciiraider.g710.model.infobar.InfoBarModel;
import com.asciiraider.g710.model.level.LevelModel;
import com.asciiraider.g710.model.level.LevelModelGroup;
import com.asciiraider.g710.model.menu.MenuModel;
import com.asciiraider.g710.view.swing.menu.SwingMenuComponent;
import com.asciiraider.g710.view.swing.menu.SwingMenuView;
import org.junit.Test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

public class SwingGroupLevelViewTest {

    @Test
    public void drawTest() {
        Container containerMock = mock(Container.class);

        KeyListener listenerMock = mock(KeyListener.class);
        doNothing().when(listenerMock).keyPressed(any(KeyEvent.class));

        JFrame jFrameMock = mock(JFrame.class);
        when(jFrameMock.getContentPane()).thenReturn(containerMock);

        SwingInfoBarComponent infoBarComponentMock = mock(SwingInfoBarComponent.class);
        doNothing().when(infoBarComponentMock).setInfoBarModel(any(InfoBarModel.class));

        SwingLevelComponent levelComponentMock = mock(SwingLevelComponent.class);
        doNothing().when(levelComponentMock).setLevelModel(any(LevelModel.class));

        SwingGroupLevelView groupLevelView = new SwingGroupLevelView(jFrameMock, levelComponentMock, infoBarComponentMock);

        InfoBarModel infoBarModelMock = mock(InfoBarModel.class);
        LevelModel levelModelMock = mock(LevelModel.class);

        LevelModelGroup levelModelGroupMock = mock(LevelModelGroup.class);
        when(levelModelGroupMock.getInfoBarModel()).thenReturn(infoBarModelMock);
        when(levelModelGroupMock.getLevelModel()).thenReturn(levelModelMock);

        groupLevelView.draw(levelModelGroupMock);

        verify(listenerMock, times(0)).keyPressed(any(KeyEvent.class));
        verify(infoBarComponentMock, times(1)).setInfoBarModel(any(InfoBarModel.class));
        verify(levelComponentMock, times(1)).setLevelModel(any(LevelModel.class));
        verify(containerMock, times(2)).add(any(Component.class), any(String.class));
        verify(jFrameMock, times(1)).setVisible(true);
        verify(jFrameMock, times(1)).pack();
        verify(jFrameMock, times(1)).repaint();
        verify(jFrameMock, times(1)).requestFocusInWindow();
        verify(jFrameMock, times(2)).getContentPane();
        verify(jFrameMock, times(1)).addKeyListener(any(KeyListener.class));
    }
}
