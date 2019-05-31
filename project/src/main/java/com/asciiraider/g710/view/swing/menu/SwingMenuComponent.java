package com.asciiraider.g710.view.swing.menu;

import com.asciiraider.g710.GlobalConfigs;
import com.asciiraider.g710.model.menu.MenuModel;
import com.asciiraider.g710.model.utilities.Button;
import com.asciiraider.g710.view.swing.resources.SwingMenuResources;

import javax.swing.*;
import java.awt.*;

public class SwingMenuComponent extends JPanel {

    final static int WIDTH = GlobalConfigs.LEVEL_WIDTH * GlobalConfigs.SWING_SIZE_FACTOR;
    final static int HEIGHT = (GlobalConfigs.LEVEL_HEIGHT + GlobalConfigs.INFOBAR_HEIGHT) * GlobalConfigs.SWING_SIZE_FACTOR;

    private MenuModel menuModel;
    private SwingMenuResources menuResources;

    SwingMenuComponent(SwingMenuResources menuResources) {
        this.menuResources = menuResources;
    }

    void setMenuModel(MenuModel menuModel) {
        this.menuModel = menuModel;
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        graphics.drawImage(menuResources.getMenuBackground(), 0, 0, null);

        Button playBtn = menuModel.getOptions().get(0);
        graphics.drawImage(
                menuModel.getSelected() == 0 ? menuResources.getPlayButtonHovered() : menuResources.getPlayButton(),
                playBtn.getUpperLeft().getX() * GlobalConfigs.SWING_SIZE_FACTOR,
                GlobalConfigs.SWING_MENU_PLAY_BTN_Y * GlobalConfigs.SWING_SIZE_FACTOR,
                null);

        Button exitBtn = menuModel.getOptions().get(1);
        graphics.drawImage(
                menuModel.getSelected() == 1 ? menuResources.getExitButtonHovered() : menuResources.getExitButton(),
                exitBtn.getUpperLeft().getX() * GlobalConfigs.SWING_SIZE_FACTOR,
                GlobalConfigs.SWING_MENU_EXIT_BTN_Y * GlobalConfigs.SWING_SIZE_FACTOR,
                null);

    }
}
