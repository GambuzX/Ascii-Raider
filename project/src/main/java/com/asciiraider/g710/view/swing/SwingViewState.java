package com.asciiraider.g710.view.swing;

import com.asciiraider.g710.model.Model;
import com.asciiraider.g710.view.ViewState;

import javax.swing.*;

public abstract class SwingViewState<M extends Model> extends ViewState<M,JFrame> {
	public abstract JFrame getScreen();
}
