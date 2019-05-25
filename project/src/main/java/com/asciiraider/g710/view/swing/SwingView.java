package com.asciiraider.g710.view.swing;

import com.asciiraider.g710.model.level.LevelModelGroup;
import com.asciiraider.g710.view.View;

import javax.swing.*;
import java.awt.*;

public class SwingView extends View<LevelModelGroup> {

    JPanel infoBarPanel;
    JPanel levelPanel;

    SwingLevelView levelView;
    SwingInfoBarView infoBarView;

    public SwingView() {
        JFrame frame = new JFrame("Ascii Raider");
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

        infoBarPanel = new JPanel();
        infoBarPanel.setLayout(new BoxLayout(infoBarPanel, BoxLayout.X_AXIS));

        levelPanel = new JPanel();
        levelPanel.setLayout(new GridLayout());

        levelView = new SwingLevelView(levelPanel);
        infoBarView = new SwingInfoBarView(infoBarPanel);
    }

    @Override
    public void draw(LevelModelGroup model) {

    }

}
