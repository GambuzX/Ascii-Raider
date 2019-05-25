package com.asciiraider.g710.view.lanterna;

import com.asciiraider.g710.view.View;
import com.asciiraider.g710.view.ViewFactory;

import java.io.IOException;

public class LanternaFactory implements ViewFactory {
    @Override
    public View createView(int width, int height) {
        try {
            return new LanternaView(width, height);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
