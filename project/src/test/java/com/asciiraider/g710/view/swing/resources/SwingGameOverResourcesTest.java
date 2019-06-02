package com.asciiraider.g710.view.swing.resources;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertNotNull;

public class SwingGameOverResourcesTest {


    private SwingGameOverResources swingGameOverResources = new SwingGameOverResources();

    @Before
    public void setUp() {
        swingGameOverResources.loadResources();
    }

    @Test
    public void getGameOverBackgroundTest() {
        assertNotNull(swingGameOverResources.getGameOverBackground());
    }
}
