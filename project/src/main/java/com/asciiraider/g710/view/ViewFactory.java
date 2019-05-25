package com.asciiraider.g710.view;

import com.asciiraider.g710.model.level.LevelModelGroup;
import com.asciiraider.g710.model.menu.MenuModel;

public interface ViewFactory {
    ViewState<MenuModel> createMenuView();
    ViewState<LevelModelGroup> createLevelView();
}
