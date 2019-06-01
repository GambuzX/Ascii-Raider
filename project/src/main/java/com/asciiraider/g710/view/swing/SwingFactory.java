package com.asciiraider.g710.view.swing;

import com.asciiraider.g710.GlobalConfigs;
import com.asciiraider.g710.model.gameover.GameOverModel;
import com.asciiraider.g710.model.level.LevelModelGroup;
import com.asciiraider.g710.model.menu.MenuModel;
import com.asciiraider.g710.view.ViewFactory;
import com.asciiraider.g710.view.swing.game.SwingGroupLevelView;
import com.asciiraider.g710.view.swing.gameover.SwingGameOverComponent;
import com.asciiraider.g710.view.swing.gameover.SwingGameOverView;
import com.asciiraider.g710.view.swing.menu.SwingMenuView;
import com.asciiraider.g710.view.swing.resources.SwingResourceManager;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;

public class SwingFactory implements ViewFactory {
    private JFrame frame;
    private SwingResourceManager resourceManager;

    public SwingFactory(JFrame frame) {
        this.frame = frame;
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new MigLayout("wrap 1, insets 0 0, gap 0 0, fill, align 0% 0%"));
        frame.setSize(new Dimension(GlobalConfigs.LEVEL_WIDTH * GlobalConfigs.SWING_SIZE_FACTOR, (GlobalConfigs.LEVEL_HEIGHT + GlobalConfigs.INFOBAR_HEIGHT) * GlobalConfigs.SWING_SIZE_FACTOR));
        resourceManager = new SwingResourceManager();
    }

    @Override
    public SwingStateView<MenuModel> createMenuView() {
        frame.getContentPane().removeAll();
        removeKeyListeners();
        return new SwingMenuView(frame, resourceManager);
    }

    @Override
    public SwingStateView<LevelModelGroup> createLevelView() {
        frame.getContentPane().removeAll();
        removeKeyListeners();
        return new SwingGroupLevelView(frame, resourceManager);
    }

    @Override
    public SwingStateView<GameOverModel> createGameOverView() {
        frame.getContentPane().removeAll();
        removeKeyListeners();

        return new SwingGameOverView(frame, resourceManager);
    }

    public void removeKeyListeners() {
        for (KeyListener kl : frame.getKeyListeners()) {
            frame.removeKeyListener(kl);
        }
    }
}
