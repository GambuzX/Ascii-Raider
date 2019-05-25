package com.asciiraider.g710.view.swing;

import com.asciiraider.g710.model.level.LevelModelGroup;
import com.asciiraider.g710.model.menu.MenuModel;
import com.asciiraider.g710.view.ViewFactory;
import com.asciiraider.g710.view.ViewState;

import javax.swing.*;

public class SwingFactory implements ViewFactory {
    private JFrame frame;

    @Override
    public ViewState<MenuModel> createMenuView() {
        return null;
    }

    @Override
    public ViewState<LevelModelGroup> createLevelView() {
        return new SwingGroupLevelView();
    }
}
