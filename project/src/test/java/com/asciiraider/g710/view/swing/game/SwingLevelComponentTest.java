package com.asciiraider.g710.view.swing.game;

import com.asciiraider.g710.GlobalConfigs;
import com.asciiraider.g710.model.element.Element;
import com.asciiraider.g710.model.level.LevelModel;
import com.asciiraider.g710.model.utilities.Position;
import com.asciiraider.g710.view.swing.resources.SwingLevelResources;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.awt.image.BufferedImage;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.*;

public class SwingLevelComponentTest {

    private SwingLevelComponent levelComponent;
    private SwingLevelResources levelResourcesMock;

    @Before
    public void setUp() {
        BufferedImage imageMock = mock(BufferedImage.class);

        levelResourcesMock = mock(SwingLevelResources.class);
        when(levelResourcesMock.getElementImage(any(Element.class))).thenReturn(imageMock);

        levelComponent = new SwingLevelComponent(levelResourcesMock);
    }

    @Test
    public void paintComponentTest() {
        Graphics graphicsMock = mock(Graphics.class);
        when(graphicsMock.drawImage(any(BufferedImage.class), any(Integer.class), any(Integer.class), isNull())).thenReturn(true);
        when(graphicsMock.create()).thenReturn(graphicsMock);

        Element elementMock = mock(Element.class);

        LevelModel levelModelMock = mock(LevelModel.class);
        when(levelModelMock.findElement(any(Position.class))).thenReturn(elementMock);

        levelComponent.setLevelModel(levelModelMock);
        levelComponent.paintComponent(graphicsMock);

        int iters = GlobalConfigs.LEVEL_WIDTH * GlobalConfigs.LEVEL_HEIGHT;

        verify(levelModelMock, times(iters)).findElement(any(Position.class));
        verify(levelResourcesMock, times(iters)).getElementImage(any(Element.class));
        verify(graphicsMock, times(iters)).drawImage(any(BufferedImage.class), any(Integer.class), any(Integer.class), isNull());

    }
}
