package com.asciiraider.g710.view.swing;

import com.asciiraider.g710.model.infobar.InfoBarModel;
import com.asciiraider.g710.view.Event;
import com.asciiraider.g710.view.View;

import javax.swing.*;

public class SwingInfoBarView extends View<InfoBarModel> {

    private JPanel panel;

    public SwingInfoBarView(JPanel panel) {
        this.panel = panel;
    }

    @Override
    public void draw(InfoBarModel model) {

    }

    @Override
    public Event getKey() {
        return null;
    }

    @Override
    public void exit() {

    }
}
