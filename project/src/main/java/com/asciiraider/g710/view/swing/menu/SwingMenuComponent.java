package com.asciiraider.g710.view.swing.menu;

import com.asciiraider.g710.GlobalConfigs;
import com.asciiraider.g710.model.menu.MenuModel;

import javax.swing.*;
import java.awt.*;

public class SwingMenuComponent extends JPanel {

    private int width;
    private int height;

    private MenuModel menuModel;

    private JButton playButton;
    private JButton exitButton;

    public SwingMenuComponent() {
        width = GlobalConfigs.LEVEL_WIDTH * GlobalConfigs.SWING_SIZE_FACTOR;
        height = (GlobalConfigs.LEVEL_HEIGHT + 1) * GlobalConfigs.SWING_SIZE_FACTOR;

        playButton = new JButton("PLAY");
        exitButton = new JButton("EXIT");

        this.add(playButton);
        this.add(exitButton);

        playButton.setFocusable(false);
        exitButton.setFocusable(false);

        playButton.addActionListener(actionEvent -> System.out.println("Play game!"));

        exitButton.addActionListener(actionEvent -> System.out.println("Exit game!"));
    }

    public void setMenuModel(MenuModel menuModel) {
        this.menuModel = menuModel;
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(width, height);
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
    }
}
