package com.asciiraider.g710.view.swing;

import com.asciiraider.g710.model.element.Element;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class SwingElement extends JComponent {

    private Element element;

    public SwingElement(Element element) {
        this.element = element;
    }

    public void setElement(Element element) {
        this.element = element;
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(40,40);
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        //if (element != null) drawElement(graphics);
    }
/*
    public void drawElement(Graphics graphics) {
        System.out.println("tried to draw");
        URL resource = SwingElement.class.getResource("/symbols/twitter.png");
        BufferedImage image;
        try {
            image = ImageIO.read(resource);
            //graphics.drawRect(10, 10, 80, 80);
            graphics.drawImage(image, 0, 0, null);
        } catch(IOException e) {}
    }*/
}
