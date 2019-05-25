package com.asciiraider.g710.view;

import com.asciiraider.g710.model.Model;
import com.googlecode.lanterna.screen.TerminalScreen;

public abstract class ViewState<M extends Model> extends View<M> {
	public abstract Event getKey();
	public abstract void exit();
	public abstract TerminalScreen getScreen();
}
