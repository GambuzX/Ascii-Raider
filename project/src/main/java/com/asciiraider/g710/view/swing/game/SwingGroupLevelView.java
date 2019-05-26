package com.asciiraider.g710.view.swing.game;

import com.asciiraider.g710.model.level.LevelModelGroup;
import com.asciiraider.g710.view.Event;
import com.asciiraider.g710.view.KeyPressEvent;
import com.asciiraider.g710.view.ViewState;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SwingGroupLevelView extends ViewState<LevelModelGroup> {

    private SwingLevelComponent levelComponent;
    private SwingInfoBarComponent infoBarComponent;

    private JFrame frame;

    private Queue<Event> eventQueue = new LinkedList<>();

    public SwingGroupLevelView(JFrame frame) {
        this.frame = frame;

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
    public List<Event> getEventsList() {
        List<Event> events = new ArrayList<>();
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
