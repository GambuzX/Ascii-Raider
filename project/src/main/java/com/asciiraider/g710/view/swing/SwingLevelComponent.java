package com.asciiraider.g710.view.swing;

import com.asciiraider.g710.model.level.LevelModel;
import com.asciiraider.g710.model.utilities.Position;

import javax.swing.*;
import java.awt.*;

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

        SwingElementView swingElementView = new SwingElementView(graphics, symbolMapper, SIZE_FACTOR);

        for (int row = 0; row < rows; row++)
            for (int col = 0; col < cols; col++)
                swingElementView.draw(levelModel.findElement(new Position(col, row)));

    }
}
