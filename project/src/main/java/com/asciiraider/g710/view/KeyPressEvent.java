package com.asciiraider.g710.view;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;

import java.awt.event.KeyEvent;

import static com.asciiraider.g710.view.Event.*;

public class KeyPressEvent {

    public static Event handleLanterna(KeyStroke key) {
        if (key.getKeyType() == KeyType.ArrowUp) return UP_KEY;
        if (key.getKeyType() == KeyType.ArrowRight) return RIGHT_KEY;
        if (key.getKeyType() == KeyType.ArrowDown) return DOWN_KEY;
        if (key.getKeyType() == KeyType.ArrowLeft) return LEFT_KEY;
        if (key.getKeyType() == KeyType.Character && key.getCharacter() == 'q') return Q_KEY;
        if (key.getKeyType() == KeyType.Character && key.getCharacter() == 'r') return R_KEY;
        if (key.getKeyType() == KeyType.EOF) return EOF;
        return null;
    }

    public static Event handleSwing(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) return UP_KEY;
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) return RIGHT_KEY;
        if (e.getKeyCode() == KeyEvent.VK_LEFT) return LEFT_KEY;
        if (e.getKeyCode() == KeyEvent.VK_DOWN) return DOWN_KEY;
        if (e.getKeyCode() == KeyEvent.VK_Q) return Q_KEY;
        if (e.getKeyCode() == KeyEvent.VK_R) return R_KEY;
        return null;
    }

}
