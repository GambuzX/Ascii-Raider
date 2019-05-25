package com.asciiraider.g710.view;

import com.asciiraider.g710.model.Model;

public abstract class View<M extends Model> {

    public abstract void draw(M model);
}
