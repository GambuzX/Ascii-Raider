package com.asciiraider.g710.view.swing;

import com.asciiraider.g710.model.level.LevelModelGroup;
import com.asciiraider.g710.view.Event;
import com.asciiraider.g710.view.KeyPressEvent;
import com.asciiraider.g710.view.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.util.LinkedList;
import java.util.Queue;

public class SwingView extends View<LevelModelGroup> implements KeyListener {

    JFrame frame;

    SwingLevelComponent levelComponent;
    SwingInfoBarComponent infoBarComponent;

    private Queue<Event> eventQueue = new LinkedList<>();

    public SwingView(int level_width, int level_height) {
        frame = new JFrame("Ascii Raider");
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

        infoBarComponent = new SwingInfoBarComponent();
        levelComponent = new SwingLevelComponent();
        frame.add(infoBarComponent);
        frame.add(levelComponent);

        frame.pack();
        frame.setVisible(true);

        //KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(this);
        frame.addKeyListener(this);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.requestFocusInWindow();
    }

    @Override
    public void draw(LevelModelGroup model) {

        this.infoBarComponent.setInfoBarModel(model.getInfoBarModel());
        this.levelComponent.setLevelModel(model.getLevelModel());

        frame.repaint();
    }

    @Override
    public Event getKey() {
        if (!eventQueue.isEmpty()) return eventQueue.remove();
        return null;
    }

    @Override
    public void exit() {
        frame.setVisible(false);
        frame.dispose();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        eventQueue.add(KeyPressEvent.handleSwing(e));
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
