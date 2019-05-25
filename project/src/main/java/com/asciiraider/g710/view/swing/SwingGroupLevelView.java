package com.asciiraider.g710.view.swing;

import com.asciiraider.g710.model.level.LevelModelGroup;
import com.asciiraider.g710.view.Event;
import com.asciiraider.g710.view.KeyPressEvent;
import com.asciiraider.g710.view.ViewState;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SwingGroupLevelView extends ViewState<LevelModelGroup> {

    JFrame frame;

    SwingLevelComponent levelComponent;
    SwingInfoBarComponent infoBarComponent;

    private Queue<Event> eventQueue = new LinkedList<>();

    // TODO: ver melhor o que precisa de ser aqui e o que e no factory
    public SwingGroupLevelView() {
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
