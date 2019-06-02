package com.asciiraider.g710.view.swing.resources;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertNotNull;

public class SwingMenuResourcesTest {

    private SwingMenuResources swingMenuResources = new SwingMenuResources();

    @Before
    public void setUp() {
        swingMenuResources.loadResources();
    }

    @Test
    public void getPlayButtonTest() {
        assertNotNull(swingMenuResources.getPlayButton());
    }

    @Test
    public void getPlayButtonHoveredTest() {
        assertNotNull(swingMenuResources.getPlayButtonHovered());
    }

    @Test
    public void getExitButtonTest() {
        assertNotNull(swingMenuResources.getExitButton());
    }

    @Test
    public void getExitButtonHoveredTest() {
        assertNotNull(swingMenuResources.getExitButtonHovered());
    }

    @Test
    public void getMenuBackgroundTest() {
        assertNotNull(swingMenuResources.getMenuBackground());
    }
}
