package com.asciiraider.g710.view.lanterna;

import com.asciiraider.g710.model.menu.MenuModel;
import com.asciiraider.g710.view.ViewFactory;
import com.asciiraider.g710.view.ViewState;
import com.asciiraider.g710.view.lanterna.menu.LanternaMenuView;
import com.googlecode.lanterna.screen.TerminalScreen;

import java.io.IOException;

public class LanternaFactory implements ViewFactory {
    @Override
    public ViewState<MenuModel, TerminalScreen> createView(int width, int height) {
        // TODO: depois ver aqui
        try {
            return new LanternaMenuView(width, height);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
