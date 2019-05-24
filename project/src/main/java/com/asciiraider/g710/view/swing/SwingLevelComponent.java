package com.asciiraider.g710.view.swing;

import com.asciiraider.g710.controller.level.LevelFacade;
import com.asciiraider.g710.model.element.Element;
import com.asciiraider.g710.model.level.LevelModel;
import com.asciiraider.g710.view.Event;
import com.asciiraider.g710.view.View;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class SwingLevelComponent extends JPanel {

    private final static int SIZE_FACTOR = 60;
    private final static int N_ROWS = 12;
    private final static int N_COLS = 18;

    private final static int WIDTH = N_COLS * SIZE_FACTOR;
    private final static int HEIGHT = N_ROWS * SIZE_FACTOR;

    private LevelModel levelModel;

    public void setLevelModel(LevelModel levelModel) {
        this.levelModel = levelModel;
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(WIDTH, HEIGHT);
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        if (levelModel == null) return;

        LevelFacade levelFacade = new LevelFacade(levelModel);
        for (Element ele : levelFacade.getElements())
            drawElement(graphics, ele);

    }

    public void drawElement(Graphics graphics, Element ele) {
        //System.out.println("tried to draw");
        URL resource = SwingLevelComponent.class.getResource("/symbols/twitter.png");
        BufferedImage image;
        try {
            image = ImageIO.read(resource);
            graphics.drawImage(image, ele.getPosition().getX() * SIZE_FACTOR, ele.getPosition().getY() * SIZE_FACTOR, null);
        } catch(IOException e) {}
    }
}
