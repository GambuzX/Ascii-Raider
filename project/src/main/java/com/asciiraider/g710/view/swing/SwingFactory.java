package com.asciiraider.g710.view.swing;

import com.asciiraider.g710.model.level.LevelModelGroup;
import com.asciiraider.g710.view.ViewFactory;
import com.asciiraider.g710.view.ViewState;

import javax.swing.*;

public class SwingFactory implements ViewFactory {
    @Override
    public ViewState<LevelModelGroup, JFrame> createView(int width, int height) {
        return new SwingGroupLevelView(width, height);
    }
}
