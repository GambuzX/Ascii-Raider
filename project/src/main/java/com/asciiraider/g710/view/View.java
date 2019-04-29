package com.asciiraider.g710.view;

import com.asciiraider.g710.model.Model;

import java.io.IOException;

public abstract class View<M extends Model> {

    public abstract void draw(M model) throws IOException;
    public abstract Event getKey();

}
