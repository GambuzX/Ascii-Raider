package com.asciiraider.g710.view.lanterna;

import com.asciiraider.g710.model.Model;
import com.asciiraider.g710.view.ViewState;
import com.googlecode.lanterna.screen.TerminalScreen;

public abstract class LanternaViewState<M extends Model> extends ViewState<M,TerminalScreen> {

	public abstract TerminalScreen getScreen();
}
