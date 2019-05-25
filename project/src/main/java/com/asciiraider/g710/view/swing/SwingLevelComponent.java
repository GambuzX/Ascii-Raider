package com.asciiraider.g710.view.swing;

import com.asciiraider.g710.controller.level.LevelFacade;
import com.asciiraider.g710.model.element.Element;
import com.asciiraider.g710.model.level.LevelModel;
import com.asciiraider.g710.model.utilities.Position;
import com.asciiraider.g710.view.Event;
import com.asciiraider.g710.view.KeyPressEvent;
import com.asciiraider.g710.view.View;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class SwingLevelComponent extends JPanel {

    private final static int SIZE_FACTOR = 60;
    private int rows;
    private int cols;

    private LevelModel levelModel;
    private SymbolMapper symbolMapper;

    public SwingLevelComponent(int rows, int cols) {
        symbolMapper = new SymbolMapper();
        this.rows = rows;
        this.cols = cols;
    }

    public void setLevelModel(LevelModel levelModel) {
        this.levelModel = levelModel;
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(cols * SIZE_FACTOR, rows * SIZE_FACTOR);
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        if (levelModel == null) return;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                drawElement(graphics, levelModel.findElement(new Position(col,row)), col, row);
            }
        }

    }

    public void drawElement(Graphics graphics, Element ele, int x, int y) {
        graphics.drawImage(symbolMapper.getElementImage(ele), x * SIZE_FACTOR, y * SIZE_FACTOR, null);
    }
}
