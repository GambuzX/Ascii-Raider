package com.asciiraider.g710.view.lanterna;

import com.asciiraider.g710.view.lanterna.game.LanternaLevelGroupView;
import com.asciiraider.g710.view.lanterna.gameover.LanternaGameOverView;
import com.asciiraider.g710.view.lanterna.menu.LanternaMenuView;
import com.googlecode.lanterna.screen.TerminalScreen;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static junit.framework.TestCase.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;

public class LanternaFactoryTest {

    private LanternaFactory lanternaFactory;
    private TerminalScreen screenMock;

    @Before
    public void setUp() {

        screenMock = mock(TerminalScreen.class);

        try {
            lanternaFactory = new LanternaFactory(screenMock);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void createMenuViewTest() {
        assertTrue(lanternaFactory.createMenuView() instanceof LanternaMenuView);
    }

    @Test
    public void createLevelViewTest() {
        assertTrue(lanternaFactory.createLevelView() instanceof LanternaLevelGroupView);
    }

    @Test
    public void createGameOverViewTest() {
        assertTrue(lanternaFactory.createGameOverView() instanceof LanternaGameOverView);
    }

    @Test
    public void constructorTest() {
        verify(screenMock, times(1)).setCursorPosition(null);
        verify(screenMock, times(1)).doResizeIfNecessary();
        try {
            verify(screenMock, times(1)).startScreen();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
