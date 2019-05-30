package com.asciiraider.g710.view.swing.game;

import com.asciiraider.g710.model.level.LevelModelGroup;
import com.asciiraider.g710.view.KeyPressEvent;
import com.asciiraider.g710.view.swing.SwingResourceManager;
import com.asciiraider.g710.view.swing.SwingStateView;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class SwingGroupLevelView extends SwingStateView<LevelModelGroup> {

    private SwingLevelComponent levelComponent;
    private SwingInfoBarComponent infoBarComponent;

    public SwingGroupLevelView(JFrame frame, SwingResourceManager resourceManager) {
        super(frame);

        infoBarComponent = new SwingInfoBarComponent(resourceManager.getInfoBarResources());
        levelComponent = new SwingLevelComponent(resourceManager.getLevelResources());

        frame.getContentPane().add(infoBarComponent, "span 1, cell 0 0, width " + infoBarComponent.WIDTH + ", height " + infoBarComponent.HEIGHT);
        frame.getContentPane().add(levelComponent, "span 1, cell 0 1, width " + levelComponent.WIDTH + ", height " + levelComponent.HEIGHT);

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
