package com.asciiraider.g710.view.swing.resources;

import org.junit.Test;

import static junit.framework.TestCase.assertNotNull;

public class SwingResourceManagerTest {

    private SwingResourceManager swingResourceManager = new SwingResourceManager();

    @Test
    public void getLevelResourcesTest() {
        assertNotNull(swingResourceManager.getLevelResources());
    }

    @Test
    public void getInfoBarResourcesTest() {
        assertNotNull(swingResourceManager.getInfoBarResources());
    }

    @Test
    public void getMenuResourcesTest() {
        assertNotNull(swingResourceManager.getMenuResources());
    }

    @Test
    public void getGameOverResourcesTest() {
        assertNotNull(swingResourceManager.getGameOverResources());
    }
}
