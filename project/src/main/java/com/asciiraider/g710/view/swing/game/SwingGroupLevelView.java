package com.asciiraider.g710.view.swing.game;

import com.asciiraider.g710.model.level.LevelModelGroup;
import com.asciiraider.g710.view.event.KeyPressEvent;
import com.asciiraider.g710.view.swing.SwingStateView;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class SwingGroupLevelView extends SwingStateView<LevelModelGroup> {

    private SwingLevelComponent levelComponent;
    private SwingInfoBarComponent infoBarComponent;

    public SwingGroupLevelView(JFrame frame, SwingLevelComponent levelComponent, SwingInfoBarComponent infoBarComponent) {
        super(frame);

        this.infoBarComponent = infoBarComponent;
        this.levelComponent = levelComponent;

        frame.getContentPane().add(infoBarComponent, "span 1, cell 0 0, width " + SwingInfoBarComponent.WIDTH + ", height " + SwingInfoBarComponent.HEIGHT);
        frame.getContentPane().add(levelComponent, "span 1, cell 0 1, width " + SwingLevelComponent.WIDTH + ", height " + SwingLevelComponent.HEIGHT);

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
