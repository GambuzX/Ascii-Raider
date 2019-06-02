package com.asciiraider.g710.view.swing.resources;

import com.asciiraider.g710.model.element.*;
import com.asciiraider.g710.model.utilities.Symbol;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SwingLevelResourcesTest {

    private SwingLevelResources swingLevelResources = new SwingLevelResources();

    @Before
    public void setUp() {
        swingLevelResources.loadResources();
    }

    @Test
    public void getElementImageTest() {
        assertNotNull(swingLevelResources.getElementImage(mock(Wall.class)));
        assertNotNull(swingLevelResources.getElementImage(mock(TNT.class)));
        assertNotNull(swingLevelResources.getElementImage(mock(Player.class)));
        assertNotNull(swingLevelResources.getElementImage(mock(LevelKey.class)));
        assertNotNull(swingLevelResources.getElementImage(mock(ExitDoor.class)));
        assertNotNull(swingLevelResources.getElementImage(mock(Sand.class)));
        assertNotNull(swingLevelResources.getElementImage(mock(StoneBlock.class)));
        assertNotNull(swingLevelResources.getElementImage(mock(MummyEnemy.class)));
        assertNotNull(swingLevelResources.getElementImage(mock(SkullEnemy.class)));
        assertNotNull(swingLevelResources.getElementImage(mock(DoorKey.class)));
        assertNotNull(swingLevelResources.getElementImage(mock(Door.class)));
        assertNotNull(swingLevelResources.getElementImage(mock(Boulder.class)));
    }

    @Test
    public void getExplosionBigTest() {
        Symbol symbolMock = mock(Symbol.class);
        when(symbolMock.getAscii()).thenReturn('●');

        Explosion explosionMock = mock(Explosion.class);
        when(explosionMock.getSymbol()).thenReturn(symbolMock);
        assertNotNull(swingLevelResources.getElementImage(explosionMock));
    }

    @Test
    public void getExplosionMediumTest() {
        Symbol symbolMock = mock(Symbol.class);
        when(symbolMock.getAscii()).thenReturn('⦁');

        Explosion explosionMock = mock(Explosion.class);
        when(explosionMock.getSymbol()).thenReturn(symbolMock);
        assertNotNull(swingLevelResources.getElementImage(explosionMock));
    }

    @Test
    public void getExplosionSmallTest() {
        Symbol symbolMock = mock(Symbol.class);
        when(symbolMock.getAscii()).thenReturn('٠');

        Explosion explosionMock = mock(Explosion.class);
        when(explosionMock.getSymbol()).thenReturn(symbolMock);
        assertNotNull(swingLevelResources.getElementImage(explosionMock));
    }
}
