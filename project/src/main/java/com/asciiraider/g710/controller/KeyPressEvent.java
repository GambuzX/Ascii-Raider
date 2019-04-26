package com.asciiraider.g710.controller;

import com.asciiraider.g710.model.element.Movable;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;

public class KeyPressEvent {

    public static void handle(KeyStroke key, Movable movable) {
        if (key.getKeyType() == KeyType.ArrowUp) movable.moveUp();
        if (key.getKeyType() == KeyType.ArrowRight) movable.moveRight();
        if (key.getKeyType() == KeyType.ArrowDown) movable.moveDown();
        if (key.getKeyType() == KeyType.ArrowLeft) movable.moveLeft();
    }

}
