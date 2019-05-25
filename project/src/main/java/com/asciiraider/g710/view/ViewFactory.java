package com.asciiraider.g710.view;

import com.asciiraider.g710.model.level.LevelModelGroup;
import com.asciiraider.g710.model.menu.MenuModel;

public interface ViewFactory {
    // TODO: por isto a obrigar que seja ViewState: talvez fazer mais uma entre Lanterna e Swing
    ViewState<MenuModel> createMenuView();
    ViewState<LevelModelGroup> createLevelView();

}
