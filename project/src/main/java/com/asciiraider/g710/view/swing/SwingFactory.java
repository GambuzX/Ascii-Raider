package com.asciiraider.g710.view.swing;

import com.asciiraider.g710.view.View;
import com.asciiraider.g710.view.ViewFactory;

public class SwingFactory implements ViewFactory {
    @Override
    public View createView(int width, int height) {
        return new SwingView(width, height);
    }
}
