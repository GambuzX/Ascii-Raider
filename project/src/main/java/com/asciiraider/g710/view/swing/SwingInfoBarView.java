package com.asciiraider.g710.view.swing;

import com.asciiraider.g710.model.infobar.InfoBarModel;
import com.asciiraider.g710.view.Event;
import com.asciiraider.g710.view.View;

import javax.swing.*;

public class SwingInfoBarView extends View<InfoBarModel> {

    private JPanel panel;

    public SwingInfoBarView(JFrame frame) {
        this.panel = new JPanel();
        this.panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        frame.getContentPane().add(panel);


        panel.add(new JButton("Button 2"));
        panel.add(new JButton("Button 2"));
        panel.add(new JButton("Button 2"));
        panel.add(new JButton("Button 2"));

        panel.setVisible(true);
    }

    @Override
    public void draw(InfoBarModel model) {
        return;
    }

    @Override
    public Event getKey() {
        return null;
    }

    @Override
    public void exit() {

    }
}
