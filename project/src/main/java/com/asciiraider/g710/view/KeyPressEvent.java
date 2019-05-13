package com.asciiraider.g710.view;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;

import static com.asciiraider.g710.view.Event.*;

public class KeyPressEvent {

    public static Event handle(KeyStroke key) {
        if (key.getKeyType() == KeyType.ArrowUp) return UP_KEY;
        if (key.getKeyType() == KeyType.ArrowRight) return RIGHT_KEY;
        if (key.getKeyType() == KeyType.ArrowDown) return DOWN_KEY;
        if (key.getKeyType() == KeyType.ArrowLeft) return LEFT_KEY;
        if (key.getKeyType() == KeyType.ArrowLeft) return LEFT_KEY;
        if (key.getKeyType() == KeyType.Character && key.getCharacter() == 'q') return Q_KEY;
        if (key.getKeyType() == KeyType.Character && key.getCharacter() == 'r') return R_KEY;
        if (key.getKeyType() == KeyType.EOF) return EOF;
        return null;
    }

}
