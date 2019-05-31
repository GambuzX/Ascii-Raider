package com.asciiraider.g710.view.swing.gameover;

import com.asciiraider.g710.model.gameover.GameOverModel;
import com.asciiraider.g710.view.KeyPressEvent;
import com.asciiraider.g710.view.swing.SwingStateView;
import com.asciiraider.g710.view.swing.resources.SwingResourceManager;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class SwingGameOverView extends SwingStateView<GameOverModel> {

    private SwingGameOverComponent gameOverComponent;

    public SwingGameOverView(JFrame frame, SwingResourceManager resourceManager) {
        super(frame);

        gameOverComponent = new SwingGameOverComponent(resourceManager.getGameOverResources());
        gameOverComponent.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent keyEvent) {
                eventQueue.add(KeyPressEvent.handleSwing(keyEvent));
            }
        });
        gameOverComponent.setFocusable(true);

        frame.getContentPane().add(gameOverComponent, "cell 0 0, width " + gameOverComponent.WIDTH + ", height " + gameOverComponent.HEIGHT);

        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void draw(GameOverModel model) {
        gameOverComponent.setGameOverModel(model);
        frame.repaint();
    }
}
