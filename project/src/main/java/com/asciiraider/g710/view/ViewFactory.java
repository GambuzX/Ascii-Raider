package com.asciiraider.g710.view;

public interface ViewFactory {
    // TODO: por isto a obrigar que seja ViewState: talvez fazer mais uma entre Lanterna e Swing
    ViewState createView(int width, int height);
}
