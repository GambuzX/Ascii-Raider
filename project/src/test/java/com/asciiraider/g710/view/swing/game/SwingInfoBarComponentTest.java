package com.asciiraider.g710.view.swing.game;

import com.asciiraider.g710.GlobalConfigs;
import com.asciiraider.g710.model.element.Element;
import com.asciiraider.g710.model.infobar.InfoBarModel;
import com.asciiraider.g710.model.level.LevelModel;
import com.asciiraider.g710.model.utilities.Position;
import com.asciiraider.g710.view.swing.resources.SwingInfoBarResources;
import com.asciiraider.g710.view.swing.resources.SwingLevelResources;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.awt.image.BufferedImage;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

public class SwingInfoBarComponentTest {

    private SwingInfoBarComponent infoBarComponent;
    private SwingInfoBarResources infoBarResourcesMock;

    @Before
    public void setUp() {
        BufferedImage imageMock = mock(BufferedImage.class);

        infoBarResourcesMock = mock(SwingInfoBarResources.class);
        when(infoBarResourcesMock.getBackground()).thenReturn(imageMock);
        when(infoBarResourcesMock.getPharaoh()).thenReturn(imageMock);
        when(infoBarResourcesMock.getPlayer()).thenReturn(imageMock);
        when(infoBarResourcesMock.getPlayerDead()).thenReturn(imageMock);
        when(infoBarResourcesMock.getRButton()).thenReturn(imageMock);

        infoBarComponent = new SwingInfoBarComponent(infoBarResourcesMock);
    }

    @Test
    public void paintComponentTest() {
        Graphics graphicsMock = mock(Graphics.class);
        when(graphicsMock.drawImage(any(BufferedImage.class), any(Integer.class), any(Integer.class), isNull())).thenReturn(true);
        when(graphicsMock.create()).thenReturn(graphicsMock);

        Element elementMock = mock(Element.class);

        InfoBarModel infoBarModel = mock(InfoBarModel.class);
        when(infoBarModel.getLives()).thenReturn(3);
        when(infoBarModel.getCurrentLevel()).thenReturn(5);
        when(infoBarModel.getKeys()).thenReturn(1);
        when(infoBarModel.getMaxKeys()).thenReturn(2);
        when(infoBarModel.getScore()).thenReturn(12);
        when(infoBarModel.getTime()).thenReturn(58);

        infoBarComponent.setInfoBarModel(infoBarModel);
        infoBarComponent.paintComponent(graphicsMock);

        verify(infoBarResourcesMock, times(1)).getBackground();
        verify(infoBarResourcesMock, times(1)).getRButton();
        verify(infoBarResourcesMock, times(1)).getPharaoh();
        verify(infoBarResourcesMock, times(3)).getPlayer();
        verify(infoBarResourcesMock, times(0)).getPlayerDead();
        verify(graphicsMock, times(6)).drawImage(any(BufferedImage.class), any(Integer.class), any(Integer.class), isNull());

    }
}
