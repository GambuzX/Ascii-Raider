package com.asciiraider.g710.view.swing;

import com.asciiraider.g710.GlobalConfigs;
import com.asciiraider.g710.model.level.LevelModelGroup;
import com.asciiraider.g710.model.menu.MenuModel;
import com.asciiraider.g710.view.ViewFactory;
import com.asciiraider.g710.view.ViewState;
import com.asciiraider.g710.view.swing.game.SwingGroupLevelView;
import com.asciiraider.g710.view.swing.menu.SwingMenuView;

import javax.swing.*;

public class SwingFactory implements ViewFactory {
    private JFrame frame;

    public SwingFactory() {
        frame = new JFrame(GlobalConfigs.JFRAME_NAME);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
    }

    @Override
    public ViewState<MenuModel> createMenuView() {
        return new SwingMenuView(frame);
    }

    @Override
    public ViewState<LevelModelGroup> createLevelView() {
        return new SwingGroupLevelView(frame);
    }
}
