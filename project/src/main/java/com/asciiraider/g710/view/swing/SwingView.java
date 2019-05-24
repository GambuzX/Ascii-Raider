package com.asciiraider.g710.view.swing;

import com.asciiraider.g710.model.level.LevelModelGroup;
import com.asciiraider.g710.view.Event;
import com.asciiraider.g710.view.KeyPressEvent;
import com.asciiraider.g710.view.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class SwingView extends View<LevelModelGroup> implements KeyEventDispatcher{

    JFrame frame;

    SwingLevelComponent levelComponent;
    //SwingInfoBarView infoBarView;

    private Queue<Event> eventQueue = new LinkedList<>();

    public SwingView(int level_width, int level_height) {
        frame = new JFrame("Ascii Raider");
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

        //infoBarView = new SwingInfoBarView(frame);
        levelComponent = new SwingLevelComponent();
        frame.add(levelComponent);


        frame.pack();
        frame.setVisible(true);

        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(this);
    }

    @Override
    public void draw(LevelModelGroup model) {

        this.levelComponent.setLevelModel(model.getLevelModel());
        //infoBarView.draw(model.getInfoBarModel());

        frame.repaint();
    }

    @Override
    public Event getKey() {
        if (!eventQueue.isEmpty()) return eventQueue.remove();
        return null;
    }

    @Override
    public void exit() {

    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent e) {
        eventQueue.add(KeyPressEvent.handleSwing(e));
        return true;
    }
}
