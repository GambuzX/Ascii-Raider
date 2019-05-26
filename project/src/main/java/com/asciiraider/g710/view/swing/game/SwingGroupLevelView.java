package com.asciiraider.g710.view.swing.game;

import com.asciiraider.g710.model.level.LevelModelGroup;
import com.asciiraider.g710.view.KeyPressEvent;
import com.asciiraider.g710.view.swing.SwingStateView;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class SwingGroupLevelView extends SwingStateView<LevelModelGroup> {

    private SwingLevelComponent levelComponent;
    private SwingInfoBarComponent infoBarComponent;

    public SwingGroupLevelView(JFrame frame) {
        super(frame);

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
}
