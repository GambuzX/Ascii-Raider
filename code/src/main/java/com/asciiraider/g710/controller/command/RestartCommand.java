package com.asciiraider.g710.controller.command;

import com.asciiraider.g710.controller.Game;
import com.asciiraider.g710.controller.state.MenuState;
import com.asciiraider.g710.model.menu.MenuModel;

public class RestartCommand extends ButtonCommand {
    public RestartCommand(Game game) {
        super(game);
    }

    @Override
    public void execute() {
        game.changeState(new MenuState(game, new MenuModel()));
    }
}
