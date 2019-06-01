package com.asciiraider.g710.view.lanterna;

import com.asciiraider.g710.view.lanterna.game.LanternaLevelGroupView;
import com.asciiraider.g710.view.lanterna.gameover.LanternaGameOverView;
import com.asciiraider.g710.view.lanterna.menu.LanternaMenuView;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static junit.framework.TestCase.assertTrue;

public class LanternaFactoryTest {

    private LanternaFactory lanternaFactory;

    @Before
    public void setUp() {
        try {
            lanternaFactory = new LanternaFactory(1,1);
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


}
