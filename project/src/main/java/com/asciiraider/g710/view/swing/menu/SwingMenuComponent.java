package com.asciiraider.g710.view.swing.menu;

import com.asciiraider.g710.GlobalConfigs;
import com.asciiraider.g710.model.menu.MenuModel;
import com.asciiraider.g710.model.utilities.Button;

import javax.swing.*;
import java.awt.*;

public class SwingMenuComponent extends JPanel {

    private int width;
    private int height;

    private MenuModel menuModel;
    private SwingMenuResources menuResources;

    public SwingMenuComponent() {
        width = GlobalConfigs.LEVEL_WIDTH * GlobalConfigs.SWING_SIZE_FACTOR;
        height = (GlobalConfigs.LEVEL_HEIGHT + 1) * GlobalConfigs.SWING_SIZE_FACTOR;
        menuResources = new SwingMenuResources();
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

        graphics.drawImage(menuResources.getMenuImg(), 0, 0, null);

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
