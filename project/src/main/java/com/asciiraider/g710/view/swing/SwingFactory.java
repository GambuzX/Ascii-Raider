package com.asciiraider.g710.view.swing;

import com.asciiraider.g710.GlobalConfigs;
import com.asciiraider.g710.model.gameover.GameOverModel;
import com.asciiraider.g710.model.level.LevelModelGroup;
import com.asciiraider.g710.model.menu.MenuModel;
import com.asciiraider.g710.view.ViewFactory;
import com.asciiraider.g710.view.swing.game.SwingGroupLevelView;
import com.asciiraider.g710.view.swing.menu.SwingMenuView;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;

public class SwingFactory implements ViewFactory {
    private JFrame frame;

    public SwingFactory() {
        frame = new JFrame(GlobalConfigs.GAME_NAME);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new MigLayout("insets 0, gap 0 0, wrap 1, fill", "fill, grow", "fill, grow"));
        frame.setSize(new Dimension(GlobalConfigs.LEVEL_WIDTH * GlobalConfigs.SWING_SIZE_FACTOR, (GlobalConfigs.LEVEL_HEIGHT + GlobalConfigs.INFOBAR_HEIGHT) * GlobalConfigs.SWING_SIZE_FACTOR));
    }

    @Override
    public SwingStateView<MenuModel> createMenuView() {
        frame.getContentPane().removeAll();
        return new SwingMenuView(frame);
    }

    @Override
    public SwingStateView<LevelModelGroup> createLevelView() {
        frame.getContentPane().removeAll();
        return new SwingGroupLevelView(frame);
    }

    @Override
    public SwingStateView<GameOverModel> createGameOverView() {
        return null;
    }
}
