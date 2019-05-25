package com.asciiraider.g710.view.swing;

import com.asciiraider.g710.model.level.LevelModelGroup;
import com.asciiraider.g710.view.Event;
import com.asciiraider.g710.view.KeyPressEvent;
import com.asciiraider.g710.view.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class SwingView extends View<LevelModelGroup> {

    JFrame frame;

    SwingLevelComponent levelComponent;
    SwingInfoBarComponent infoBarComponent;

    private Queue<Event> eventQueue = new LinkedList<>();

    public SwingView(int level_width, int level_height) {
        frame = new JFrame("Ascii Raider");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

        infoBarComponent = new SwingInfoBarComponent();
        levelComponent = new SwingLevelComponent();
        //frame.add(infoBarComponent);
        frame.add(levelComponent);

        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent keyEvent) {
                eventQueue.add(KeyPressEvent.handleSwing(keyEvent));
            }
        });
        frame.requestFocusInWindow();

        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void draw(LevelModelGroup model) {

        this.infoBarComponent.setInfoBarModel(model.getInfoBarModel());
        this.levelComponent.setLevelModel(model.getLevelModel());

        frame.repaint();
    }

    @Override
    public java.util.List<Event> getEventsList() {
        java.util.List<Event> events = new ArrayList<>();
        while (!eventQueue.isEmpty()) {
            events.add(eventQueue.remove());
        }
        return events;
    }

    @Override
    public void exit() {
        frame.setVisible(false);
        frame.dispose();
    }
}
