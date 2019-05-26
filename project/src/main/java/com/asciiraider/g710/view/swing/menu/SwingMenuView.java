package com.asciiraider.g710.view.swing.menu;

import com.asciiraider.g710.model.menu.MenuModel;
import com.asciiraider.g710.view.KeyPressEvent;
import com.asciiraider.g710.view.swing.SwingStateView;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class SwingMenuView extends SwingStateView<MenuModel> {


    private SwingMenuComponent menuComponent;


    public SwingMenuView(JFrame frame) {
        super(frame);

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
    public void draw(MenuModel model) {

        menuComponent.setMenuModel(model);

        frame.repaint();
    }
}
