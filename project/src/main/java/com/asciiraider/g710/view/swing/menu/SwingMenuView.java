package com.asciiraider.g710.view.swing.menu;

import com.asciiraider.g710.model.menu.MenuModel;
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

public class SwingMenuView extends ViewState<MenuModel> {

    private JFrame frame;

    private SwingMenuComponent menuComponent;

    private Queue<Event> eventQueue = new LinkedList<>();

    public SwingMenuView(JFrame frame) {
        this.frame = frame;

        menuComponent = new SwingMenuComponent();
        menuComponent.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent keyEvent) {
                eventQueue.add(KeyPressEvent.handleSwing(keyEvent));
            }
        });
        menuComponent.setFocusable(true);

        frame.getContentPane().add(menuComponent);

        frame.pack();
        frame.setVisible(true);
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

    @Override
    public void draw(MenuModel model) {

        menuComponent.setMenuModel(model);

        frame.repaint();
    }
}
