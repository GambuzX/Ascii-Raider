package com.asciiraider.g710.view.swing.resources;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertNotNull;

public class SwingInfoBarResourcesTest {
    private SwingInfoBarResources swingInfoBarResources = new SwingInfoBarResources();

    @Before
    public void setUp() {
        swingInfoBarResources.loadResources();
    }

    @Test
    public void getBackgroundTest() {
        assertNotNull(swingInfoBarResources.getBackground());
    }

    @Test
    public void getPharaohTest() {
        assertNotNull(swingInfoBarResources.getPharaoh());
    }

    @Test
    public void getPlayerTest() {
        assertNotNull(swingInfoBarResources.getPlayer());
    }

    @Test
    public void getPlayerDeadTest() {
        assertNotNull(swingInfoBarResources.getPlayerDead());
    }

    @Test
    public void getRButtonTest() {
        assertNotNull(swingInfoBarResources.getRButton());
    }
}
