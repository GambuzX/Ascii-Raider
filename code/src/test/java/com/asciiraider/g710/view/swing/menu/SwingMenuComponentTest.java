package com.asciiraider.g710.view.swing.menu;

import com.asciiraider.g710.model.menu.MenuModel;
import com.asciiraider.g710.model.utilities.Position;
import com.asciiraider.g710.model.utilities.Button;
import com.asciiraider.g710.view.swing.resources.SwingMenuResources;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.List;
import java.util.ArrayList;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.*;

public class SwingMenuComponentTest {

    private SwingMenuComponent menuComponent;
    private SwingMenuResources menuResourcesMock;

    @Before
    public void setUp() {
        BufferedImage imageMock = mock(BufferedImage.class);

        menuResourcesMock = mock(SwingMenuResources.class);
        when(menuResourcesMock.getPlayButton()).thenReturn(imageMock);
        when(menuResourcesMock.getPlayButtonHovered()).thenReturn(imageMock);
        when(menuResourcesMock.getPlayButtonHovered()).thenReturn(imageMock);
        when(menuResourcesMock.getExitButton()).thenReturn(imageMock);
        when(menuResourcesMock.getExitButtonHovered()).thenReturn(imageMock);
        when(menuResourcesMock.getMenuBackground()).thenReturn(imageMock);


        menuComponent = new SwingMenuComponent(menuResourcesMock);
    }

    @Test
    public void paintComponentTest() {
        Graphics graphicsMock = mock(Graphics.class);
        when(graphicsMock.drawImage(any(BufferedImage.class), any(Integer.class), any(Integer.class), isNull())).thenReturn(true);
        when(graphicsMock.create()).thenReturn(graphicsMock);

        Position positionMock = mock(Position.class);
        when(positionMock.getX()).thenReturn(12);

        Button buttonMock = mock(Button.class);
        when(buttonMock.getUpperLeft()).thenReturn(positionMock);

        List<Button> buttonMocks = new ArrayList<>();
        buttonMocks.add(buttonMock);
        buttonMocks.add(buttonMock);

        MenuModel menuModelMock = mock(MenuModel.class);
        when(menuModelMock.getOptions()).thenReturn(buttonMocks);
        when(menuModelMock.getSelected()).thenReturn(0);

        menuComponent.setMenuModel(menuModelMock);
        menuComponent.paintComponent(graphicsMock);

        verify(menuResourcesMock, times(1)).getExitButton();
        verify(menuResourcesMock, times(1)).getMenuBackground();
        verify(menuResourcesMock, times(1)).getPlayButtonHovered();
        verify(positionMock, times(2)).getX();
        verify(buttonMock, times(2)).getUpperLeft();
        verify(graphicsMock, times(3)).drawImage(any(BufferedImage.class), any(Integer.class), any(Integer.class), isNull());

    }
}
