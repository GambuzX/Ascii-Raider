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

public class SwingLevelView extends View<LevelModel> {

    private JPanel panel;

    public SwingLevelView(JPanel panel) {
        this.panel = panel;
    }

    @Override
    public void draw(LevelModel model) {
        Graphics graphics = panel.getGraphics();

        // TODO: ver isto
        LevelFacade levelModelF = new LevelFacade(model);

        for (Element ele : levelModelF.getElements())
            drawElement(graphics, ele);
    }

    @Override
    public Event getKey() {
        return null;
    }

    @Override
    public void exit() {
        return;
    }

    public void drawElement(Graphics graphics, Element element) {
        URL resource = SwingLevelView.class.getResource(SymbolMapper.symbolResource(element.getSymbol().getAscii()));
        BufferedImage image = null;
        try {
            image = ImageIO.read(resource);
            graphics.drawImage(image, element.getPosition().getX(), element.getPosition().getY(), null);
        } catch(IOException e) {}
    }
}
