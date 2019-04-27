package com.asciiraider.g710.model.element;

import com.asciiraider.g710.model.utilities.Position;

public interface Movable {
    Position moveUp();
    Position moveDown();
    Position moveLeft();
    Position moveRight();
}
