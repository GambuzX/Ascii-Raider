package com.asciiraider.g710.view.swing;

import com.asciiraider.g710.model.level.LevelModelGroup;
import com.asciiraider.g710.view.Event;
import com.asciiraider.g710.view.View;

import javax.swing.*;

public class SwingView extends View<LevelModelGroup> {

    JFrame frame;

    SwingLevelComponent levelComponent;
    //SwingInfoBarView infoBarView;

    public SwingView(int level_width, int level_height) {
        frame = new JFrame("Ascii Raider");
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

        //infoBarView = new SwingInfoBarView(frame);
        levelComponent = new SwingLevelComponent();
        frame.add(levelComponent);

        /*KeyEventDispatcher keyEventDispatcher = e -> {
            System.out.println("key pressed");
            return false;
        };
        KeyboardFocusManager
                .getCurrentKeyboardFocusManager()
                .addKeyEventDispatcher(keyEventDispatcher);*/
        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void draw(LevelModelGroup model) {

        this.levelComponent.setLevelModel(model.getLevelModel());
        //infoBarView.draw(model.getInfoBarModel());

        frame.repaint();
    }

    @Override
    public Event getKey() {
        return null;
    }

    @Override
    public void exit() {

    }

}
