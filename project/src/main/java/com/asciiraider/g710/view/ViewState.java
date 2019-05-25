package com.asciiraider.g710.view;

import com.asciiraider.g710.model.Model;

import java.util.List;

public abstract class ViewState<M extends Model> extends View<M> {
	public abstract List<Event> getEventsList();
	public abstract void exit();
}
